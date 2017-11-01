package com.zuikc.domain;

import java.util.Date;

/*
 * �������
 * */
public class ProjectNeed {
	private Integer needID;
	private String needName;
	private Project project;// ��Ŀ����
	private String simpleDesc;// ������
	private String detailDesc;// ��ϸ����
	private Date startdate;// ���ʱ��
	private Date modifydate;// �޸�ʱ��
	private String comments;// ��ע

	public ProjectNeed() {
		super();
	}
	
	public ProjectNeed(Integer needID) {
		super();
		this.needID = needID;
	}


	public ProjectNeed(Integer needID, String needName, Project project, String simpleDesc, String detailDesc,
			Date startdate, Date modifydate, String comments) {
		super();
		this.needID = needID;
		this.needName = needName;
		this.project = project;
		this.simpleDesc = simpleDesc;
		this.detailDesc = detailDesc;
		this.startdate = startdate;
		this.modifydate = modifydate;
		this.comments = comments;
	}


	public Integer getNeedID() {
		return needID;
	}

	public void setNeedID(Integer needID) {
		this.needID = needID;
	}

	public String getNeedName() {
		return needName;
	}

	public void setNeedName(String needName) {
		this.needName = needName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSimpleDesc() {
		return simpleDesc;
	}

	public void setSimpleDesc(String simpleDesc) {
		this.simpleDesc = simpleDesc;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ProjectNeed [needID=" + needID + ", needName=" + needName + ", project=" + project + ", simpleDesc="
				+ simpleDesc + ", detailDesc=" + detailDesc + ", startdate=" + startdate + ", modifydate=" + modifydate
				+ ", comments=" + comments + "]";
	}

}
