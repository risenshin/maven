package com.iddel.spt.model;

public class UserProjectFormData {
	private int userProjectFormId;
	private int questionId;
	private String ansValue;
	private String ansType;
	private String createdBy;
	private java.util.Date createdDate;
	private String updatedBy;
	private java.util.Date updateDate;

	public int getUserProjectFormId() {
		return userProjectFormId;
	}

	public void setUserProjectFormId(int userProjectFormId) {
		this.userProjectFormId = userProjectFormId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnsValue() {
		return ansValue;
	}

	public void setAnsValue(String ansValue) {
		this.ansValue = ansValue;
	}

	public String getAnsType() {
		return ansType;
	}

	public void setAnsType(String ansType) {
		this.ansType = ansType;
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

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "UserProjectFormData [userProjectFormId=" + userProjectFormId + ", questionId=" + questionId
				+ ", ansValue=" + ansValue + ", ansType=" + ansType + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updateDate=" + updateDate + "]";
	}

}