package com.zuikc.service;

/*
 * ���ܹ���
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFunction;

public interface ProjectFunctionService {
	// ��ӹ���
	public void addProjectFunction(ProjectFunction pf);

	// �޸Ĺ���
	public void updateProjectFunction(ProjectFunction pf);

	// ����ɾ��
	public void deleteProjectFunctions(String[] projectFunctionIDs);

	// ��ѯ��������
	public ProjectFunction queryProjectFunctionByID(ProjectFunction pf);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<ProjectFunction> queryProjectFunctionByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(String attrName, String attrValue);

	// ��ѯ����
	public List<ProjectFunction> queryAllProjectFunction();

	// ����ģ��ID��ȡ�����б�
	public List<ProjectFunction> queryProjectFunctionByModelID(Integer modelID);
}
