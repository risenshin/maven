package com.iddel.spt.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iddel.spt.controller.IProjectController;
import com.iddel.spt.dto.GenericDTO;
import com.iddel.spt.exception.IncorrectInputException;
import com.iddel.spt.exception.InternalException;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.service.IProjectService;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.template.TemplateRow;
import com.iddel.spt.util.Util;

import io.swagger.annotations.ApiParam;

@RestController
public class ProjectController implements IProjectController {

	@Autowired
	IProjectService projectService;

	@Override
	public ResponseEntity<GenericDTO<List<UserProjects>>> createProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectName", required = true) @RequestParam String projectName,
			@ApiParam(value = "projectDesc", required = true) @RequestParam String projectDesc,
			@ApiParam(value = "formList", required = false) @RequestBody List<Integer> formList) {
		GenericDTO<List<UserProjects>> genericDTO = null;
		List<UserProjects> userProjectList = new ArrayList<>();
		try {
			UserProjects userProject = projectService.createProject(userEmail, projectName, projectDesc, formList);
			userProjectList.add(userProject);
			String message = "Successfully retrieved userProject detail";
			HttpResponseStatus responseStatus = HttpResponseStatus.OK;
			genericDTO = Util.setGenericDTO(userProjectList, message, responseStatus);

		} catch (InternalException e) {
			genericDTO = Util.setGenericDTO(userProjectList, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<List<UserProjects>>> getProjectList(@RequestHeader String userEmail) {
		GenericDTO<List<UserProjects>> genericDTO = null;
		List<UserProjects> rows = null;
		try {
			rows = projectService.getProjectList(userEmail);
			String message = "Successfully retrieved userProject detail";
			HttpResponseStatus responseStatus = HttpResponseStatus.OK;
			genericDTO = Util.setGenericDTO(rows, message, responseStatus);

		} catch (InternalException e) {
			genericDTO = Util.setGenericDTO(rows, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<List<TemplateRow>>> getFormListByProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectId", required = true) @PathVariable(value = "projectId") Integer projectId) {
		GenericDTO<List<TemplateRow>> genericDTO = null;
		List<TemplateRow> rows = null;
		try {
			rows = projectService.getFormListByProject(userEmail, projectId);
			String message = "Successfully retrieved userProject detail";
			HttpResponseStatus responseStatus = HttpResponseStatus.OK;
			genericDTO = Util.setGenericDTO(rows, message, responseStatus);

		} catch (InternalException e) {
			genericDTO = Util.setGenericDTO(rows, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GenericDTO<List<TemplateRow>>> modifyFormListByProject(String userEmail, Integer projectId,
			List<Integer> formList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<GenericDTO<Boolean>> deleteProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectId", required = true) @RequestParam Integer projectId) {
		GenericDTO<Boolean> genericDTO = null;
		Boolean status = false;
		try {
			status = projectService.deleteProject(userEmail, projectId);
			String message;
			if (status = true)
				message = "Successfully removed the project..";
			else
				message = "Faile to remove the proeject..";
			HttpResponseStatus responseStatus = HttpResponseStatus.OK;
			genericDTO = Util.setGenericDTO(status, message, responseStatus);

		} catch (InternalException e) {
			genericDTO = Util.setGenericDTO(status, e);
		}

		return new ResponseEntity<>(genericDTO, HttpStatus.OK);
	}

	@Override
	public GenericDTO<List<TemplateRow>> saveFormData(String userEmail, Integer projectId, Integer formId) {
		// TODO Auto-generated method stub
		return null;
	}

}
