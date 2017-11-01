package com.zuikc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuikc.domain.ProjectNeed;
import com.zuikc.service.ProjectNeedService;

public class TestProjectModel {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	ProjectNeedService pns = (ProjectNeedService) ac.getBean("projectNeedService");
	
	@Test
	public void testAjax() {
		List<ProjectNeed> list = pns.queryProjectNeedByProjectID(2);
		System.out.println("===================================================");
		if (list != null) {
			for (ProjectNeed projectNeed : list) {
				System.out.println(projectNeed);
			}
		}
	}

}
