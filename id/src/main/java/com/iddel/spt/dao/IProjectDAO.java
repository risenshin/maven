package com.iddel.spt.dao;

import java.util.List;

import com.iddel.spt.exception.InternalException;
import com.iddel.spt.model.UserProjects;
import com.iddel.spt.template.TemplateRow;

public interface IProjectDAO {

	UserProjects addProject(Integer userId, String projectName, String projectDesc) throws InternalException;
	UserProjects addProject(UserProjects project) throws InternalException;

	UserProjects getProjectInfo(Integer projectId) throws InternalException;

	boolean removeProject(Integer projectId);
	List<UserProjects> getProjectListByUserId(Integer userId) throws InternalException;
	int addFormsToProject(Integer projectId, List<Integer> formList);
	List<TemplateRow> getFormListByProject(Integer userId, Integer projectId);
	UserProjects getProjectInfoByUserIdProjectName(Integer userId, String projectName) throws InternalException;
	UserProjects getProjectInfoByUserIdProjectId(Integer userId, Integer projectId) throws InternalException;

}
