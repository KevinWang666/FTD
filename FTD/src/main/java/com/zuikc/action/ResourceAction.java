package com.zuikc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;
import com.zuikc.service.ResourceService;

@Controller("resourceAction")
@Scope("prototype")
public class ResourceAction extends ActionSupport implements ModelDriven<Resource>, ServletRequestAware {

	private static final long serialVersionUID = 5522648678703345461L;
	@javax.annotation.Resource(name = "resourceService")
	private ResourceService rs;

	private HttpServletRequest request;

	private Resource res = new Resource();

	private int pagenum;
	private String cid;
	private String keyword;

	@Override
	public String execute() throws Exception {
		if (cid != null && !"".equals(cid)) {
			res.setResourceName(keyword);
		}
		System.out.println(cid + "........." + keyword);
		int rows = rs.getRows(res);
		Page p = new Page();
		p.setRows(rows);
		p.setCunrrentPage(pagenum);
		List<Resource> resourceList = rs.queryResourceByCriteria(cid, keyword, p);
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("p", p);
		return SUCCESS;
	}

	public String addResource() {
		res.setStatus("启用");
		try {
			rs.addResource(res);
		} catch (IllegalStateException e) {
			System.out.println("先不管这个异常");
		}
		return SUCCESS;
	}

	public String updateResource() {
		System.out.println(res);
		rs.updateResource(res);
		return SUCCESS;
	}

	public String deleteResource() {
		rs.deleteResource(res);
		return SUCCESS;
	}

	public String queryResourceByID() {
		Resource resource = rs.queryResourceByID(res);
		request.setAttribute("resource", resource);
		// 还需要查询所有的顶级菜单
		List<Resource> parentList = rs.queryParentResources();
		request.setAttribute("parentList", parentList);
		return SUCCESS;
	}

	public String queryParentResources() {
		// 查询所有的顶级菜单
		List<Resource> parentList = rs.queryParentResources();
		for (Resource resource : parentList) {
			System.out.println(resource);
		}
		request.setAttribute("parentList", parentList);
		return SUCCESS;
	}

	public String switchStatus() {
		String[] resourceIDs = request.getParameterValues("resourceIDs");
		rs.switchStatusResources(resourceIDs);
		return SUCCESS;
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Resource getRes() {
		return res;
	}

	public void setRes(Resource res) {
		this.res = res;
	}

	@Override
	public Resource getModel() {
		return res;
	}

}
