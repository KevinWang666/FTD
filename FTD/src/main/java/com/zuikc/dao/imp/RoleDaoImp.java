package com.zuikc.dao.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zuikc.dao.RoleDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Role;
@Repository("roleDao")
public class RoleDaoImp implements RoleDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role r) {
		Session s = sessionFactory.getCurrentSession();
		s.save(r);
	}

	@Override
	public void updateRole(Role r) {
		Session s = sessionFactory.getCurrentSession();
		s.update(r);
	}

	@Override
	public void deleteRole(Role r) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(r);
	}

	@Override
	public int getRows(Role r) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> createTupleQuery = cb.createTupleQuery();
		Root<Role> from = createTupleQuery.from(Role.class);
		String name ;
		if ((name = r.getRoleName()) != null && !"".equals(name)) {
			Predicate equal = cb.equal(from.get("roleName"), name);
			createTupleQuery.where(equal);
		}
		createTupleQuery.multiselect(cb.count(from));
		Query<Tuple> createQuery = s.createQuery(createTupleQuery);
		Tuple tuple = createQuery.list().get(0);
		return (int)(long)tuple.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryRoleByPage(Page p) {
		Session s = sessionFactory.getCurrentSession();
		String queryString = "from Role";
		Query<Role> query = s.createQuery(queryString);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		
		return query.list();
	}

	@Override
	public Role queryRoleByID(Role r) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Role.class, r.getRoleID());
	}

	@Override
	public List<Role> queryRoleByCriteria(String attrName, String attrValue, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Role> cq = cb.createQuery(Role.class);
		Root<Role> from = cq.from(Role.class);
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal = cb.equal(from.get(attrName), attrValue);
			cq.where(equal);
		}
		Query<Role> query = s.createQuery(cq);
		
		return query.list();
	}

	@Override
	public List<Role> queryAllRole() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from Role");
		return query.list();
	}

}
