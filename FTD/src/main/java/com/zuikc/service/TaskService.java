package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;

/*
 * 任务信息
 * */
public interface TaskService {
	//获取记录数
	int getRows(String status, String cid, String keyword);
	//条件查询
	List<Task> queryTaskByCriteria(String status, String cid, String keyword, String orderby, Page page);
	
	Task queryTaskByID(Task t);

	void addTask(Task t);

	void updateTask(Task t);

	void deleteTasks(String[] taskIDs);
	//开始任务
	void startTask(Task t);
	//完成任务
	void finishTask(Task t);
	//查询当前用户名下的任务条数
	int getRowsByUser(UserInfo user);
	//查询当前用户名下的任务
	List<Task> queryTaskByExeuser(UserInfo user , Page p);
	
}
