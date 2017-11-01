package com.zuikc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ProjectFileDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.ProjectFile;
import com.zuikc.service.ProjectFileService;

@Service("projectFileService")
@Transactional
public class ProjectFileServiceImp implements ProjectFileService {
	
	@Resource(name="projectFileDao")
	private ProjectFileDao pfd;
	
	@Override
	public void addProjectFile(ProjectFile pfile) {
		pfd.addProjectFile(pfile);
	}

	@Override
	public void updateProjectFile(ProjectFile pfile) {
		pfd.updateProjectFile(pfile);
	}

	@Override
	public void deleteProjectFiles(String[] projectFileIDs) {
		if (projectFileIDs != null) {
			for (String string : projectFileIDs) {
				pfd.deleteProjectFile(new ProjectFile(Integer.parseInt(string)));
			}
		}
	}

	@Override
	public ProjectFile queryProjectFileByID(ProjectFile pfile) {
		return pfd.queryProjectFileByID(pfile);
	}

	@Override
	public List<ProjectFile> queryProjectFileByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		return pfd.queryProjectFileByCriteria(attrName, attrValue, orderAttr, p);
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		return pfd.getRows(attrName, attrValue);
	}

	@Override
	public List<ProjectFile> queryAllProjectFile() {
		return pfd.queryAllProjectFile();
	}

}
