package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.UserInfoDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.UserInfo;
import com.zuikc.service.UserInfoService;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImp implements UserInfoService {

	@Resource(name = "userInfoDao")
	private UserInfoDao ud;

	@Override
	public void addUserInfo(UserInfo u) {
		ud.addUserInfo(u);

	}

	@Override
	public void updateUserInfo(UserInfo u) {
		ud.updateUserInfo(u);

	}

	@Override
	public void deleteUserInfo(UserInfo u) {
		ud.deleteUserInfo(u);

	}

	@Override
	public void switchStatusUserInfos(String[] UserInfoIDs) {
		if (UserInfoIDs != null) {
			for (String id : UserInfoIDs) {
				UserInfo user = ud.queryUserInfoByID(new UserInfo(Integer.parseInt(id)));
				user.setStatus("ÒÑ×¢Ïú");
			}
		}
	}

	@Override
	public List<UserInfo> queryUserInfoByPage(Page p) {

		return ud.queryUserInfoByPage(p);
	}

	@Override
	public UserInfo queryUserInfoByID(UserInfo u) {

		return ud.queryUserInfoByID(u);
	}

	@Override
	public List<UserInfo> queryUserInfoByCriteria(String attrName, String attrValue, String orderAttr, Page p) {

		return ud.queryUserInfoByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(UserInfo u) {

		return ud.getRows(u);
	}

	@Override
	public UserInfo login(UserInfo ui) {
		return ud.login(ui);
	}

	@Override
	public List<UserInfo> queryAllUserInfo() {
		return ud.queryAllUserInfo();
	}

}
