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
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.ProjectNeed;
import com.zuikc.service.ProjectNeedService;
import com.zuikc.service.ProjectService;

@Controller("projectNeedAction")
@Scope("prototype")
public class ProjectNeedAction extends ActionSupport implements ModelDriven<ProjectNeed>, ServletRequestAware {
	private static final long serialVersionUID = 5559776158007518954L;
	
	@Resource(name = "projectNeedService")
	private ProjectNeedService pns;
	@Resource(name = "projectService")
	private ProjectService ps;

	private ProjectNeed pn = new ProjectNeed();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;

	@Override
	public String execute() throws Exception {
		int rows = pns.getRows(cid, keyword);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<ProjectNeed> projectNeedList = pns.queryProjectNeedByCriteria(cid, keyword, orderby, page);
		for (ProjectNeed projectNeed : projectNeedList) {
			System.out.println(projectNeed);
		}
		request.setAttribute("projectNeedList", projectNeedList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryProjectNeedByID() {
		if (pn.getNeedID() != null) {
			ProjectNeed projectNeed = pns.queryProjectNeedByID(pn);
			request.setAttribute("projectNeed", projectNeed);
		}
		List<Project> projectList = ps.queryAllProjects();
		request.setAttribute("projectList", projectList);
		return SUCCESS;
	}

	public String addProjectNeed() {
		pn.setStartdate(new Date(System.currentTimeMillis()));
		pns.addProjectNeed(pn);
		return SUCCESS;
	}

	public String updateProjectNeed() {
		pn.setModifydate(new Date(System.currentTimeMillis()));
		pns.updateProjectNeed(pn);
		return SUCCESS;
	}

	public String deleteProjectNeed() {
		String[] needIDs = request.getParameterValues("needIDs");
		pns.deleteProjectNeeds(needIDs);
		return SUCCESS;
	}

	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ProjectNeed getModel() {
		return pn;
	}

	public ProjectNeed getPn() {
		return pn;
	}

	public void setPn(ProjectNeed pn) {
		this.pn = pn;
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

}
