package com.iddel.spt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddel.spt.dao.IProjectDAO;
import com.iddel.spt.dao.IUserDAO;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.model.Users;
import com.iddel.spt.service.IProjectService;
import com.iddel.spt.template.TemplateRow;

@Service
public class ProjectService implements IProjectService{

	ISPTLogger logger = SPTLog4jLogger.getInstance(getClass().getName());

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IProjectDAO projectDAO;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserProjects createProject(String userEmail, String projectName, String projectDesc, List<Integer> formList)
			throws InternalException {
		
		Users user = userDAO.getUserInfo(userEmail);
		
		UserProjects project = projectDAO.getProjectInfoByUserIdProjectName(user.getUserId(), projectName);
		if(project != null)
			throw new InternalException("Project already with same name exists for this user.. please try with a different name");
		
		project = projectDAO.addProject(user.getUserId(), projectName, projectDesc);
		projectDAO.addFormsToProject(project.getProjectId(), formList);

		return project;
	}

	@Override
	public List<UserProjects> getProjectList(String userEmail) throws InternalException {
		Users user = userDAO.getUserInfo(userEmail);
		return projectDAO.getProjectListByUserId(user.getUserId());
	}

	@Override
	public List<TemplateRow> getFormListByProject(String userEmail, Integer projectId) throws InternalException {
		Users user = userDAO.getUserInfo(userEmail);
//		projectDAO.getProjectInfoByUserIdProjectId(user.getUserId(), projectId); 
		return projectDAO.getFormListByProject(user.getUserId(), projectId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public List<TemplateRow> modifyFormListByProject(String userEmail, Integer projectId, List<Integer> formList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteProject(String userEmail, Integer projectId) throws InternalException {
		//check if user exists
		Users user = userDAO.getUserInfo(userEmail);
		
		projectDAO.getProjectInfoByUserIdProjectId(user.getUserId(), projectId);
		return projectDAO.removeProject(projectId);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<TemplateRow> saveFormData(String userEmail, Integer projectId, Integer formId) {
		// TODO Auto-generated method stub
		return null;
	}

}
