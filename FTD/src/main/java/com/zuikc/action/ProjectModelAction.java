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
import com.zuikc.domain.ProjectModel;
import com.zuikc.domain.ProjectNeed;
import com.zuikc.service.ProjectModelService;
import com.zuikc.service.ProjectNeedService;
import com.zuikc.service.ProjectService;
@Controller("projectModelAction")
@Scope("prototype")
public class ProjectModelAction extends ActionSupport implements ModelDriven<ProjectModel>, ServletRequestAware {

	private static final long serialVersionUID = 8420293476756430179L;
	
	@Resource(name = "projectModelService")
	private ProjectModelService pms;
	@Resource(name = "projectNeedService")
	private ProjectNeedService pns;
	@Resource(name = "projectService")
	private ProjectService ps;

	private ProjectModel pm = new ProjectModel();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;
	//异步方法获取项目ID
	private Integer proID;
	private List<ProjectNeed> ajaxProjectNeedList = new ArrayList<>();
	
	@Override
	public String execute() throws Exception {
		int rows = pms.getRows(cid, keyword);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<ProjectModel> projectModelList = pms.queryProjectModelByCriteria(cid, keyword, orderby, page);
		request.setAttribute("projectModelList", projectModelList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryProjectModelByID() {
		if (pm.getModelID() != null) {
			ProjectModel projectModel = pms.queryProjectModelByID(pm);
			request.setAttribute("projectModel", projectModel);
		}
		List<Project> projectList = ps.queryAllProjects();
		request.setAttribute("projectList", projectList);
		List<ProjectNeed> projectNeedList = pns.queryAllProjectNeed();
		request.setAttribute("projectNeedList", projectNeedList);
		return SUCCESS;
	}

	public String addProjectModel() {
		pm.setStartdate(new Date(System.currentTimeMillis()));
		pms.addProjectModel(pm);
		return SUCCESS;
	}

	public String updateProjectModel() {
		pm.setModifydate(new Date(System.currentTimeMillis()));
		pms.updateProjectModel(pm);
		return SUCCESS;
	}

	public String deleteProjectModel() {
		String[] modelIDs = request.getParameterValues("modelIDs");
		pms.deleteProjectModels(modelIDs);
		return SUCCESS;
	}
	//异步
	public String getProjectNeedByProID() {
		if (proID != null ) {
			ajaxProjectNeedList = pns.queryProjectNeedByProjectID(proID);
		}
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ProjectModel getModel() {
		return pm;
	}

	public ProjectModel getPm() {
		return pm;
	}

	public void setPm(ProjectModel pm) {
		this.pm = pm;
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

	public Integer getProID() {
		return proID;
	}

	public void setProID(Integer proID) {
		this.proID = proID;
	}

	public List<ProjectNeed> getAjaxProjectNeedList() {
		return ajaxProjectNeedList;
	}

	public void setAjaxProjectNeedList(List<ProjectNeed> ajaxProjectNeedList) {
		this.ajaxProjectNeedList = ajaxProjectNeedList;
	}
	

}
