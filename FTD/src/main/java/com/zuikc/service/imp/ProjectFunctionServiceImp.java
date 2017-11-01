package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ProjectFunctionDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFunction;
import com.zuikc.service.ProjectFunctionService;

@Service("projectFunctionService")
@Transactional
public class ProjectFunctionServiceImp implements ProjectFunctionService {
	
	@Resource(name="projectFunctionDao")
	private  ProjectFunctionDao pfd;
	
	@Override
	public void addProjectFunction(ProjectFunction pf) {
		pfd.addProjectFunction(pf);
	}

	@Override
	public void updateProjectFunction(ProjectFunction pf) {
		pfd.updateProjectFunction(pf);
	}

	@Override
	public void deleteProjectFunctions(String[] functionIDs) {
		if (functionIDs != null) {
			for (String string : functionIDs) {
				pfd.deleteProjectFunction(new ProjectFunction(Integer.parseInt(string)));
			}
		}
	}

	@Override
	public ProjectFunction queryProjectFunctionByID(ProjectFunction pf) {
		return pfd.queryProjectFunctionByID(pf);
	}

	@Override
	public List<ProjectFunction> queryProjectFunctionByCriteria(String attrName, String attrValue, String orderAttr,
			Page p) {
		return pfd.queryProjectFunctionByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		return pfd.getRows(attrName, attrValue);
	}

	@Override
	public List<ProjectFunction> queryAllProjectFunction() {
		return pfd.queryAllProjectFunction();
	}

	@Override
	public List<ProjectFunction> queryProjectFunctionByModelID(Integer modelID) {
		return pfd.queryProjectFunctionByModelID(modelID);
	}

}
