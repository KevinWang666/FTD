package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ProjectDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.service.ProjectService;

@Service("projectService")
@Transactional
public class ProjectServiceImp implements ProjectService {

	@Resource(name = "projectDao")
	private ProjectDao pd;

	@Override
	public void addProject(Project p) {
		pd.addProject(p);
	}

	@Override
	public void updateProject(Project p) {
		pd.updateProject(p);
	}

	@Override
	public void deleteProjects(String[] projectIDs) {
		if (projectIDs != null) {
			for (String string : projectIDs) {
				pd.deleteProject(Integer.parseInt(string));
			}
		}
	}

	@Override
	public Project queryProjectByID(Project p) {

		return pd.queryProjectByID(p);
	}

	@Override
	public List<Project> queryProjectByCriteria(String attrName, String attrValue, String orderAttr, Page p) {

		return pd.queryProjectByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(Project p) {

		return pd.getRows(p);
	}

	@Override
	public List<Project> queryAllProjects() {
		return pd.queryAllProjects();
	}

}
