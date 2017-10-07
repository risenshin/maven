package com.iddel.spt.service;

import java.util.List;

import com.iddel.spt.exception.InternalException;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.template.TemplateRow;

public interface IProjectService {

	UserProjects createProject(String userEmail, String projectName, String projectDesc, List<Integer> formList)
			throws InternalException;

	List<UserProjects> getProjectList(String userEmail) throws InternalException;

	boolean deleteProject(String userEmail, Integer projectId) throws InternalException;

	List<TemplateRow> getFormListByProject(String userEmail, Integer projectId) throws InternalException;
}
