package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ProjectNeedDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectNeed;
import com.zuikc.service.ProjectNeedService;
@Service("projectNeedService")
@Transactional
public class ProjectNeedServieImp implements ProjectNeedService {
	
	@Resource(name="projectNeedDao")
	private ProjectNeedDao pnd;
	
	@Override
	public void addProjectNeed(ProjectNeed pn) {
		pnd.addProjectNeed(pn);
	}

	@Override
	public void updateProjectNeed(ProjectNeed pn) {
		pnd.updateProjectNeed(pn);
	}

	@Override
	public void deleteProjectNeeds(String[] projectNeedIDs) {
		if (projectNeedIDs != null) {
			for (String string : projectNeedIDs) {
				pnd.deleteProjectNeed(new ProjectNeed(Integer.parseInt(string)));
			}
		}
	}

	@Override
	public ProjectNeed queryProjectNeedByID(ProjectNeed pn) {
		
		return pnd.queryProjectNeedByID(pn);
	}

	@Override
	public List<ProjectNeed> queryProjectNeedByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		
		return pnd.queryProjectNeedByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		
		return pnd.getRows(attrName, attrValue);
	}

	@Override
	public List<ProjectNeed> queryAllProjectNeed() {
		
		return pnd.queryAllProjectNeed();
	}

	@Override
	public List<ProjectNeed> queryProjectNeedByProjectID(Integer projectID) {
		return pnd.queryProjectNeedByProjectID(projectID);
	}

}
