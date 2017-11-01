package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;

/*
 * �ͻ�
 * */
public interface CustomerService {
	//��ӿͻ�
	public void addCustomer(Customer c);
	//�޸Ŀͻ�
	public void updateCustomer(Customer c);
	//ɾ���ͻ�
	public void deleteCustomer(Customer c);
	//����ɾ���ͻ�
	public void deleteCustomers(String[] customerIDs);
	//��ҳ��ѯ
	public List<Customer> queryCustomerByPage(Page p);
	//��ѯ�����ͻ�
	public Customer queryCustomerByID(Customer c);
	/*
	 * ������ѯ
	 * ��������ѯ���ֶ����� �ؼ��֣�������ֶ���
	 * */
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue , String orderAttr , Page p);
	//��ȡ��¼��
	public int getRows(Customer c);
	//��ѯ���пͻ�
	public List<Customer> queryAllCustomer();
}
