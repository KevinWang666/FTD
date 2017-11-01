package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;

public interface ResourceDao {
	// 添加资源菜单
	public void addResource(Resource res);

	// 修改资源菜单
	public void updateResource(Resource res);

	// 删除资源菜单
	public void deleteResource(Resource res);

	// 分页查询
	public List<Resource> queryResourceByPage(Page p);

	// 查询单个资源菜单
	public Resource queryResourceByID(Resource res);

	// 条件查询
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p);

	// 获取记录数
	public int getRows(Resource res);
	//查询父级菜单
	public List<Resource> queryParentResources();
}
