package com.iddel.spt.model;

public class FormQuestions {
	private int FORM_TYPE_ID;
	private int QUESTION_ID;
	private String createdBy;
	private java.util.Date createdDate;
	private String updatedBy;
	private java.util.Date updateDate;

	public int getFORM_TYPE_ID() {
		return FORM_TYPE_ID;
	}

	public void setFORM_TYPE_ID(int fORM_TYPE_ID) {
		FORM_TYPE_ID = fORM_TYPE_ID;
	}

	public int getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(int qUESTION_ID) {
		QUESTION_ID = qUESTION_ID;
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
		return "FormQuestions [FORM_TYPE_ID=" + FORM_TYPE_ID + ", QUESTION_ID=" + QUESTION_ID + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updateDate=" + updateDate
				+ "]";
	}
}