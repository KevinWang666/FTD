package com.zuikc.domain;

import java.util.Date;

/*
 * ��Ŀģ��
 * */
public class ProjectModel {
	private Integer modelID;
	private String modelName;
	private ProjectNeed projectNeed;// ��Ŀ��������
	private String priority;// ���ȼ�
	private String simpleDesc;// ������
	private String detailDesc;// ��ϸ����
	private Date startdate;// ���ʱ��
	private Date modifydate;// �޸�ʱ��
	private String comments;// ��ע

	public ProjectModel() {
		super();
	}
	
	public ProjectModel(Integer modelID) {
		super();
		this.modelID = modelID;
	}

	public ProjectModel(Integer modelID, String modelName, ProjectNeed projectNeed, String priority, String simpleDesc,
			String detailDesc, Date startdate, Date modifydate, String comments) {
		super();
		this.modelID = modelID;
		this.modelName = modelName;
		this.projectNeed = projectNeed;
		this.priority = priority;
		this.simpleDesc = simpleDesc;
		this.detailDesc = detailDesc;
		this.startdate = startdate;
		this.modifydate = modifydate;
		this.comments = comments;
	}

	public Integer getModelID() {
		return modelID;
	}

	public void setModelID(Integer modelID) {
		this.modelID = modelID;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public ProjectNeed getProjectNeed() {
		return projectNeed;
	}

	public void setProjectNeed(ProjectNeed projectNeed) {
		this.projectNeed = projectNeed;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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
		return "ProjectModel [modelID=" + modelID + ", modelName=" + modelName + ", projectNeed=" + projectNeed
				+ ", priority=" + priority + ", simpleDesc=" + simpleDesc + ", detailDesc=" + detailDesc
				+ ", startdate=" + startdate + ", modifydate=" + modifydate + ", comments=" + comments + "]";
	}

}
