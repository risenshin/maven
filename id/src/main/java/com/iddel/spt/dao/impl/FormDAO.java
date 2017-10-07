package com.iddel.spt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iddel.spt.TableConstants;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.FormTypes;

@Repository
public class FormDAO {
	ISPTLogger log = SPTLog4jLogger.getInstance(getClass().getName());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String getAllFormTypes = "Select * from " + TableConstants.FORM_TYPES;
	public List<FormTypes> getAllFormTypes() throws InternalException{
		List<FormTypes> formTypeList = null;

		try {
			formTypeList = namedParameterJdbcTemplate.query(getAllFormTypes, new RowMapper<FormTypes>() {

						@Override
						public FormTypes mapRow(ResultSet rs, int rowNum) throws SQLException {
							FormTypes formType = new FormTypes();
							formType.setFormTypeId(rs.getInt(TableConstants.FORM_TYPE_ID));
							formType.setFormName(rs.getString(TableConstants.FORM_NAME));
							formType.setFormDesc(rs.getString(TableConstants.FORM_DESC));
							return formType;
						}

					});
		} catch (EmptyResultDataAccessException e) {
			throw new InternalException("No Forms found ..");
		}
		return formTypeList;
	}
}
