package com.zuikc.domain;

import java.util.Date;

/*
 * ��Ŀ����
 * */
public class ProjectFunction {
	private Integer functionID;
	private String functionName;
	private ProjectModel projectModel;//��Ŀģ������
	private String priority;//���ȼ�
	private String simpleDesc;//������
	private String detailDesc;//��ϸ����
	private Date startdate;//���ʱ��
	private Date modifydate;//�޸�ʱ��
	private String comments;//��ע
	public ProjectFunction() {
		super();
	}
	
	public ProjectFunction(Integer functionID) {
		super();
		this.functionID = functionID;
	}


	public ProjectFunction(Integer functionID, String functionName, ProjectModel projectModel, String priority,
			String simpleDesc, String detailDesc, Date startdate, Date modifydate, String comments) {
		super();
		this.functionID = functionID;
		this.functionName = functionName;
		this.projectModel = projectModel;
		this.priority = priority;
		this.simpleDesc = simpleDesc;
		this.detailDesc = detailDesc;
		this.startdate = startdate;
		this.modifydate = modifydate;
		this.comments = comments;
	}
	public Integer getFunctionID() {
		return functionID;
	}
	public void setFunctionID(Integer functionID) {
		this.functionID = functionID;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public ProjectModel getProjectModel() {
		return projectModel;
	}
	public void setProjectModel(ProjectModel projectModel) {
		this.projectModel = projectModel;
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
		return "ProjectFunction [functionID=" + functionID + ", functionName=" + functionName + ", projectModel="
				+ projectModel + ", priority=" + priority + ", simpleDesc=" + simpleDesc + ", detailDesc=" + detailDesc
				+ ", startdate=" + startdate + ", modifydate=" + modifydate + ", comments=" + comments + "]";
	}
	
}
