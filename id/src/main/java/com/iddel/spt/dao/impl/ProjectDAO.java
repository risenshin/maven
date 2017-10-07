package com.iddel.spt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.iddel.spt.QueryConstants;
import com.iddel.spt.TableConstants;
import com.iddel.spt.dao.ICommonDAO;
import com.iddel.spt.dao.IProjectDAO;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.template.TemplateRow;
import com.iddel.spt.util.QueryUtils;

@Repository
public class ProjectDAO implements IProjectDAO {

	ISPTLogger log = SPTLog4jLogger.getInstance(getClass().getName());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ICommonDAO commonDAO;
	
	@Override
	public UserProjects addProject(Integer userId, String projectName, String projectDesc) throws InternalException {
		return addProject(new UserProjects(userId, projectName, projectDesc));
	}

	@Override
	public UserProjects addProject(UserProjects project) throws InternalException {
		Map<String, Object> params = new HashMap<>();

		params.put(TableConstants.PROJECT_DESC, project.getProjectDesc());
		params.put(TableConstants.USER_ID, project.getUserId());
		params.put(TableConstants.PROJECT_NAME, project.getProjectName());

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate)
				.withTableName(TableConstants.USER_PROJECTS).usingGeneratedKeyColumns(TableConstants.PROJECT_ID);

		int projectId = jdbcInsert.executeAndReturnKey(params).intValue();

		log.info("Project added for info:[{}]", project);

		return getProjectInfo(projectId);

	}

	private String addFormsToProject = "INSERT INTO user_project_forms (PROJECT_ID,FORM_TYPE_ID) VALUES (:PROJECT_ID, :FORM_TYPE_ID)";

	@Override
	public int addFormsToProject(Integer projectId, List<Integer> formList) {

		List<SqlParameterSource> parameters = new ArrayList<>();

		for (Integer formTypeId : formList) {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue(TableConstants.PROJECT_ID, projectId);
			params.addValue(TableConstants.FORM_TYPE_ID, formTypeId);

			parameters.add(params);
		}

		int arr[] = namedParameterJdbcTemplate.batchUpdate(addFormsToProject,
				parameters.toArray(new SqlParameterSource[0]));

		return arr.length;

	}

	private String getProjectInfo = "Select * from user_projects where project_id = :" + TableConstants.PROJECT_ID;

	@Override
	public UserProjects getProjectInfo(Integer projectId) throws InternalException {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.PROJECT_ID, projectId);
		UserProjects project = null;

		try {
			project = namedParameterJdbcTemplate.queryForObject(getProjectInfo, namedParameters,
					new RowMapper<UserProjects>() {

						@Override
						public UserProjects mapRow(ResultSet rs, int rowNum) throws SQLException {
							UserProjects project = new UserProjects();
							project.setUserId(rs.getInt(TableConstants.USER_ID));
							project.setProjectId(rs.getInt(TableConstants.PROJECT_ID));
							project.setProjectName(rs.getString(TableConstants.PROJECT_NAME));
							project.setProjectDesc(rs.getString(TableConstants.PROJECT_DESC));
							return project;
						}

					});
		} catch (EmptyResultDataAccessException e) {
			throw new InternalException("Project not found");
		}
		return project;
	}

	private String removeProject = "delete from " + TableConstants.USER_PROJECTS + " where userEmail = :"
			+ TableConstants.PROJECT_ID;

	@Override
	public boolean removeProject(Integer projectId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.PROJECT_ID, projectId);

		namedParameterJdbcTemplate.update(removeProject, namedParameters);

		return true;
	}

	private String getProjectListByUserId = "Select * from user_projects where user_id = :" + TableConstants.USER_ID;

	@Override
	public List<UserProjects> getProjectListByUserId(Integer userId) throws InternalException {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.USER_ID, userId);
		List<UserProjects> projectList = null;

		try {
			projectList = namedParameterJdbcTemplate.query(getProjectListByUserId, namedParameters,
					new RowMapper<UserProjects>() {

						@Override
						public UserProjects mapRow(ResultSet rs, int rowNum) throws SQLException {
							UserProjects project = new UserProjects();
							project.setUserId(rs.getInt(TableConstants.USER_ID));
							project.setProjectId(rs.getInt(TableConstants.PROJECT_ID));
							project.setProjectName(rs.getString(TableConstants.PROJECT_NAME));
							project.setProjectDesc(rs.getString(TableConstants.PROJECT_DESC));
							return project;
						}

					});
		} catch (EmptyResultDataAccessException e) {
			throw new InternalException("No Projects found for the user..");
		}
		return projectList;
	}

	@Override
	public UserProjects getProjectInfoByUserIdProjectName(Integer userId, String projectName) throws InternalException {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.USER_ID, userId);
		namedParameters.addValue(TableConstants.PROJECT_NAME, projectName);

		String query = getProjectListByUserId + QueryConstants.AND + TableConstants.PROJECT_NAME + QueryConstants.EQUAL
				+ QueryConstants.COLON + TableConstants.PROJECT_NAME + QueryUtils.limit(1);
		return getProjectInfo(query, namedParameters);
	}

	@Override
	public UserProjects getProjectInfoByUserIdProjectId(Integer userId, Integer projectId) throws InternalException {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.USER_ID, userId);
		namedParameters.addValue(TableConstants.PROJECT_ID, projectId);

		String query = getProjectListByUserId + QueryConstants.AND + TableConstants.PROJECT_ID + QueryConstants.EQUAL
				+ QueryConstants.COLON + TableConstants.PROJECT_ID + QueryUtils.limit(1);
		return getProjectInfo(query, namedParameters);
	}

	private UserProjects getProjectInfo(String query, MapSqlParameterSource namedParameters) throws InternalException {
		UserProjects project = null;
		try {
			project  = namedParameterJdbcTemplate.query(query, namedParameters, new ResultSetExtractor<UserProjects>() {

				@Override
				public UserProjects extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						UserProjects tempProject = new UserProjects();
						tempProject.setUserId(rs.getInt(TableConstants.USER_ID));
						tempProject.setProjectId(rs.getInt(TableConstants.PROJECT_ID));
						tempProject.setProjectName(rs.getString(TableConstants.PROJECT_NAME));
						tempProject.setProjectDesc(rs.getString(TableConstants.PROJECT_DESC));
						return tempProject;
					}
					return null;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			throw new InternalException("No Projects found for the input criteria..");
		}
		return project;
	}
	
	private String getFormListByProject = "SELECT f.FORM_TYPE_ID as id, f.* FROM user_projects p join user_project_forms pf using (project_id) join form_types f using(form_type_id) where p.PROJECT_ID = :" + TableConstants.PROJECT_ID + "p.user_id=:" + TableConstants.USER_ID;

	@Override
	public List<TemplateRow> getFormListByProject(Integer userId, Integer projectId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue(TableConstants.PROJECT_ID, projectId);
		params.addValue(TableConstants.USER_ID, userId);
		
		return commonDAO.getTemplateRowDetails(getFormListByProject, params );
	}

}
