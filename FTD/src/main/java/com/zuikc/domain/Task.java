package com.zuikc.domain;

import java.util.Date;

/*
 * ����
 * */
public class Task {
	private Integer taskID;
	private String taskname;// �������
	private ProjectFunction projectFunction;
	private UserInfo pubUser;// ������
	private UserInfo exeUser;// ִ����
	private String priority;// ���ȼ�
	private String status;// ״̬ : ������..
	private Date startdate;
	private Date finishdate;
	private String desc;// ��ϸ����

	public Task() {
		super();
	}
	
	public Task(Integer taskID) {
		super();
		this.taskID = taskID;
	}

	public Task(Integer taskID, String taskname, ProjectFunction projectFunction, UserInfo pubUser, UserInfo exeUser,
			String priority, String status, Date startdate, Date finishdate, String desc) {
		super();
		this.taskID = taskID;
		this.taskname = taskname;
		this.projectFunction = projectFunction;
		this.pubUser = pubUser;
		this.exeUser = exeUser;
		this.priority = priority;
		this.status = status;
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.desc = desc;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public ProjectFunction getProjectFunction() {
		return projectFunction;
	}

	public void setProjectFunction(ProjectFunction projectFunction) {
		this.projectFunction = projectFunction;
	}

	public UserInfo getPubUser() {
		return pubUser;
	}

	public void setPubUser(UserInfo pubUser) {
		this.pubUser = pubUser;
	}

	public UserInfo getExeUser() {
		return exeUser;
	}

	public void setExeUser(UserInfo exeUser) {
		this.exeUser = exeUser;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", taskname=" + taskname + ", projectFunction=" + projectFunction
				+ ", pubUser=" + pubUser + ", exeUser=" + exeUser + ", priority=" + priority + ", status=" + status
				+ ", startdate=" + startdate + ", finishdate=" + finishdate + ", desc=" + desc + "]";
	}

}
