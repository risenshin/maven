package com.iddel.spt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iddel.spt.dto.GenericDTO;
import com.iddel.spt.model.Users;

public interface IDashboardController {

	@RequestMapping(value = "/login", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<GenericDTO<List<Users>>> login(@RequestHeader String userEmail, @RequestParam String password);

	@RequestMapping(value = "/register", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<GenericDTO<Boolean>> register(@RequestHeader String userEmail, @RequestBody Users user);

	@RequestMapping(value = "/unregister", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<GenericDTO<Boolean>> unregister(@RequestHeader String userEmail, @RequestParam String password);

	@RequestMapping(value = "/getusers", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<GenericDTO<List<Users>>> getUserInfo(@RequestHeader String userEmail);

	@RequestMapping(value = "/changePassword", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<GenericDTO<Boolean>> changePassword(@RequestHeader String userEmail, @RequestParam String oldPassword,
			@RequestParam String newPassword);

}
