package com.zuikc.service;

/*
 * 功能管理
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFunction;

public interface ProjectFunctionService {
	// 添加功能
	public void addProjectFunction(ProjectFunction pf);

	// 修改功能
	public void updateProjectFunction(ProjectFunction pf);

	// 批量删除
	public void deleteProjectFunctions(String[] projectFunctionIDs);

	// 查询单个功能
	public ProjectFunction queryProjectFunctionByID(ProjectFunction pf);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<ProjectFunction> queryProjectFunctionByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(String attrName, String attrValue);

	// 查询所有
	public List<ProjectFunction> queryAllProjectFunction();

	// 根据模块ID获取功能列表
	public List<ProjectFunction> queryProjectFunctionByModelID(Integer modelID);
}
