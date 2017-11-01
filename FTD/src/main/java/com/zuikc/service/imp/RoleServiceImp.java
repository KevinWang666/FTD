package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.RoleDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Role;
import com.zuikc.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImp implements RoleService {
	
	@Resource(name="roleDao")
	private RoleDao rd;
	
	@Override
	public void addRole(Role r) {
		rd.addRole(r);
	}

	@Override
	public void updateRole(Role r) {
		rd.updateRole(r);
	}

	@Override
	public void deleteRole(Role r) {
		rd.deleteRole(r);
	}

	@Override
	public void switchStatusRoles(String[] RoleIDs) {
		if (RoleIDs != null) {
			for (String id : RoleIDs) {
				Role role = rd.queryRoleByID(new Role(Integer.parseInt(id)));
				role.setStatus("½ûÓÃ");
			}
		}
	}

	@Override
	public List<Role> queryRoleByPage(Page p) {
		return rd.queryRoleByPage(p);
	}

	@Override
	public Role queryRoleByID(Role r) {
		return rd.queryRoleByID(r);
	}

	@Override
	public List<Role> queryRoleByCriteria(String attrName, String attrValue, Page p) {
		return rd.queryRoleByCriteria(attrName, attrValue, p);
	}

	@Override
	public int getRows(Role r) {
		return rd.getRows(r);
	}

	@Override
	public List<Role> queryAllRole() {
		return rd.queryAllRole();
	}

}
