package com.zuikc.service;
/*
 * �����������
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectNeed;


public interface ProjectNeedService {
	// �����������
	public void addProjectNeed(ProjectNeed pn);

	// �޸��������
	public void updateProjectNeed(ProjectNeed pn);

	// ����ɾ��
	public void deleteProjectNeeds(String[] projectNeedIDs);

	// ��ѯ�����������
	public ProjectNeed queryProjectNeedByID(ProjectNeed pn);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<ProjectNeed> queryProjectNeedByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(String attrName, String attrValue);

	// ��ѯ����
	public List<ProjectNeed> queryAllProjectNeed();
	
	//������ĿID��ȡ����
	public List<ProjectNeed> queryProjectNeedByProjectID(Integer projectID);
}