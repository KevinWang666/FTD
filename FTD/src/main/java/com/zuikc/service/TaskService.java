package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;

/*
 * ������Ϣ
 * */
public interface TaskService {
	//��ȡ��¼��
	int getRows(String status, String cid, String keyword);
	//������ѯ
	List<Task> queryTaskByCriteria(String status, String cid, String keyword, String orderby, Page page);
	
	Task queryTaskByID(Task t);

	void addTask(Task t);

	void updateTask(Task t);

	void deleteTasks(String[] taskIDs);
	//��ʼ����
	void startTask(Task t);
	//�������
	void finishTask(Task t);
	//��ѯ��ǰ�û����µ���������
	int getRowsByUser(UserInfo user);
	//��ѯ��ǰ�û����µ�����
	List<Task> queryTaskByExeuser(UserInfo user , Page p);
	
}
