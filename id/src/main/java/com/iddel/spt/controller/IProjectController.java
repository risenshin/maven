package com.iddel.spt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iddel.spt.dto.GenericDTO;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.template.TemplateRow;

import io.swagger.annotations.ApiParam;

public interface IProjectController {

	@RequestMapping(value = "/createproject", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<GenericDTO<List<UserProjects>>> createProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectName", required = true) @RequestParam String projectName,
			@ApiParam(value = "projectDesc", required = true) @RequestParam String projectDesc,
			@ApiParam(value = "formList", required = false) @RequestBody List<Integer> formList);

	@RequestMapping(value = "/getprojectlist", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<GenericDTO<List<UserProjects>>> getProjectList(@RequestHeader String userEmail);

	@RequestMapping(value = "project/{projectId}/formlist", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<GenericDTO<List<TemplateRow>>> getFormListByProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectId", required = true) @PathVariable(value = "projectId") Integer projectId);

	@RequestMapping(value = "project/{projectId}/addformlist", produces = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<GenericDTO<List<TemplateRow>>> modifyFormListByProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectId", required = true) @PathVariable(value = "projectId") Integer projectId,
			@ApiParam(value = "formList", required = true) @RequestParam List<Integer> formList);

	@RequestMapping(value = "/deleteproject", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<GenericDTO<Boolean>> deleteProject(@RequestHeader String userEmail,
			@ApiParam(value = "projectId", required = true) @RequestParam Integer projectId);


	@RequestMapping(value = "project/{projectId}/form/{formId}/saveformdata", produces = {
	"application/json" }, method = RequestMethod.GET)
GenericDTO<List<TemplateRow>> saveFormData(@RequestHeader String userEmail,
		@ApiParam(value = "projectId", required = true) @PathVariable(value = "projectId") Integer projectId,
	@ApiParam(value = "formId", required = true) @PathVariable(value = "formId") Integer formId);

}
