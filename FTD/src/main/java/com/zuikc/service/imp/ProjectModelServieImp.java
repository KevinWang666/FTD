package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ProjectModelDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectModel;
import com.zuikc.service.ProjectModelService;

@Service("projectModelService")
@Transactional
public class ProjectModelServieImp implements ProjectModelService {
	
	@Resource(name="projectModelDao")
	private  ProjectModelDao pmd;
	
	@Override
	public void addProjectModel(ProjectModel pm) {
		pmd.addProjectModel(pm);
	}

	@Override
	public void updateProjectModel(ProjectModel pm) {
		pmd.updateProjectModel(pm);
	}

	@Override
	public void deleteProjectModels(String[] projectModelIDs) {
		if (projectModelIDs != null) {
			for (String string : projectModelIDs) {
				pmd.deleteProjectModel(new ProjectModel(Integer.parseInt(string)));
			}
		}
	}

	@Override
	public ProjectModel queryProjectModelByID(ProjectModel pm) {
		return pmd.queryProjectModelByID(pm);
	}

	@Override
	public List<ProjectModel> queryProjectModelByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		return pmd.queryProjectModelByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		return pmd.getRows(attrName, attrValue);
	}

	@Override
	public List<ProjectModel> queryAllProjectModel() {
		return pmd.queryAllProjectModel();
	}

	@Override
	public List<ProjectModel> queryProjectModelByNeedID(Integer needID) {
		return pmd.queryProjectModelByNeedID(needID);
	}

}
