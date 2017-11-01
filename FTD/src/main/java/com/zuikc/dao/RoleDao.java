package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Role;

public interface RoleDao {
	// ��ӽ�ɫ
	public void addRole(Role r);

	// �޸Ľ�ɫ
	public void updateRole(Role r);

	// ɾ����ɫ
	public void deleteRole(Role r);

	// ��ҳ��ѯ
	public List<Role> queryRoleByPage(Page p);
	//��ѯ����
	public List<Role> queryAllRole();

	// ��ѯ������ɫ
	public Role queryRoleByID(Role r);

	// ������ѯ
	public List<Role> queryRoleByCriteria(String attrName, String attrValue, Page p);

	// ��ȡ��¼��
	public int getRows(Role r);
}
