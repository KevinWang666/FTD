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

import com.zuikc.dao.ProjectModelDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.ProjectModel;
import com.zuikc.domain.ProjectNeed;

@Repository("projectModelDao")
public class ProjectModelDaoImp implements ProjectModelDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void addProjectModel(ProjectModel pm) {
		Session s = sessionFactory.getCurrentSession();
		s.save(pm);
	}

	@Override
	public void updateProjectModel(ProjectModel pm) {
		Session s = sessionFactory.getCurrentSession();
		s.update(pm);
	}

	@Override
	public void deleteProjectModel(ProjectModel pm) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(pm);
	}

	@Override
	public ProjectModel queryProjectModelByID(ProjectModel pm) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(ProjectModel.class, pm.getModelID());
	}

	@Override
	public List<ProjectModel> queryProjectModelByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Project> from1 = ctq.from(Project.class);
		Root<ProjectNeed> from2 = ctq.from(ProjectNeed.class);
		Root<ProjectModel> from3 = ctq.from(ProjectModel.class);
		ctq.multiselect(from3);
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal1 = cb.equal(from2.get("project"), from1.get("projectID"));
		Predicate equal2 = cb.equal(from3.get("projectNeed"), from2.get("needID"));
		list.add(equal1);
		list.add(equal2);
		//ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal3 ;  
			if ("projectName".equals(attrName)) {
				equal3 = cb.equal(from1.get("projectName"), attrValue);
			} else if ("needName".equals(attrName)) {
				equal3 = cb.equal(from2.get("needName"), attrValue);
			} else {
				equal3 = cb.equal(from3.get("modelName"), attrValue);
			}
			list.add(equal3);
		} 
		//ÅÅÐò
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order asc = cb.asc(from3.get(orderAttr));
			ctq.orderBy(asc);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		
		List<ProjectModel> res = new ArrayList<>();
		List<Tuple> tupleList = query.list();
		for (Tuple tuple : tupleList) {
			res.add((ProjectModel)tuple.get(0));
		}
		return res;
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Project> from1 = ctq.from(Project.class);
		Root<ProjectNeed> from2 = ctq.from(ProjectNeed.class);
		Root<ProjectModel> from3 = ctq.from(ProjectModel.class);
		ctq.multiselect(cb.count(from3));
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal1 = cb.equal(from2.get("project"), from1.get("projectID"));
		Predicate equal2 = cb.equal(from3.get("projectNeed"), from2.get("needID"));
		list.add(equal1);
		list.add(equal2);
		//ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal3 ;  
			if ("projectName".equals(attrName)) {
				equal3 = cb.equal(from1.get("projectName"), attrValue);
			} else if ("needName".equals(attrName)) {
				equal3 = cb.equal(from2.get("needName"), attrValue);
			} else {
				equal3 = cb.equal(from3.get("modelName"), attrValue);
			}
			list.add(equal3);
		} 
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		
		return (int)(long)query.list().get(0).get(0);
	}

	@Override
	public List<ProjectModel> queryAllProjectModel() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectModel");
		return query.list();
	}

	@Override
	public List<ProjectModel> queryProjectModelByNeedID(Integer needID) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectModel where projectNeed=?");
		query.setParameter(0, new ProjectNeed(needID));
		return query.list();
	}

}
