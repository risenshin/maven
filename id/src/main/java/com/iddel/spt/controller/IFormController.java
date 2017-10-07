package com.iddel.spt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iddel.spt.dto.GenericDTO;
import com.iddel.spt.template.TemplateRow;

import io.swagger.annotations.ApiParam;

public interface IFormController {

	@RequestMapping(value = "/getallformlist", produces = { "application/json" }, method = RequestMethod.GET)
	GenericDTO<List<TemplateRow>> getAllFormList(@RequestHeader String userEmail);

	@RequestMapping(value = "form/{formId}/formquestions", produces = {
			"application/json" }, method = RequestMethod.GET)
	GenericDTO<List<TemplateRow>> getFormQuestions(@RequestHeader String userEmail,
			@ApiParam(value = "formId", required = true) @PathVariable(value = "formId") Integer formId);

}
