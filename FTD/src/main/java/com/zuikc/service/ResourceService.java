package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;

public interface ResourceService {
	// �����Դ�˵�
	public void addResource(Resource res);

	// �޸���Դ�˵�
	public void updateResource(Resource res);

	// ɾ��
	public void deleteResource(Resource res);

	// ����������Դ�˵�
	public void switchStatusResources(String[] resourceIDs);

	// ��ҳ��ѯ
	public List<Resource> queryResourceByPage(Page p);

	// ��ѯ������Դ�˵�
	public Resource queryResourceByID(Resource res);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ���
	 */
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p);

	// ��ȡ��¼��
	public int getRows(Resource res);
	//��ѯ���еĸ����˵�
	public List<Resource> queryParentResources();

}
