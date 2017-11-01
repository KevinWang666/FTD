package com.zuikc.service;
/*
 * 项目文件管理
 * */
import java.util.List;

import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFile;


public interface ProjectFileService {
	// 添加文件
	public void addProjectFile(ProjectFile pfile);

	// 修改文件
	public void updateProjectFile(ProjectFile pfile);

	// 批量删除
	public void deleteProjectFiles(String[] projectFileIDs);

	// 查询单个文件
	public ProjectFile queryProjectFileByID(ProjectFile pfile);

	/*
	 * 条件查询 参数：查询的字段名， 关键字，排序字段
	 */
	public List<ProjectFile> queryProjectFileByCriteria(String attrName, String attrValue, String orderAttr, Page p);

	// 获取记录数
	public int getRows(String attrName, String attrValue);

	// 查询所有
	public List<ProjectFile> queryAllProjectFile();
	
}
