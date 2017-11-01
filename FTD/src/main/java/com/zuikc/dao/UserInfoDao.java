package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.UserInfo;

public interface UserInfoDao {
	// 添加人员
	public void addUserInfo(UserInfo u);

	// 修改人员
	public void updateUserInfo(UserInfo u);

	// 删除
	public void deleteUserInfo(UserInfo u);

	// 分页查询
	public List<UserInfo> queryUserInfoByPage(Page p);

	// 查询单个人员
	public UserInfo queryUserInfoByID(UserInfo u);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<UserInfo> queryUserInfoByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(UserInfo u);
	//用户登录
	public UserInfo login(UserInfo ui);
	//查询所有用户
	public List<UserInfo> queryAllUserInfo();
}
