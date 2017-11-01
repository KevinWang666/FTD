package com.zuikc.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;
import com.zuikc.service.CustomerService;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>, ServletRequestAware {

	private static final long serialVersionUID = 3594764059704849371L;
	@Resource(name = "customerService")
	private CustomerService cs;

	// ģ�������ǵó�ʼ��
	private Customer c = new Customer();

	private HttpServletRequest request;
	// ��ǰҳ
	private int pagenum;
	// �������ֶ���
	private String cid;
	// �ؼ���
	private String keyword;
	// �����ֶ�
	private String orderby;

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	// ��ѯ�ͻ��б�
	@Override
	public String execute() throws Exception {
		if (cid != null && !"".equals(cid)) {
			if ("customerName".equals(cid)) {
				c.setCustomerName(keyword);
			} else {
				c.setContact(keyword);
			}
		}
		int rows = cs.getRows(c);
		Page p = new Page();
		p.setRows(rows);
		p.setCunrrentPage(pagenum);
		List<Customer> customerList = cs.queryCustomerByCriteria(cid, keyword, orderby, p);
		request.setAttribute("customerList", customerList);
		request.setAttribute("p", p);
		return SUCCESS;
	}
	//��ӿͻ�
	public String addCustomer() {
		c.setPubdate(new Date(System.currentTimeMillis()));
		cs.addCustomer(c);
		return SUCCESS;
	}
	//�༭�ͻ�
	public String editCustomer() {
		c.setModifydate(new Date(System.currentTimeMillis()));
		cs.updateCustomer(c);
		return SUCCESS;
	}
	//�ͻ�����
	public String lookCustomer() {
		Customer customer = cs.queryCustomerByID(c);
		request.setAttribute("customer", customer);
		return SUCCESS;
	}
	//ɾ���ͻ�
	public String deleteCustomer() {
		String[] customerIDs = request.getParameterValues("customerIDs");
		cs.deleteCustomers(customerIDs);
		return SUCCESS;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Customer getModel() {
		return c;
	}

}
