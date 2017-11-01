package com.zuikc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuikc.domain.Page;
import com.zuikc.domain.Role;
import com.zuikc.service.RoleService;

public class TestRole {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	RoleService rs = (RoleService) ac.getBean("roleService");

	@Test
	public void testAdd() {
		rs.addRole(new Role(null, "role004", "≥Ã–Ú‘≥", "Ω˚”√", null, "¿¡µ√–¥"));
	}
	
	@Test
	public void testQuery() throws Exception {
		Role role = rs.queryRoleByID(new Role(2));
		System.out.println(role);
	}
	
	@Test
	public void testUpdate() throws Exception {
		rs.switchStatusRoles(new String[]{"1","2","3","4"});
	}
	
	@Test
	public void testGetRows() throws Exception {
		Role r = new Role();
		r.setRoleName("≥Ã–Ú‘≥");
		int rows = rs.getRows(r);
		System.out.println(rows);
	}
	
	@Test
	public void testCriteriaQuery() throws Exception {
		String attrName = "roleName";
		String attrValue = "≥Ã–Ú‘≥";
		Page p = new Page();
		p.setRows(4);
		p.setCunrrentPage(1);
		
		List<Role> list = rs.queryRoleByCriteria(attrName, attrValue, p);
		for (Role role : list) {
			System.out.println(role);
		}
	}
}
