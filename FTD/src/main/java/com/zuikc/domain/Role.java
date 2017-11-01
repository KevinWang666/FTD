package com.zuikc.domain;

import java.util.List;

/*
 * ��ɫ
 * */
public class Role {
	private Integer roleID;//��ɫID
	private String roleNumber;//��ɫ��ţ� role01  Ψһ
	private String roleName ;//��ɫ���ƣ� 	����Ա
	private String status;//״̬�� ����/����
	private List<Resource> resources;//���˵���Դ���ϣ� 	
	private String comments;//��ע�� 	���� 
	public Role() {
		super();
	}
	
	public Role(Integer roleID) {
		super();
		this.roleID = roleID;
	}

	public Role(Integer roleID, String roleNumber, String roleName, String status, List<Resource> resources,
			String comments) {
		super();
		this.roleID = roleID;
		this.roleNumber = roleNumber;
		this.roleName = roleName;
		this.status = status;
		this.resources = resources;
		this.comments = comments;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getRoleNumber() {
		return roleNumber;
	}
	public void setRoleNumber(String roleNumber) {
		this.roleNumber = roleNumber;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleNumber=" + roleNumber + ", roleName=" + roleName + ", status=" + status
				+ ", resources=" + resources + ", comments=" + comments + "]";
	}
	
}
