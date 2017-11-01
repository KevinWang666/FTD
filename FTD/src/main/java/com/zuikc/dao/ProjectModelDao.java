package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectModel;

public interface ProjectModelDao {

	// ���ģ��
	public void addProjectModel(ProjectModel pm);

	// �޸�ģ��
	public void updateProjectModel(ProjectModel pm);

	// ɾ��
	public void deleteProjectModel(ProjectModel pm);

	// ��ѯ����ģ��
	public ProjectModel queryProjectModelByID(ProjectModel pm);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<ProjectModel> queryProjectModelByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(String attrName, String attrValue);

	// ��ѯ����
	public List<ProjectModel> queryAllProjectModel();
	//��������ID��ȡģ���б�
	public List<ProjectModel> queryProjectModelByNeedID(Integer needID);
}
