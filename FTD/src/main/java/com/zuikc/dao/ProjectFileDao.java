package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFile;

public interface ProjectFileDao {
	// ����ļ�
	public void addProjectFile(ProjectFile pfile);

	// �޸��ļ�
	public void updateProjectFile(ProjectFile pfile);

	// ɾ��
	public void deleteProjectFile(ProjectFile pfile);

	// ��ѯ�����ļ�
	public ProjectFile queryProjectFileByID(ProjectFile pfile);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<ProjectFile> queryProjectFileByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(String attrName, String attrValue);

	// ��ѯ����
	public List<ProjectFile> queryAllProjectFile();
}
