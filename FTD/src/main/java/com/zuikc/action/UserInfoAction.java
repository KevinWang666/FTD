package com.zuikc.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zuikc.domain.Page;
import com.zuikc.domain.Role;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.RoleService;
import com.zuikc.service.UserInfoService;

@Controller("userInfoAction")
@Scope("prototype")
public class UserInfoAction extends ActionSupport implements ModelDriven<UserInfo>, ServletRequestAware {

	private static final long serialVersionUID = 816391107213179966L;

	@Resource(name = "userInfoService")
	private UserInfoService us;
	@Resource(name = "roleService")
	private RoleService rs;

	private UserInfo ui = new UserInfo();

	private HttpServletRequest request;
	private int pagenum;
	private String cid;
	private String keyword;
	private String orderby;
	private String oldPwd;

	@Override
	public String execute() throws Exception {
		if (cid != null && !"".equals(cid)) {
			if ("truename".equals(cid)) {
				ui.setTruename(keyword);
			} else {
				ui.setCellphone(keyword);
			}
		}
		System.out.println("================================");
		System.out.println("UserInfoAction类....execute()方法..............." + ui);
		System.out.println("================================");

		int rows = us.getRows(ui);
		Page p = new Page();
		p.setRows(rows);
		p.setCunrrentPage(pagenum);

		List<UserInfo> userInfoList = us.queryUserInfoByCriteria(cid, keyword, orderby, p);
		request.setAttribute("userInfoList", userInfoList);
		request.setAttribute("p", p);

		return SUCCESS;
	}

	public String queryUserInfoByID() {

		if (ui.getUserID() != null) {
			UserInfo user = us.queryUserInfoByID(ui);
			request.setAttribute("user", user);
		}

		List<Role> roleList = rs.queryAllRole();
		request.setAttribute("roleList", roleList);

		return SUCCESS;
	}

	public String addUserInfo() {
		ui.setStatus("正常");
		us.addUserInfo(ui);

		return SUCCESS;
	}

	public String updateUserInfo() {
		us.updateUserInfo(ui);
		return SUCCESS;
	}

	public String deleteUserInfo() {
		us.deleteUserInfo(ui);
		return SUCCESS;
	}

	public String switchStatusUserInfo() {
		String[] userInfoIDs = request.getParameterValues("userInfoIDs");

		us.switchStatusUserInfos(userInfoIDs);
		return SUCCESS;
	}
	
	public String login() {
		UserInfo currentUser = us.login(ui);
		if (currentUser != null) {
			//放入会话域
			request.getSession().setAttribute("currentUser", currentUser);
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public String modpassword() {
		// 从Session中取出当前登录的用户
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("currentUser");
		//先验证旧密码
		String pwd = user.getPwd();
		if (!pwd.equals(oldPwd)) {
			return INPUT;
		} else {
			user.setPwd(ui.getPwd());
			us.updateUserInfo(user);
			return SUCCESS;
		}
	}
	
	public String logout() {
		// 从Session中取出当前登录的用户
		HttpSession session = request.getSession();
		//置空
		session.setAttribute("currentUser", null);
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public UserInfo getModel() {
		return ui;
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

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

}
