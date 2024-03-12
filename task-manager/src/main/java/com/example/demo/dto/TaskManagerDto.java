package com.example.demo.dto;

import java.util.Date;

public class TaskManagerDto {

	private String taskName;

	private String activeFlag;

	private Date dueDate;

	private Integer userId;

	private String collaboratorEmail;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCollaboratorEmail() {
		return collaboratorEmail;
	}

	public void setCollaboratorEmail(String collaboratorEmail) {
		this.collaboratorEmail = collaboratorEmail;
	}
}
