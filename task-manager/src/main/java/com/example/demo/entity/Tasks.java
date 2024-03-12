package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tasks")
@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Integer taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "created_on", insertable = true, updatable = false)
	private Timestamp createdOn = new Timestamp(System.currentTimeMillis());

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "active_flag")
	private String activeFlag;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "collaborator_email")
	private String collaboratorEmail;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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
