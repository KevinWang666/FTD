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
import com.zuikc.domain.Role;
import com.zuikc.service.ResourceService;
import com.zuikc.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends ActionSupport implements ServletRequestAware, ModelDriven<Role> {
	private static final long serialVersionUID = -4727016355866828287L;
	@Resource(name = "roleService")
	private RoleService rs;
	@Resource(name = "resourceService")
	private ResourceService resSer;

	private HttpServletRequest request;

	private Role r = new Role();

	private int packnum;
	// 搜索的属性名
	private String cid;
	// 属性值(关键字)
	private String keyword;

	@Override
	public String execute() throws Exception {
		if (cid != null && !"".equals(cid) && !"".equals(keyword) && keyword != null) {
			r.setRoleName(keyword);
		}
		int rows = rs.getRows(r);
		Page p = new Page();
		p.setRows(rows);
		p.setCunrrentPage(packnum);
		List<Role> roleList = rs.queryRoleByCriteria(cid, keyword, p);
		request.setAttribute("roleList", roleList);
		request.setAttribute("p", p);
		return SUCCESS;
	}
	
	public String queryResourceList() {
		Page p = new Page();
		//100条怎么着也够用了吧
		p.setPAGE_SIZE(100);
		p.setRows(100);
		p.setCunrrentPage(1);
		List<com.zuikc.domain.Resource> resourceList = resSer.queryResourceByPage(p);
		request.setAttribute("resourceList", resourceList);
		
		return SUCCESS;
	}
	
	public String addRole() {
		String[] resources = request.getParameterValues("resourceList");
		List<com.zuikc.domain.Resource> list = new ArrayList<>();
		if (resources != null) {
			for (String string : resources) {
				com.zuikc.domain.Resource resource = resSer.queryResourceByID(new com.zuikc.domain.Resource(Integer.parseInt(string)));
				list.add(resource);
			}
		}
		r.setResources(list);
		rs.addRole(r);
		return SUCCESS;
	}

	public String updateRole() {
		String[] resources = request.getParameterValues("resourceList");
		List<com.zuikc.domain.Resource> list = new ArrayList<>();
		if (resources != null) {
			for (String string : resources) {
				com.zuikc.domain.Resource resource = resSer.queryResourceByID(new com.zuikc.domain.Resource(Integer.parseInt(string)));
				list.add(resource);
			}
		}
		r.setResources(list);
		rs.updateRole(r);
		return SUCCESS;
	}

	public String deleteRole() {
		rs.deleteRole(r);
		return SUCCESS;
	}

	public String queryRoleByID() {
		/*System.out.println("=========================");
		System.out.println(r);*/
		Role role = rs.queryRoleByID(r);
		/*System.out.println(role);
		System.out.println("=========================");*/
		request.setAttribute("role", role);
		//需要所有的菜单资源
		Page p = new Page();
		p.setPAGE_SIZE(100);
		p.setRows(100);
		p.setCunrrentPage(1);
		List<com.zuikc.domain.Resource> resourceList = resSer.queryResourceByPage(p);
		request.setAttribute("resourceList", resourceList);
		
		return SUCCESS;
	}

	public String switchStatusRole() {
		String[] roleIDs = request.getParameterValues("roleIDs");
		rs.switchStatusRoles(roleIDs);
		return SUCCESS;
	}

	public int getPacknum() {
		return packnum;
	}

	public void setPacknum(int packnum) {
		this.packnum = packnum;
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
	public Role getModel() {
		return r;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
