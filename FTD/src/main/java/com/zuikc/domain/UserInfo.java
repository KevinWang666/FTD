package com.zuikc.domain;

import java.util.Date;

/*
 * 用户信息
 * */
public class UserInfo {
	private Integer userID;
	private String username;
	private String truename;// 真名
	private String pwd;
	private String job;// 职位
	private String sex;// 性别
	private Integer age;
	private String cellphone;
	private Date hiredate;
	private String identificationNumber;// 身份证号码
	private String status;// 状态： 正常
	private Role role;// 角色
	private String comments;// 备注

	public UserInfo() {
		super();
	}
	
	public UserInfo(Integer userID) {
		super();
		this.userID = userID;
	}

	public UserInfo(Integer userID, String username, String truename, String pwd, String job, String sex, Integer age,
			String cellphone, Date hiredate, String identificationNumber, String status, Role role, String comments) {
		super();
		this.userID = userID;
		this.username = username;
		this.truename = truename;
		this.pwd = pwd;
		this.job = job;
		this.sex = sex;
		this.age = age;
		this.cellphone = cellphone;
		this.hiredate = hiredate;
		this.identificationNumber = identificationNumber;
		this.status = status;
		this.role = role;
		this.comments = comments;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", username=" + username + ", truename=" + truename + ", pwd=" + pwd
				+ ", job=" + job + ", sex=" + sex + ", age=" + age + ", cellphone=" + cellphone + ", hiredate="
				+ hiredate + ", identificationNumber=" + identificationNumber + ", status=" + status + ", role=" + role
				+ ", comments=" + comments + "]";
	}

}
