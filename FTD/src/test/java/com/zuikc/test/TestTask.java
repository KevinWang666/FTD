package com.zuikc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.TaskService;

public class TestTask {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	TaskService ts = (TaskService) ac.getBean("taskService");
	
	@Test
	public void testAdd() {
		//int rows = ts.getRows("未开始", "taskname", "任务01");
		Task task = new Task();
		task.setStatus("未开始");
		task.setTaskname("任务01");
		task.setExeUser(new UserInfo(1));
		ts.addTask(task);
	}
	@Test
	public void testQuery() {
		int rows = ts.getRows("未开始", "taskname", "任务01");
		System.out.println(rows);
		Page p = new Page();
		p.setRows(10);
		p.setCunrrentPage(1);
		List<Task> list = ts.queryTaskByCriteria("未开始", "taskname", "任务01", "startdate", p);
		for (Task task : list) {
			System.out.println(task.getTaskname());
		}
		//System.out.println(list);
	}
	@Test
	public void testQueryByUser() {
		UserInfo user = new UserInfo(1);
		int rows = ts.getRowsByUser(user);
		System.out.println(rows);
		Page p = new Page();
		p.setRows(rows);
		p.setCunrrentPage(1);
		List<Task> list = ts.queryTaskByExeuser(user, p);
		for (Task task : list) {
			System.out.println(task.getTaskname());
		}
	}

}
