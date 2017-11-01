package com.zuikc.service;
/*
 * ��Ա����
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.UserInfo;

public interface UserInfoService {
	// �����Ա
	public void addUserInfo(UserInfo u);

	// �޸���Ա
	public void updateUserInfo(UserInfo u);

	// ɾ��
	public void deleteUserInfo(UserInfo u);

	// ����ע����Ա
	public void switchStatusUserInfos(String[] UserInfoIDs);

	// ��ҳ��ѯ
	public List<UserInfo> queryUserInfoByPage(Page p);

	// ��ѯ������Ա
	public UserInfo queryUserInfoByID(UserInfo u);

	/*
	 * ������ѯ ��������ѯ���ֶ����� �ؼ��֣������ֶ�
	 */
	public List<UserInfo> queryUserInfoByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// ��ȡ��¼��
	public int getRows(UserInfo u);
	//�û���¼
	public UserInfo login(UserInfo ui);
	//��ѯ�����û�
	public List<UserInfo> queryAllUserInfo();
}
