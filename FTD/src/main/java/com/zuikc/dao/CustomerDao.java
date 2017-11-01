package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;

public interface CustomerDao {
	// 添加客户
	public void addCustomer(Customer c);

	// 修改客户
	public void updateCustomer(Customer c);

	// 删除客户
	public void deleteCustomer(Customer c);

	// 分页查询
	public List<Customer> queryCustomerByPage(Page p);

	// 查询单个客户
	public Customer queryCustomerByID(Customer c);

	// 条件查询
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(Customer c);

	// 查询所有用户
	public List<Customer> queryAllCustomer();

}
