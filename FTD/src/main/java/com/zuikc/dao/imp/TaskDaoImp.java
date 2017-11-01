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

import com.zuikc.dao.TaskDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.Task;
import com.zuikc.domain.UserInfo;

@Repository("taskDao")
public class TaskDaoImp implements TaskDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public int getRows(String status, String cid, String keyword) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Task> from1 = ctq.from(Task.class);
		Root<UserInfo> from2 = ctq.from(UserInfo.class);
		
		ctq.multiselect(cb.count(from1));
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("exeUser"),from2.get("userID"));
		list.add(equal);
		//任务状态
		if (status != null && !"".equals(status)) {
			Predicate equal2 = cb.equal(from1.get("status"), status);
			list.add(equal2);
		}
		//任务标题，执行者
		if (cid != null && !"".equals(cid)) {
			Predicate equal3 ;
			if ("taskname".equals(cid)) {
				equal3 = cb.equal(from1.get("taskname"), keyword);
			} else {
				equal3 = cb.equal(from2.get("truename"), keyword);
			}
			list.add(equal3);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		
		return (int)(long)query.list().get(0).get(0);
	}

	@Override
	public List<Task> queryTaskByCriteria(String status, String cid, String keyword, String orderby, Page page) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<Task> from1 = ctq.from(Task.class);
		Root<UserInfo> from2 = ctq.from(UserInfo.class);
		
		ctq.multiselect(from1);
		List<Predicate> list = new ArrayList<>();
		Predicate equal = cb.equal(from1.get("exeUser"),from2.get("userID"));
		list.add(equal);
		//任务状态
		if (status != null && !"".equals(status)) {
			Predicate equal2 = cb.equal(from1.get("status"), status);
			list.add(equal2);
		}
		//任务标题，执行者
		if (cid != null && !"".equals(cid)) {
			Predicate equal3 ;
			if ("taskname".equals(cid)) {
				equal3 = cb.equal(from1.get("taskname"), keyword);
			} else {
				equal3 = cb.equal(from2.get("truename"), keyword);
			}
			list.add(equal3);
		}
		//排序
		if (orderby != null && !"".equals(orderby)) {
			Order asc = cb.asc(from1.get(orderby));
			ctq.orderBy(asc);
		}
		ctq.where(list.toArray(new Predicate[list.size()]));
		
		Query<Tuple> query = s.createQuery(ctq);
		query.setFirstResult(page.getStartNo());
		query.setMaxResults(page.getPAGE_SIZE());
		List<Task> res = new ArrayList<>();
		List<Tuple> list2 = query.list();
		for (Tuple tuple : list2) {
			res.add((Task)tuple.get(0));
		}
		
		return res;
	}

	@Override
	public Task queryTaskByID(Task t) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Task.class, t.getTaskID());
	}

	@Override
	public void addTask(Task t) {
		Session s = sessionFactory.getCurrentSession();
		s.save(t);
	}

	@Override
	public void updateTask(Task t) {
		Session s = sessionFactory.getCurrentSession();
		s.update(t);
	}

	@Override
	public void deleteTask(Task t) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(t);
	}
	
	@Override
	public int getRowsByUser(UserInfo user) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("select count(*) from Task where exeUser=?");
		query.setParameter(0, user);
		List<Long> list = query.list();
		
		return list.get(0).intValue();
	}

	@Override
	public List<Task> queryTaskByExeuser(UserInfo user , Page p) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from Task where exeUser=?");
		query.setParameter(0, user);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		return query.list();
	}


}
