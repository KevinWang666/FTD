package com.zuikc.action;

import java.util.ArrayList;
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
import com.zuikc.domain.ProjectFunction;
import com.zuikc.domain.ProjectModel;
import com.zuikc.domain.ProjectNeed;
import com.zuikc.service.ProjectFunctionService;
import com.zuikc.service.ProjectModelService;
import com.zuikc.service.ProjectNeedService;
import com.zuikc.service.ProjectService;
@Controller("projectFunctionAction")
@Scope("prototype")
public class ProjectFunctionAction extends ActionSupport implements ModelDriven<ProjectFunction>, ServletRequestAware {

	private static final long serialVersionUID = 8420293476756430179L;
	
	@Resource(name = "projectFunctionService")
	private ProjectFunctionService pfs;
	@Resource(name = "projectModelService")
	private ProjectModelService pms;
	@Resource(name = "projectNeedService")
	private ProjectNeedService pns;
	@Resource(name = "projectService")
	private ProjectService ps;

	private ProjectFunction pf = new ProjectFunction();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;
	//异步获取需求ID
	private Integer needID;
	private List<ProjectModel> ajaxProjectModelList = new ArrayList<>();
	
	@Override
	public String execute() throws Exception {
		int rows = pfs.getRows(cid, keyword);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<ProjectFunction> projectFunctionList = pfs.queryProjectFunctionByCriteria(cid, keyword, orderby, page);
		request.setAttribute("projectFunctionList", projectFunctionList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryProjectFunctionByID() {
		if (pf.getFunctionID() != null) {
			ProjectFunction projectFunction = pfs.queryProjectFunctionByID(pf);
			request.setAttribute("projectFunction", projectFunction);
		}
		List<Project> projectList = ps.queryAllProjects();
		request.setAttribute("projectList", projectList);
		List<ProjectNeed> projectNeedList = pns.queryAllProjectNeed();
		request.setAttribute("projectNeedList", projectNeedList);
		List<ProjectModel> projectModelList = pms.queryAllProjectModel();
		request.setAttribute("projectModelList", projectModelList);
		return SUCCESS;
	}

	public String addProjectFunction() {
		pf.setStartdate(new Date(System.currentTimeMillis()));
		pfs.addProjectFunction(pf);
		return SUCCESS;
	}

	public String updateProjectFunction() {
		pf.setModifydate(new Date(System.currentTimeMillis()));
		pfs.updateProjectFunction(pf);
		return SUCCESS;
	}

	public String deleteProjectFunction() {
		String[] functionIDs = request.getParameterValues("functionIDs");
		pfs.deleteProjectFunctions(functionIDs);
		return SUCCESS;
	}
	//异步	
	public String getProjectModelByNeedID() {
		if (needID != null ) {
			//诡异的问题。。。。剑走偏锋的解决方法
			List<ProjectModel> list = pms.queryProjectModelByNeedID(needID);
			if (list != null) {
				for (ProjectModel pm : list) {
					ProjectModel tempPM = new ProjectModel();
					tempPM.setModelID(pm.getModelID());
					tempPM.setModelName(pm.getModelName());
					ajaxProjectModelList.add(tempPM);
				}
			}
		}
		return SUCCESS;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ProjectFunction getPf() {
		return pf;
	}

	public void setPf(ProjectFunction pf) {
		this.pf = pf;
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
	
	public Integer getNeedID() {
		return needID;
	}

	public void setNeedID(Integer needID) {
		this.needID = needID;
	}
	
	public List<ProjectModel> getAjaxProjectModelList() {
		return ajaxProjectModelList;
	}

	@Override
	public ProjectFunction getModel() {
		return pf;
	}
	
}
