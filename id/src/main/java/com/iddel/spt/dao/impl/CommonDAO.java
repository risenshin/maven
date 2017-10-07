package com.iddel.spt.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iddel.spt.dao.ICommonDAO;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.template.TemplateDataRowMapper;
import com.iddel.spt.template.TemplateRow;

@Repository
public class CommonDAO implements ICommonDAO {

	ISPTLogger log = SPTLog4jLogger.getInstance(getClass().getName());

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TemplateRow> getTemplateRowDetails(String query) {
		return namedParameterJdbcTemplate.query(query, new TemplateDataRowMapper());
	}

	@Override
	public List<TemplateRow> getTemplateRowDetails(String query, MapSqlParameterSource params) {
		return namedParameterJdbcTemplate.query(query, params, new TemplateDataRowMapper());
	}

}
