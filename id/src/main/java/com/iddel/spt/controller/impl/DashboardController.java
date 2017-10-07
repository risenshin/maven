package com.iddel.spt.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iddel.spt.controller.IDashboardController;
import com.iddel.spt.dto.GenericDTO;
import com.iddel.spt.exception.IncorrectCredentialsException;
import com.iddel.spt.exception.IncorrectInputException;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.logger.ISPTLogger;
import com.iddel.spt.logger.SPTLog4jLogger;
import com.iddel.spt.model.Users;
import com.iddel.spt.service.IDashboardService;
import com.iddel.spt.util.Util;

@RestController
public class DashboardController implements IDashboardController {

	ISPTLogger log = SPTLog4jLogger.getInstance(getClass().getName());

	@Autowired
	private IDashboardService dashboardService;

	@Override
	public ResponseEntity<GenericDTO<List<Users>>> getUserInfo(@RequestHeader String userEmail){
		GenericDTO<List<Users>> genericDTO = null;
		List<Users> userList = new ArrayList<>();
		try {
			Users user = dashboardService.getUserInfo(userEmail);
			userList.add(user);
			String message = "Successfully retrieved user detail";
			HttpResponseStatus responseStatus = HttpResponseStatus.OK;
			genericDTO = Util.setGenericDTO(userList, message, responseStatus);

		} catch (IncorrectInputException | InternalException e) {
			genericDTO = Util.setGenericDTO(userList, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<List<Users>>> login(@RequestHeader String userEmail,
			@RequestParam String password){
		log.info("Email :" + userEmail);
		GenericDTO<List<Users>> genericDTO = null;
		List<Users> userList = new ArrayList<Users>();
		try {
			Users user = dashboardService.login(userEmail, password);

			userList.add(user);
			genericDTO = Util.setGenericDTO(userList, "User Logged in successfully");
		} catch (IncorrectCredentialsException | InternalException e) {
			genericDTO = Util.setGenericDTO(userList, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<Boolean>> changePassword(@RequestHeader String userEmail,
			@RequestParam String oldPassword, @RequestParam String newPassword){
		log.info("Email :" + userEmail);
		GenericDTO<Boolean> genericDTO = null;
		try {
			Boolean value = dashboardService.changePassword(userEmail, oldPassword, newPassword);

			genericDTO = Util.setGenericDTO(value, "User Logged in successfully");
		} catch (IncorrectCredentialsException | IncorrectInputException | InternalException e) {
			genericDTO = Util.setGenericDTO(false, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<GenericDTO<Boolean>> register(@RequestHeader String userEmail, @RequestBody Users user)
	{
		log.info("Email :" + user.getUserEmail());
		GenericDTO<Boolean> genericDTO = null;
		try {
			Boolean value = dashboardService.register(user);

			genericDTO = Util.setGenericDTO(value, "User added successfully");
		} catch (IncorrectInputException | InternalException e) {
			genericDTO = Util.setGenericDTO(false, e);
		}
		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<Boolean>> unregister(@RequestHeader String userEmail,
			@RequestParam String password)

	{
		log.info("Email :" + userEmail);
		GenericDTO<Boolean> genericDTO = null;
		try {
			Boolean value = dashboardService.unregister(userEmail, password);

			genericDTO = Util.setGenericDTO(value, "User Logged in successfully");
		} catch (IncorrectCredentialsException | IncorrectInputException | InternalException e) {
			genericDTO = Util.setGenericDTO(false, e);
		}
		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

}
