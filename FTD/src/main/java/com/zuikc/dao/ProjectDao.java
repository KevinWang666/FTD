package com.zuikc.dao;

import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.Project;

public interface ProjectDao {
	// 添加项目基本信息
	public void addProject(Project p);

	// 修改项目基本信息
	public void updateProject(Project p);

	// 删除项目基本信息
	public void deleteProject(Integer projectID);

	// 查询单个项目基本信息
	public Project queryProjectByID(Project p);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<Project> queryProjectByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(Project p);
	//查询所有
	public List<Project> queryAllProjects();
}
