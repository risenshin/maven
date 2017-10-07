package com.iddel.spt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Tesst {

	public static void main(String[] args) {
		/*List<SqlParameterSource> parameters = new ArrayList<>();

		List<Integer> formList = new ArrayList<>();
		formList.add(1);
		formList.add(2);
		for (Integer formTypeId : formList) {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue(TableConstants.PROJECT_ID, 1);
			params.addValue(TableConstants.FORM_TYPE_ID, formTypeId);

			parameters.add(params);
		}

		SqlParameterSource arr[] = parameters.toArray(new SqlParameterSource[0]);
		System.out.println(arr);
		
		List<Map<String, Object>> parameters = new ArrayList<>();

		for (Integer formTypeId : formList) {
			Map<String, Object> params = new HashMap<>();
			params.put(TableConstants.PROJECT_ID, projectId);
			params.put(TableConstants.FORM_TYPE_ID, formTypeId);
			
			parameters.add(params);
		}

		int arr[] = namedParameterJdbcTemplate.batchUpdate(addFormsToProject, parameters.toArray(Map<String,Object>));
		
		return arr.length;
*/
	}

}
