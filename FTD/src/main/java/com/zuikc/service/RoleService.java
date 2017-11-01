package com.zuikc.service;

/*
 * 角色操作
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Role;

public interface RoleService {
	// 添加角色
	public void addRole(Role r);

	// 修改角色
	public void updateRole(Role r);

	// 删除
	public void deleteRole(Role r);

	// 批量禁用角色
	public void switchStatusRoles(String[] RoleIDs);

	// 分页查询
	public List<Role> queryRoleByPage(Page p);
	
	// 查询所有
	public List<Role> queryAllRole();

	// 查询单个角色
	public Role queryRoleByID(Role r);
	

	/*
	 * 条件查询 参数：查询的字段名， 关键字
	 */
	public List<Role> queryRoleByCriteria(String attrName, String attrValue, Page p);

	// 获取记录数
	public int getRows(Role r);
}
