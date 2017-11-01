package com.zuikc.domain;

/*
 * 菜单资源
 * */
public class Resource {
	private Integer resourceID;
	private String resourceNumber;// 菜单资源编号： resources01 唯一
	private String resourceName;// 菜单资源名称：
	private Resource parent;// 父菜单： 顶级菜单？？
	private String resourcePath;// 菜单资源路径：
	private String status;// 状态
	private String comments;// 备注：

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
