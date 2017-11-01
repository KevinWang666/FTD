package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;

/*
 * 客户
 * */
public interface CustomerService {
	//添加客户
	public void addCustomer(Customer c);
	//修改客户
	public void updateCustomer(Customer c);
	//删除客户
	public void deleteCustomer(Customer c);
	//批量删除客户
	public void deleteCustomers(String[] customerIDs);
	//分页查询
	public List<Customer> queryCustomerByPage(Page p);
	//查询单个客户
	public Customer queryCustomerByID(Customer c);
	/*
	 * 条件查询
	 * 参数：查询的字段名， 关键字，排序的字段名
	 * */
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue , String orderAttr , Page p);
	//获取记录数
	public int getRows(Customer c);
	//查询所有客户
	public List<Customer> queryAllCustomer();
}
