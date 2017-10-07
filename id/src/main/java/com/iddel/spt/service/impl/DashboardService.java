package com.iddel.spt.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddel.spt.dao.IUserDAO;
import com.iddel.spt.exception.IncorrectCredentialsException;
import com.iddel.spt.exception.IncorrectInputException;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.Users;
import com.iddel.spt.service.IDashboardService;

@Service
public class DashboardService implements IDashboardService {

	ISPTLogger logger = SPTLog4jLogger.getInstance(getClass().getName());

	@Autowired
	private IUserDAO userDAO;

	@Override
	public Users login(String userEmail, String password) throws IncorrectCredentialsException, InternalException {
		try {
			Users user = userDAO.getUserInfo(userEmail);
			if (user.getUserPassword().equals(password)) {
				logger.info("Passwords Match, return user info");
				return user;
			} else {
				throw new IncorrectCredentialsException();
			}
		} catch (EmptyResultDataAccessException e) {
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean register(Users user) throws IncorrectInputException, InternalException {
		if (StringUtils.isEmpty(user.getUserEmail()) || StringUtils.isEmpty(user.getUserPassword()))
			throw new IncorrectInputException();
		Users tempUser = null;
		try {
			tempUser = userDAO.getUserInfo(user.getUserEmail());
		} catch (InternalException e) {
			//dont do anything here.. we wanted the exception to happen so that we are sure that the user did not existed..
		}
		// try to add the user now
		if(tempUser != null)
			throw new InternalException ("user already exists..");
		
		return userDAO.addUser(user);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean unregister(String userEmail, String password)
			throws IncorrectInputException, IncorrectCredentialsException, InternalException {
		validateUserInfo(userEmail, password);
		return userDAO.removeUser(userEmail);

	}

	private boolean validateUserInfo(String userEmail, String password)
			throws IncorrectInputException, IncorrectCredentialsException, InternalException {
		if (StringUtils.isEmpty(userEmail) || StringUtils.isEmpty(password))
			throw new IncorrectInputException();

		Users user = userDAO.getUserInfo(userEmail);
		if (user == null || !user.getUserPassword().equals(password))
			throw new IncorrectCredentialsException();

		return true;
	}

	@Override
	public Users getUserInfo(String userEmail) throws IncorrectInputException, InternalException {
		if (StringUtils.isEmpty(userEmail))
			throw new IncorrectInputException();
		return userDAO.getUserInfo(userEmail);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean changePassword(String userEmail, String oldPassword, String newPassword)
			throws IncorrectCredentialsException, IncorrectInputException, InternalException {
		validateUserInfo(userEmail, oldPassword);
		if (StringUtils.isEmpty(newPassword))
			throw new IncorrectInputException("New password is empty");

		return userDAO.updatePassword(userEmail, newPassword);
	}

}
