package com.iddel.spt.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class TemplateDataRowMapper implements RowMapper<TemplateRow> {

	@Override
	public TemplateRow mapRow(ResultSet rs, int arg1) throws SQLException {
		TemplateRow row = new TemplateRow();
		row.setCmspkId(rs.getInt("id"));
		Map<String, Object> rowMap = row.getAdditionalProperties();

		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

			rowMap.put(rs.getMetaData().getColumnName(i), rs.getObject(i));

		}

		return row;
	}

}
