package com.zuikc.service.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.TaskDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.TaskService;

@Service("taskService")
@Transactional
public class TaskServiceImp implements TaskService {
	@Resource(name="taskDao")
	private TaskDao td;
	
	@Override
	public int getRows(String status , String cid, String keyword) {
		return td.getRows(status , cid, keyword);
	}

	@Override
	public List<Task> queryTaskByCriteria(String status ,String cid, String keyword, String orderby, Page page) {
		return td.queryTaskByCriteria(status , cid, keyword, orderby, page);
	}

	@Override
	public Task queryTaskByID(Task t) {
		return td.queryTaskByID(t);
	}

	@Override
	public void addTask(Task t) {
		t.setStatus("未开始");
		td.addTask(t);
	}

	@Override
	public void updateTask(Task t) {
		td.updateTask(t);
	}

	@Override
	public void deleteTasks(String[] taskIDs) {
		if (taskIDs != null) {
			for (String string : taskIDs) {
				td.deleteTask(new Task(Integer.parseInt(string)));
			}
		}
	}

	@Override
	public void startTask(Task t) {
		Task task = td.queryTaskByID(t);
		task.setStartdate(new Date(System.currentTimeMillis()));
		task.setStatus("进行中");
	}

	@Override
	public void finishTask(Task t) {
		Task task = td.queryTaskByID(t);
		task.setFinishdate(new Date(System.currentTimeMillis()));
		task.setStatus("已完成");
	}

	@Override
	public List<Task> queryTaskByExeuser(UserInfo user , Page p) {
		return td.queryTaskByExeuser(user , p);
	}

	@Override
	public int getRowsByUser(UserInfo user) {
		return td.getRowsByUser(user);
	}

}
