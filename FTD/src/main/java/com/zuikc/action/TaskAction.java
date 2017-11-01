package com.zuikc.action;

import java.util.ArrayList;
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
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.ProjectFunctionService;
import com.zuikc.service.ProjectModelService;
import com.zuikc.service.ProjectNeedService;
import com.zuikc.service.ProjectService;
import com.zuikc.service.TaskService;
import com.zuikc.service.UserInfoService;
@Controller("taskAction")
@Scope("prototype")
public class TaskAction extends ActionSupport implements ModelDriven<Task>, ServletRequestAware {

	private static final long serialVersionUID = 8420293476756430179L;
	
	@Resource(name = "taskService")
	private TaskService ts;
	@Resource(name = "projectFunctionService")
	private ProjectFunctionService pfs;
	@Resource(name = "projectModelService")
	private ProjectModelService pms;
	@Resource(name = "projectNeedService")
	private ProjectNeedService pns;
	@Resource(name = "projectService")
	private ProjectService ps;
	@Resource(name = "userInfoService")
	private UserInfoService us;

	private Task t = new Task();

	private HttpServletRequest request;
	private int pagenum;
	//任务状态
	private String status ;
	private String cid;
	private String keyword;
	private String orderby;
	//异步获取需求ID
	private Integer modelID;
	private List<ProjectFunction> ajaxFunctionList = new ArrayList<>();
	
	@Override
	public String execute() throws Exception {
		int rows = ts.getRows(t.getStatus() , cid, keyword);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<Task> taskList = ts.queryTaskByCriteria(t.getStatus() , cid, keyword, orderby, page);
		request.setAttribute("taskList", taskList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryTaskByID() {
		if (t.getTaskID() != null) {
			Task task = ts.queryTaskByID(t);
			request.setAttribute("task", task);
		}
		List<Project> projectList = ps.queryAllProjects();
		request.setAttribute("projectList", projectList);
		List<ProjectNeed> projectNeedList = pns.queryAllProjectNeed();
		request.setAttribute("projectNeedList", projectNeedList);
		List<ProjectModel> projectModelList = pms.queryAllProjectModel();
		request.setAttribute("projectModelList", projectModelList);
		List<ProjectFunction> projectFunctionList = pfs.queryAllProjectFunction();
		request.setAttribute("projectFunctionList", projectFunctionList);
		List<UserInfo> userInfoList = us.queryAllUserInfo();
		request.setAttribute("userInfoList", userInfoList);
		return SUCCESS;
	}
	public String lookMyTask() {
		// TODO 
		UserInfo user = (UserInfo) request.getSession().getAttribute("currentUser");
		int rows = ts.getRowsByUser(user);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<Task> taskList =ts.queryTaskByExeuser(user, page);
		request.setAttribute("taskList", taskList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String addTask() {
		//添加发布者
		UserInfo user = (UserInfo) request.getSession().getAttribute("currentUser");
		t.setPubUser(user);
		ts.addTask(t);
		return SUCCESS;
	}

	public String updateTask() {
		ts.updateTask(t);
		return SUCCESS;
	}

	public String deleteTask() {
		String[] taskIDs = request.getParameterValues("taskIDs");
		ts.deleteTasks(taskIDs);
		return SUCCESS;
	}
	public String startTask() {
		ts.startTask(t);
		return SUCCESS;
	}
	public String finishTask() {
		ts.finishTask(t);
		return SUCCESS;
	}
	//异步	
	public String getFunctionByModelID() {
		if (modelID != null ) {
			//诡异的问题。。。。剑走偏锋的解决方法
			List<ProjectFunction> list = pfs.queryProjectFunctionByModelID(modelID);
			if (list != null) {
				for (ProjectFunction pm : list) {
					ProjectFunction tempPF = new ProjectFunction();
					tempPF.setFunctionID(pm.getFunctionID());
					tempPF.setFunctionName(pm.getFunctionName());
					ajaxFunctionList.add(tempPF);
				}
			}
		}
		return SUCCESS;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public Task getT() {
		return t;
	}

	public void setT(Task t) {
		this.t = t;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getModelID() {
		return modelID;
	}

	public void setModelID(Integer modelID) {
		this.modelID = modelID;
	}

	public List<ProjectFunction> getAjaxFunctionList() {
		return ajaxFunctionList;
	}

	public void setAjaxFunctionList(List<ProjectFunction> ajaxFunctionList) {
		this.ajaxFunctionList = ajaxFunctionList;
	}

	@Override
	public Task getModel() {
		return t;
	}
	
}
