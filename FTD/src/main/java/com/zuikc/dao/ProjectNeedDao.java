package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectNeed;

public interface ProjectNeedDao {
	// 添加需求分析
	public void addProjectNeed(ProjectNeed pn);

	// 修改需求分析
	public void updateProjectNeed(ProjectNeed pn);

	// 删除
	public void deleteProjectNeed(ProjectNeed pn);

	// 查询单个需求分析
	public ProjectNeed queryProjectNeedByID(ProjectNeed pn);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<ProjectNeed> queryProjectNeedByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(String attrName, String attrValue);

	// 查询所有
	public List<ProjectNeed> queryAllProjectNeed();

	// 根据项目ID获取需求
	public List<ProjectNeed> queryProjectNeedByProjectID(Integer projectID);
}
