package com.zuikc.domain;

import java.util.Date;

/*
 * 项目表
 * */
public class Project {
	private Integer projectID;
	private String projectName;//项目名
	private Customer customer;//客户公司
	private UserInfo user;//项目经理：待定。。。
	private Integer developerNumber ;//开发人数
	private	Date pubdate;//开始时间
	private	Date modifydate;//最近更新时间
	private Integer cost;//成本
	private	Date finishdate;//计划完成时间
	private String level ;//级别
	private String status;//状态
	private String comments;//备注
	public Project() {
		super();
	}
	
	public Project(Integer projectID) {
		super();
		this.projectID = projectID;
	}

	public Project(Integer projectID, String projectName, Customer customer, UserInfo user, Integer developerNumber,
			Date pubdate, Date modifydate, Integer cost, Date finishdate, String level, String status,
			String comments) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.customer = customer;
		this.user = user;
		this.developerNumber = developerNumber;
		this.pubdate = pubdate;
		this.modifydate = modifydate;
		this.cost = cost;
		this.finishdate = finishdate;
		this.level = level;
		this.status = status;
		this.comments = comments;
	}
	public Integer getProjectID() {
		return projectID;
	}
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Integer getDeveloperNumber() {
		return developerNumber;
	}
	public void setDeveloperNumber(Integer developerNumber) {
		this.developerNumber = developerNumber;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Date getFinishdate() {
		return finishdate;
	}
	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", customer=" + customer + ", user="
				+ user + ", developerNumber=" + developerNumber + ", pubdate=" + pubdate + ", modifydate=" + modifydate
				+ ", cost=" + cost + ", finishdate=" + finishdate + ", level=" + level + ", status=" + status
				+ ", comments=" + comments + "]";
	}
	
}
