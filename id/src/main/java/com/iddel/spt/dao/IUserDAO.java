package com.iddel.spt.dao;

import com.iddel.spt.exception.InternalException;
import com.iddel.spt.model.Users;

public interface IUserDAO {
	
	Users getUserInfo(String userEmail) throws InternalException;

	boolean addUser(Users user);

	boolean removeUser(String userEmail);

	boolean updatePassword(String userEmail, String newPassword);

}
