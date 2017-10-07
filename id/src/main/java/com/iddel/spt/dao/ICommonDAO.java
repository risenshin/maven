package com.iddel.spt.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.iddel.spt.template.TemplateRow;

public interface ICommonDAO {
	List<TemplateRow> getTemplateRowDetails(String query);
	List<TemplateRow> getTemplateRowDetails(String query, MapSqlParameterSource params);
}
