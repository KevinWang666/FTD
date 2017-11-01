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

import com.zuikc.dao.ProjectFunctionDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.ProjectFunction;
import com.zuikc.domain.ProjectModel;
import com.zuikc.domain.ProjectNeed;

@Repository("projectFunctionDao")
public class ProjectFunctionDaoImp implements ProjectFunctionDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addProjectFunction(ProjectFunction pf) {
		Session s = sessionFactory.getCurrentSession();
		s.save(pf);
	}

	@Override
	public void updateProjectFunction(ProjectFunction pf) {
		Session s = sessionFactory.getCurrentSession();
		s.update(pf);
	}

	@Override
	public void deleteProjectFunction(ProjectFunction pf) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(pf);
	}

	@Override
	public ProjectFunction queryProjectFunctionByID(ProjectFunction pf) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(ProjectFunction.class, pf.getFunctionID());
	}

	@Override
	public List<ProjectFunction> queryProjectFunctionByCriteria(String attrName, String attrValue, String orderAttr,
			Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Project> from1 = ctq.from(Project.class);
		Root<ProjectNeed> from2 = ctq.from(ProjectNeed.class);
		Root<ProjectModel> from3 = ctq.from(ProjectModel.class);
		Root<ProjectFunction> from4 = ctq.from(ProjectFunction.class);
		ctq.multiselect(from4);

		List<Predicate> list = new ArrayList<>();
		Predicate equal1 = cb.equal(from2.get("project"), from1.get("projectID"));
		Predicate equal2 = cb.equal(from3.get("projectNeed"), from2.get("needID"));
		Predicate equal3 = cb.equal(from4.get("projectModel"), from3.get("modelID"));
		list.add(equal1);
		list.add(equal2);
		list.add(equal3);
		// ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal4;
			if ("projectName".equals(attrName)) {
				equal4 = cb.equal(from1.get("projectName"), attrValue);
			} else if ("needName".equals(attrName)) {
				equal4 = cb.equal(from2.get("needName"), attrValue);
			} else if ("modelName".equals(attrName)) {
				equal4 = cb.equal(from3.get("modelName"), attrValue);
			} else {
				equal4 = cb.equal(from4.get("functionName"), attrValue);
			}
			list.add(equal4);
		}
		// ÅÅÐò
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order asc = cb.asc(from4.get(orderAttr));
			ctq.orderBy(asc);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));

		Query<Tuple> query = s.createQuery(ctq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());

		List<ProjectFunction> res = new ArrayList<>();
		List<Tuple> tupleList = query.list();
		for (Tuple tuple : tupleList) {
			res.add((ProjectFunction) tuple.get(0));
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
		Root<ProjectFunction> from4 = ctq.from(ProjectFunction.class);
		
		ctq.multiselect(cb.count(from4));

		List<Predicate> list = new ArrayList<>();
		Predicate equal1 = cb.equal(from2.get("project"), from1.get("projectID"));
		Predicate equal2 = cb.equal(from3.get("projectNeed"), from2.get("needID"));
		Predicate equal3 = cb.equal(from4.get("projectModel"), from3.get("modelID"));
		list.add(equal1);
		list.add(equal2);
		list.add(equal3);
		// ËÑË÷
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal4;
			if ("projectName".equals(attrName)) {
				equal4 = cb.equal(from1.get("projectName"), attrValue);
			} else if ("needName".equals(attrName)) {
				equal4 = cb.equal(from2.get("needName"), attrValue);
			} else if ("modelName".equals(attrName)) {
				equal4 = cb.equal(from3.get("modelName"), attrValue);
			} else {
				equal4 = cb.equal(from4.get("functionName"), attrValue);
			}
			list.add(equal4);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));

		Query<Tuple> query = s.createQuery(ctq);

		return (int) (long) query.list().get(0).get(0);
	}

	@Override
	public List<ProjectFunction> queryAllProjectFunction() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectFunction");
		return query.list();
	}

	@Override
	public List<ProjectFunction> queryProjectFunctionByModelID(Integer modelID) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from ProjectFunction where projectModel=?");
		query.setParameter(0, new ProjectModel(modelID));
		return query.list();
	}

}
