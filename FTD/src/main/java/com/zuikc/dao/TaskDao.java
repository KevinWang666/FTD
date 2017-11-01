package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;

public interface TaskDao {
	// ��ȡ��¼��
	int getRows(String status, String cid, String keyword);

	// ������ѯ
	List<Task> queryTaskByCriteria(String status, String cid, String keyword, String orderby, Page page);

	Task queryTaskByID(Task t);

	void addTask(Task t);

	void updateTask(Task t);

	void deleteTask(Task t);
	
	int getRowsByUser(UserInfo user);

	List<Task> queryTaskByExeuser(UserInfo user , Page p);

}
