package com.zuikc.test;
/*
 * 测试菜单资源操作
 * */
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;
import com.zuikc.service.ResourceService;

public class TestResource {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	ResourceService rs = (ResourceService) ac.getBean("resourceService");

	@Test
	public void testAdd() {
		//Resource res = new Resource(1, "resource01", "项目管理", null, null, "启用", "无");
		Resource res = new Resource(2, "resource02", "基本信息管理", rs.queryResourceByID(new Resource(1)), "/resources.jsp", "启用", "无");
		rs.addResource(res);
	}
	
	@Test
	public void testQuery() throws Exception {
		Resource resource = rs.queryResourceByID(new Resource(2));
		System.out.println(resource);
	}
	
	@Test
	public void testUpdate() throws Exception {
		rs.switchStatusResources(new String[]{"1","2","3","4"});
	}
	
	@Test
	public void testGetRows() throws Exception {
		Resource r = new Resource();
		r.setResourceName("项目管理");
		int rows = rs.getRows(r);
		System.out.println(rows);
	}
	
	@Test
	public void testCriteriaQuery() throws Exception {
		String attrName = "resourceName";
		String attrValue = "项目管理";
		Page p = new Page();
		p.setRows(4);
		p.setCunrrentPage(1);
		
		List<Resource> list = rs.queryResourceByCriteria(attrName, attrValue, p);
		for (Resource Resource : list) {
			System.out.println(Resource);
		}
	}
	
	@Test
	public void testParentResource() throws Exception {
		List<Resource> list = rs.queryParentResources();
		for (Resource resource : list) {
			System.out.println(resource);
		}
	}
}
