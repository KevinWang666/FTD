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
import com.zuikc.domain.Project;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.CustomerService;
import com.zuikc.service.ProjectService;
import com.zuikc.service.UserInfoService;

@Controller("projectAction")
@Scope("prototype")
public class ProjectBaseAction extends ActionSupport implements ModelDriven<Project>, ServletRequestAware {

	private static final long serialVersionUID = 2044814193497792087L;

	@Resource(name = "projectService")
	private ProjectService ps;
	@Resource(name = "customerService")
	private CustomerService cs;
	@Resource(name = "userInfoService")
	private UserInfoService us;

	private Project p = new Project();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;

	// 异步使用
	private Integer custID;
	private String contactName;

	@Override
	public String execute() throws Exception {
		System.out.println("===========================================");
		if (cid != null && !"".equals(cid)) {
			if ("projectName".equals(cid)) {
				p.setProjectName(keyword);
			} else {
				UserInfo u = new UserInfo();
				u.setTruename(keyword);
				p.setUser(u);
			}
		}
		System.out.println("ProjectBaseAction.........execute()方法............" + p);
		System.out.println("===========================================");
		System.out.println(p);
		int rows = ps.getRows(p);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);

		List<Project> projectList = ps.queryProjectByCriteria(cid, keyword, orderby, page);
		request.setAttribute("projectList", projectList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryProjectByID() {
		if (p.getProjectID() != null) {
			Project project = ps.queryProjectByID(p);
			request.setAttribute("project", project);
		}
		List<Customer> customerList = cs.queryAllCustomer();
		request.setAttribute("customerList", customerList);
		List<UserInfo> userInfoList = us.queryAllUserInfo();
		request.setAttribute("userInfoList", userInfoList);
		return SUCCESS;
	}

	public String addProject() {
		ps.addProject(p);
		return SUCCESS;
	}

	public String updateProject() {
		p.setModifydate(new Date(System.currentTimeMillis()));
		ps.updateProject(p);
		return SUCCESS;
	}

	public String deleteProject() {
		String[] projectIDs = request.getParameterValues("projectIDs");
		ps.deleteProjects(projectIDs);

		return SUCCESS;
	}

	// 异步获取客户联系人
	public String ajaxGetContactByID() {
		if (custID == null) {
			contactName = "";
		} else {
			Customer customer = cs.queryCustomerByID(new Customer(custID));
			contactName = customer.getContact();
		}
		return SUCCESS;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Project getModel() {
		return p;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

}
