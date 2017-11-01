package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.CustomerDao;
import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;
import com.zuikc.service.CustomerService;

@Transactional
@Service("customerService")
public class CustomerServiceImp implements CustomerService {
	@Resource
	private CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer c) {
		customerDao.addCustomer(c);
	}

	@Override
	public void updateCustomer(Customer c) {
		customerDao.updateCustomer(c);
	}

	@Override
	public void deleteCustomer(Customer c) {
		customerDao.deleteCustomer(c);
	}

	@Override
	public void deleteCustomers(String[] customerIDs) {
		if (customerIDs != null) {
			for (String id : customerIDs) {
				customerDao.deleteCustomer(new Customer(Integer.parseInt(id)));
			}
		}
	}
	
	@Override
	public List<Customer> queryCustomerByPage(Page p) {
		return customerDao.queryCustomerByPage(p);
	}

	@Override
	public Customer queryCustomerByID(Customer c) {
		return customerDao.queryCustomerByID(c);
	}

	@Override
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue, String orderAttr ,Page p) {
		return customerDao.queryCustomerByCriteria(attrName, attrValue, orderAttr , p);
	}
	
	@Override
	public int getRows(Customer c) {
		return customerDao.getRows(c);
	}

	@Override
	public List<Customer> queryAllCustomer() {
		return customerDao.queryAllCustomer();
	}


}
