package com.iddel.spt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.iddel.spt.TableConstants;
import com.iddel.spt.dao.IUserDAO;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.Users;

@Repository
public class UserDAO implements IUserDAO {

	ISPTLogger log = SPTLog4jLogger.getInstance(getClass().getName());

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${user.info.by.email}")
	private String userInfoByEmail;

	@Override
	public boolean addUser(Users user) {
		Map<String, Object> params = new HashMap<>();

		params.put(TableConstants.USER_ADDRESS, user.getUserAddress());
		params.put(TableConstants.IS_ADMIN, user.getIsAdmin());
		params.put(TableConstants.USER_COUNTRY, user.getUserCountry());
		params.put(TableConstants.USER_EMAIL, user.getUserEmail());
		params.put(TableConstants.USER_FIRST_NAME, user.getUserFirstName());
		params.put(TableConstants.USER_LAST_NAME, user.getUserLastName());
		params.put(TableConstants.USER_PASSWORD, user.getUserPassword());
		params.put(TableConstants.USER_PHONE, user.getUserPhone());
		params.put(TableConstants.USER_STATUS, user.getUserStatus());

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName(TableConstants.USERS)
				.usingGeneratedKeyColumns(TableConstants.USER_ID);

		jdbcInsert.executeAndReturnKey(params).intValue();

		log.info("User added for info:[{}]", user);

		return true;

	}

	@Override
	public Users getUserInfo(String userEmail) throws InternalException {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userEmail", userEmail);
		Users user = null;

		try {
			user = namedParameterJdbcTemplate.queryForObject(userInfoByEmail, namedParameters, new RowMapper<Users>() {

				@Override
				public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
					Users user = new Users();
					user.setUserId(rs.getInt("USER_ID"));
					user.setUserFirstName(rs.getString("USER_FIRST_NAME"));
					user.setUserLastName(rs.getString("USER_LAST_NAME"));
					user.setUserEmail(rs.getString("USER_EMAIL"));
					user.setUserPassword(rs.getString("USER_PASSWORD"));
					user.setUserAddress(rs.getString(TableConstants.USER_ADDRESS));
					user.setUserCountry(rs.getString(TableConstants.USER_COUNTRY));
					user.setIsAdmin(rs.getByte(TableConstants.IS_ADMIN));
					user.setUserPhone(rs.getString(TableConstants.USER_PHONE));
					user.setUserStatus(rs.getString(TableConstants.USER_STATUS));
					return user;
				}

			});
		} catch (EmptyResultDataAccessException e) {
			throw new InternalException("User not found");
		}
		return user;
	}

	private String removeUser = "delete from users where userEmail = :USER_EMAIL";

	@Override
	public boolean removeUser(String userEmail) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.USER_EMAIL, userEmail);

		namedParameterJdbcTemplate.update(removeUser, namedParameters);

		return true;
	}

	private String updatePassword = "update users set USER_PASSWORD = :USER_PASSWORD where userEmail = :USER_EMAIL";

	@Override
	public boolean updatePassword(String userEmail, String newPassword) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue(TableConstants.USER_EMAIL, userEmail);
		namedParameters.addValue(TableConstants.USER_PASSWORD, newPassword);

		namedParameterJdbcTemplate.update(updatePassword, namedParameters);

		return true;
	}

}
