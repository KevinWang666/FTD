package com.zuikc.service;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;

public interface ResourceService {
	// 添加资源菜单
	public void addResource(Resource res);

	// 修改资源菜单
	public void updateResource(Resource res);

	// 删除
	public void deleteResource(Resource res);

	// 批量禁用资源菜单
	public void switchStatusResources(String[] resourceIDs);

	// 分页查询
	public List<Resource> queryResourceByPage(Page p);

	// 查询单个资源菜单
	public Resource queryResourceByID(Resource res);

	/*
	 * 条件查询 参数：查询的字段名， 关键字
	 */
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p);

	// 获取记录数
	public int getRows(Resource res);
	//查询所有的父级菜单
	public List<Resource> queryParentResources();

}
