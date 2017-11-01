package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;

public interface ResourceDao {
	// �����Դ�˵�
	public void addResource(Resource res);

	// �޸���Դ�˵�
	public void updateResource(Resource res);

	// ɾ����Դ�˵�
	public void deleteResource(Resource res);

	// ��ҳ��ѯ
	public List<Resource> queryResourceByPage(Page p);

	// ��ѯ������Դ�˵�
	public Resource queryResourceByID(Resource res);

	// ������ѯ
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p);

	// ��ȡ��¼��
	public int getRows(Resource res);
	//��ѯ�����˵�
	public List<Resource> queryParentResources();
}
