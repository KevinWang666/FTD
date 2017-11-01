package com.zuikc.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuikc.dao.ResourceDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;
import com.zuikc.service.ResourceService;

@Service("resourceService")
@Transactional
public class ResourceServiceImp implements ResourceService {
	
	@javax.annotation.Resource(name="resourceDao")
	private ResourceDao rd;
	
	@Override
	public void addResource(Resource res) {
		rd.addResource(res);
	}

	@Override
	public void updateResource(Resource res) {
		rd.updateResource(res);
	}

	@Override
	public void deleteResource(Resource res) {
		rd.deleteResource(res);
	}

	@Override
	public void switchStatusResources(String[] ResourceIDs) {
		if (ResourceIDs != null) {
			for (String id : ResourceIDs) {
				Resource Resource = rd.queryResourceByID(new Resource(Integer.parseInt(id)));
				Resource.setStatus("½ûÓÃ");
			}
		}
	}

	@Override
	public List<Resource> queryResourceByPage(Page p) {
		return rd.queryResourceByPage(p);
	}

	@Override
	public Resource queryResourceByID(Resource res) {
		return rd.queryResourceByID(res);
	}

	@Override
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p) {
		return rd.queryResourceByCriteria(attrName, attrValue, p);
	}

	@Override
	public int getRows(Resource res) {
		return rd.getRows(res);
	}

	@Override
	public List<Resource> queryParentResources() {
		
		return rd.queryParentResources();
	}

}
