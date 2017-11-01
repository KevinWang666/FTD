package com.zuikc.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zuikc.dao.ProjectFileDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.ProjectFile;

@Repository("projectFileDao")
public class ProjectFileDaoImp implements ProjectFileDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addProjectFile(ProjectFile pfile) {
		Session s = sessionFactory.getCurrentSession();
		s.save(pfile);
	}

	@Override
	public void updateProjectFile(ProjectFile pfile) {
		Session s = sessionFactory.getCurrentSession();
		s.update(pfile);
	}

	@Override
	public void deleteProjectFile(ProjectFile pfile) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(pfile);
	}

	@Override
	public ProjectFile queryProjectFileByID(ProjectFile pfile) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(ProjectFile.class, pfile.getFileID());
	}

	@Override
	public List<ProjectFile> queryProjectFileByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<ProjectFile> from1 = ctq.from(ProjectFile.class);
		Root<Project> from2 = ctq.from(Project.class);
		ctq.multiselect(from1);
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("project"), from2.get("projectID"));
		list.add(equal);
		//ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal2 ;
			if ("filename".equals(attrName)) {
				equal2 = cb.equal(from1.get("filename"), attrValue);
			} else {
				equal2 = cb.equal(from2.get("projectName"), attrValue);
			}
			list.add(equal2);
		} 
		//ÅÅÐò
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order asc = cb.asc(from1.get(orderAttr));
			ctq.orderBy(asc);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		List<ProjectFile> res = new ArrayList<>();
		List<Tuple> tupleList = query.list();
		for (Tuple tuple : tupleList) {
			res.add((ProjectFile)tuple.get(0));
		}
		return res;
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<ProjectFile> from1 = ctq.from(ProjectFile.class);
		Root<Project> from2 = ctq.from(Project.class);
		ctq.multiselect(cb.count(from1));
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("project"), from2.get("projectID"));
		list.add(equal);
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal2 ;
			if ("filename".equals(attrName)) {
				equal2 = cb.equal(from1.get("filename"), attrValue);
			} else {
				equal2 = cb.equal(from2.get("projectName"), attrValue);
			}
			list.add(equal2);
		} 
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		
		return (int)(long)query.list().get(0).get(0);
	}

	@Override
	public List<ProjectFile> queryAllProjectFile() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectFile");
		return query.list();
	}
	
	
}
