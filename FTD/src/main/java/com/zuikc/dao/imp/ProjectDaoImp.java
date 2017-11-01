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

import com.zuikc.dao.ProjectDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Project;
import com.zuikc.domain.UserInfo;

@Repository("projectDao")
public class ProjectDaoImp implements ProjectDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addProject(Project p) {
		Session s = sessionFactory.getCurrentSession();
		s.save(p);
	}

	@Override
	public void updateProject(Project p) {
		Session s = sessionFactory.getCurrentSession();
		s.update(p);
	}

	@Override
	public void deleteProject(Integer projectID) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(new Project(projectID));
	}

	@Override
	public Project queryProjectByID(Project p) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Project.class, p.getProjectID());
	}

	@Override
	public List<Project> queryProjectByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Project> from1 = ctq.from(Project.class);
		Root<UserInfo> from2 = ctq.from(UserInfo.class);
		List<Predicate> list = new ArrayList<>();
		
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal ;
			if ("projectName".equals(attrName)) {
				equal = cb.equal(from1.get("projectName"), attrValue);
			}else {
				equal = cb.equal(from2.get("truename"), attrValue);
			}
			list.add(equal);
		}
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order asc = cb.asc(from1.get(orderAttr));
			ctq.orderBy(asc);
		}
		Predicate equal = cb.equal(from1.get("user"), from2.get("userID"));
		list.add(equal);
		ctq.where(list.toArray(new Predicate[list.size()]));
		ctq.multiselect(from1);
		
		Query<Tuple> query = s.createQuery(ctq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		//System.out.println("--------------------------------------");
		List<Tuple> tupleList = query.list();
		List<Project> res = new ArrayList<>();
		for (Tuple tuple : tupleList) {
			/*System.out.println(tuple);
			System.out.println(tuple.get(0));*/
			res.add((Project) tuple.get(0));
		}
		//System.out.println("----------------------------------------------------------");
		return res;
	}

	@Override
	public int getRows(Project p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Project> from = ctq.from(Project.class);
		Root<UserInfo> from2 = ctq.from(UserInfo.class);
		List<Predicate> list = new ArrayList<>();
		String name;// 项目名称
		String manager;// 项目经理
		if ((name = p.getProjectName()) != null && !"".equals(name)) {
			Predicate equal = cb.equal(from.get("projectName"), name);
			list.add(equal);
		} else if (p.getUser() != null) {
			if ((manager = p.getUser().getTruename()) != null && !"".equals(manager)) {
				Predicate equal = cb.equal(from2.get("truename"), manager);
				list.add(equal);
			}
		}
		// 先尝试自己加条件
		Predicate equal = cb.equal(from.get("user"), from2.get("userID"));
		list.add(equal);
		ctq.where(list.toArray(new Predicate[list.size()]));

		// 这里容易忘记！！！！
		ctq.multiselect(cb.count(from));
		Query<Tuple> query = s.createQuery(ctq);

		return (int) (long) query.list().get(0).get(0);
	}

	@Override
	public List<Project> queryAllProjects() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from Project");
		return query.list();
	}

}
