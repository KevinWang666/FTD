package com.zuikc.domain;

import java.util.Date;

/*
 * ��Ŀ��
 * */
public class Project {
	private Integer projectID;
	private String projectName;//��Ŀ��
	private Customer customer;//�ͻ���˾
	private UserInfo user;//��Ŀ��������������
	private Integer developerNumber ;//��������
	private	Date pubdate;//��ʼʱ��
	private	Date modifydate;//�������ʱ��
	private Integer cost;//�ɱ�
	private	Date finishdate;//�ƻ����ʱ��
	private String level ;//����
	private String status;//״̬
	private String comments;//��ע
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
