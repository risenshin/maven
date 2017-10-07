package com.iddel.spt.model;

public class UserProjects {
	private int projectId;
	private int userId;
	private String projectName;
	private String projectDesc;
	private String createdBy;
	private java.util.Date createdDate;
	private String updatedBy;
	private java.util.Date updateDate;

	public UserProjects(Integer userId, String projectName, String projectDesc) {
		this.userId = userId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
	}

	public UserProjects() {
		// TODO Auto-generated constructor stub
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public String toString() {
		return "UserProjects [projectId=" + projectId + ", userId=" + userId + ", projectName=" + projectName
				+ ", projectDesc=" + projectDesc + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updateDate=" + updateDate + "]";
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
}