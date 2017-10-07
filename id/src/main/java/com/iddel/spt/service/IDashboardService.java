package com.iddel.spt.service;

import com.iddel.spt.exception.IncorrectCredentialsException;
import com.iddel.spt.exception.IncorrectInputException;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.model.Users;

public interface IDashboardService {
	public Users login(String userEmail, String password) throws IncorrectCredentialsException, InternalException;

	public boolean register(Users user) throws IncorrectInputException, InternalException;

	public boolean unregister(String userEmail, String password) throws IncorrectCredentialsException, IncorrectInputException, InternalException;

	public Users getUserInfo(String userEmail) throws IncorrectInputException, InternalException;

	public boolean changePassword(String userEmail, String oldPassword, String newPassword) throws  IncorrectCredentialsException, IncorrectInputException, InternalException;

}
