package com.zuikc.action;
import java.io.File;
/*
 * 附件
 * */
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
import com.zuikc.domain.ProjectFile;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.ProjectFileService;
import com.zuikc.service.ProjectService;

@Controller("projectFileAction")
@Scope("prototype")
public class ProjectFileAction extends ActionSupport implements ModelDriven<ProjectFile>, ServletRequestAware {
	private static final long serialVersionUID = 5559776158007518954L;
	
	@Resource(name = "projectFileService")
	private ProjectFileService pfiles;
	@Resource(name = "projectService")
	private ProjectService ps;

	private ProjectFile pfile = new ProjectFile();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;
	//文件上传用
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	@Override
	public String execute() throws Exception {
		int rows = pfiles.getRows(cid, keyword);
		Page page = new Page();
		page.setRows(rows);
		page.setCunrrentPage(pagenum);
		List<ProjectFile> projectFileList = pfiles.queryProjectFileByCriteria(cid, keyword, orderby, page);
		for (ProjectFile projectFile : projectFileList) {
			System.out.println(projectFile);
		}
		request.setAttribute("projectFileList", projectFileList);
		request.setAttribute("p", page);
		return SUCCESS;
	}

	public String queryProjectFileByID() {
		if (pfile.getFileID() != null) {
			ProjectFile projectFile = pfiles.queryProjectFileByID(pfile);
			request.setAttribute("projectFile", projectFile);
		}
		List<Project> projectList = ps.queryAllProjects();
		request.setAttribute("projectList", projectList);
		return SUCCESS;
	}

	public String addProjectFile() {
		pfile.setUploaddate(new Date(System.currentTimeMillis()));
		UserInfo user = (UserInfo) request.getSession().getAttribute("currentUser");
		pfile.setUser(user);
		pfiles.addProjectFile(pfile);
		return SUCCESS;
	}

	public String updateProjectFile() {
		pfile.setModifydate(new Date(System.currentTimeMillis()));
		pfiles.updateProjectFile(pfile);
		return SUCCESS;
	}

	public String deleteProjectFile() {
		String[] fileIDs = request.getParameterValues("fileIDs");
		pfiles.deleteProjectFiles(fileIDs);
		return SUCCESS;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ProjectFile getModel() {
		return pfile;
	}

	public ProjectFile getPfile() {
		return pfile;
	}

	public void setPfile(ProjectFile pfile) {
		this.pfile = pfile;
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
