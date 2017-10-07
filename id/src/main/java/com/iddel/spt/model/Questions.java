package com.iddel.spt.model;

public class Questions {
	private String question;
	private String questionType;
	private String uiDisplayType;
	private String createdBy;
	private java.util.Date createdDate;
	private String updatedBy;
	private java.util.Date updateDate;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getUiDisplayType() {
		return uiDisplayType;
	}

	public void setUiDisplayType(String uiDisplayType) {
		this.uiDisplayType = uiDisplayType;
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
		return "Questions [question=" + question + ", questionType=" + questionType + ", uiDisplayType=" + uiDisplayType
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updateDate=" + updateDate + "]";
	}
}