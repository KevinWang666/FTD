package com.zuikc.dao.imp;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zuikc.dao.ResourceDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Resource;

@Repository("resourceDao")
public class ResourceDaoImp implements ResourceDao {
	@javax.annotation.Resource
	private SessionFactory sessionFactory;

	@Override
	public void addResource(Resource res) {
		Session s = sessionFactory.getCurrentSession();
		s.save(res);
	}

	@Override
	public void updateResource(Resource res) {
		Session s = sessionFactory.getCurrentSession();
		s.update(res);
	}

	@Override
	public void deleteResource(Resource res) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(res);
	}

	@Override
	public List<Resource> queryResourceByPage(Page p) {
		Session s = sessionFactory.getCurrentSession();
		String queryString = "from Resource";
		Query query = s.createQuery(queryString);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		
		return query.list();
	}

	@Override
	public Resource queryResourceByID(Resource res) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Resource.class, res.getResourceID());
	}

	@Override
	public List<Resource> queryResourceByCriteria(String attrName, String attrValue, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Resource> cq = cb.createQuery(Resource.class);
		Root<Resource> from = cq.from(Resource.class);
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal = cb.equal(from.get(attrName), attrValue);
			cq.where(equal);
		}
		Query<Resource> query = s.createQuery(cq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		return query.list();
	}

	@Override
	public int getRows(Resource res) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Resource> from = cq.from(Resource.class);
		String name ;
		if (( name = res.getResourceName() )!= null && !"".equals(name)) {
			Predicate equal = cb.equal(from.get("resourceName"), name);
			cq.where(equal);
		}
		cq.multiselect(cb.count(from));
		Query<Tuple> query = s.createQuery(cq);
		return ((Long)query.list().get(0).get(0)).intValue();
	}

	@Override
	public List<Resource> queryParentResources() {
		Session s = sessionFactory.getCurrentSession();
		String queryString = "from Resource where parent is null";
		Query query = s.createQuery(queryString);
		
		return query.list();
	}

}
