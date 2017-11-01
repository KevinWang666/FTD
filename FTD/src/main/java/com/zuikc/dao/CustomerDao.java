package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;

public interface CustomerDao {
	// ��ӿͻ�
	public void addCustomer(Customer c);

	// �޸Ŀͻ�
	public void updateCustomer(Customer c);

	// ɾ���ͻ�
	public void deleteCustomer(Customer c);

	// ��ҳ��ѯ
	public List<Customer> queryCustomerByPage(Page p);

	// ��ѯ�����ͻ�
	public Customer queryCustomerByID(Customer c);

	// ������ѯ
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(Customer c);

	// ��ѯ�����û�
	public List<Customer> queryAllCustomer();

}
