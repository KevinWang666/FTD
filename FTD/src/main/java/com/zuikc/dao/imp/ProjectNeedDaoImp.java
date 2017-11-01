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

import com.zuikc.dao.ProjectNeedDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.ProjectNeed;

@Repository("projectNeedDao")
public class ProjectNeedDaoImp implements ProjectNeedDao {
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void addProjectNeed(ProjectNeed pn) {
		Session s = sessionFactory.getCurrentSession();
		s.save(pn);
	}

	@Override
	public void updateProjectNeed(ProjectNeed pn) {
		Session s = sessionFactory.getCurrentSession();
		s.update(pn);
	}

	@Override
	public void deleteProjectNeed(ProjectNeed pn) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(pn);
	}

	@Override
	public ProjectNeed queryProjectNeedByID(ProjectNeed pn) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(ProjectNeed.class, pn.getNeedID());
	}

	@Override
	public List<ProjectNeed> queryProjectNeedByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<ProjectNeed> from1 = ctq.from(ProjectNeed.class);
		Root<Project> from2 = ctq.from(Project.class);
		ctq.multiselect(from1);
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("project"), from2.get("projectID"));
		list.add(equal);
		//ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal2 ;
			if ("needName".equals(attrName)) {
				equal2 = cb.equal(from1.get("needName"), attrValue);
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
		List<ProjectNeed> res = new ArrayList<>();
		List<Tuple> tupleList = query.list();
		for (Tuple tuple : tupleList) {
			res.add((ProjectNeed)tuple.get(0));
		}
		return res;
	}

	@Override
	public int getRows(String attrName, String attrValue) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<ProjectNeed> from1 = ctq.from(ProjectNeed.class);
		Root<Project> from2 = ctq.from(Project.class);
		ctq.multiselect(cb.count(from1));
		
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("project"), from2.get("projectID"));
		list.add(equal);
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal2 ;
			if ("needName".equals(attrName)) {
				equal2 = cb.equal(from1.get("needName"), attrValue);
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
	public List<ProjectNeed> queryAllProjectNeed() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectNeed");
		return query.list();
	}

	@Override
	public List<ProjectNeed> queryProjectNeedByProjectID(Integer projectID) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectNeed where project=?");
		query.setParameter(0, new Project(projectID));
		
		return query.list();
	}

}
