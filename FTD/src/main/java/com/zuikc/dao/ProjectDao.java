package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Project;

public interface ProjectDao {
	// �����Ŀ������Ϣ
	public void addProject(Project p);

	// �޸���Ŀ������Ϣ
	public void updateProject(Project p);

	// ɾ����Ŀ������Ϣ
	public void deleteProject(Integer projectID);

	// ��ѯ������Ŀ������Ϣ
	public Project queryProjectByID(Project p);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<Project> queryProjectByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(Project p);
	//��ѯ����
	public List<Project> queryAllProjects();
}
