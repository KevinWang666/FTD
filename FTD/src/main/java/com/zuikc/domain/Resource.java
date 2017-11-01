package com.zuikc.domain;

/*
 * �˵���Դ
 * */
public class Resource {
	private Integer resourceID;
	private String resourceNumber;// �˵���Դ��ţ� resources01 Ψһ
	private String resourceName;// �˵���Դ���ƣ�
	private Resource parent;// ���˵��� �����˵�����
	private String resourcePath;// �˵���Դ·����
	private String status;// ״̬
	private String comments;// ��ע��

	public Resource() {
		super();
	}
	
	public Resource(Integer resourceID) {
		super();
		this.resourceID = resourceID;
	}

	public Resource(Integer resourceID, String resourceNumber, String resourceName, Resource parent,
			String resourcePath, String status, String comments) {
		super();
		this.resourceID = resourceID;
		this.resourceNumber = resourceNumber;
		this.resourceName = resourceName;
		this.parent = parent;
		this.resourcePath = resourcePath;
		this.status = status;
		this.comments = comments;
	}

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceNumber() {
		return resourceNumber;
	}

	public void setResourceNumber(String resourceNumber) {
		this.resourceNumber = resourceNumber;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
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
		return "Resource [resourceID=" + resourceID + ", resourceNumber=" + resourceNumber + ", resourceName="
				+ resourceName + ", parent=" + parent + ", resourcePath=" + resourcePath + ", status=" + status
				+ ", comments=" + comments + "]";
	}

}
