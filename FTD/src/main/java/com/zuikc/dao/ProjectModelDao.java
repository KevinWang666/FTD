package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectModel;

public interface ProjectModelDao {

	// 添加模块
	public void addProjectModel(ProjectModel pm);

	// 修改模块
	public void updateProjectModel(ProjectModel pm);

	// 删除
	public void deleteProjectModel(ProjectModel pm);

	// 查询单个模块
	public ProjectModel queryProjectModelByID(ProjectModel pm);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<ProjectModel> queryProjectModelByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(String attrName, String attrValue);

	// 查询所有
	public List<ProjectModel> queryAllProjectModel();
	//根据需求ID获取模块列表
	public List<ProjectModel> queryProjectModelByNeedID(Integer needID);
}
