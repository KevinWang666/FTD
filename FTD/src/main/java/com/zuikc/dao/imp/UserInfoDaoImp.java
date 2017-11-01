package com.zuikc.dao.imp;

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

import com.zuikc.dao.UserInfoDao;
import com.zuikc.domain.Page;
import com.zuikc.domain.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImp implements UserInfoDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addUserInfo(UserInfo u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
	}

	@Override
	public void updateUserInfo(UserInfo u) {
		Session s = sessionFactory.getCurrentSession();
		s.update(u);
	}

	@Override
	public void deleteUserInfo(UserInfo u) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(u);
	}

	@Override
	public List<UserInfo> queryUserInfoByPage(Page p) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from UserInfo");
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());

		return query.list();
	}

	@Override
	public UserInfo queryUserInfoByID(UserInfo u) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(UserInfo.class, u.getUserID());
	}

	@Override
	public List<UserInfo> queryUserInfoByCriteria(String attrName, String attrValue, String orderAttr, Page p) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
		Root<UserInfo> from = cq.from(UserInfo.class);
		if (attrName != null && !"".equals(attrName)) {
			Predicate equal = cb.equal(from.get(attrName), attrValue);
			cq.where(equal);
		}
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order asc = cb.asc(from.get(orderAttr));
			cq.orderBy(asc);
		}
		Query<UserInfo> query = s.createQuery(cq);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());

		return query.list();
	}

	@Override
	public int getRows(UserInfo u) {
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> ctq = cb.createTupleQuery();
		Root<UserInfo> from = ctq.from(UserInfo.class);
		String name;
		String phone;
		if ((name = u.getTruename()) != null && !"".equals(name)) {
			Predicate equal = cb.equal(from.get("truename"), name);
			ctq.where(equal);
		} else if ((phone = u.getCellphone()) != null && !"".equals(phone)) {
			Predicate equal = cb.equal(from.get("cellphone"), phone);
			ctq.where(equal);
		}
		//这里容易忘记！！！！
		ctq.multiselect(cb.count(from));
		Query<Tuple> query = s.createQuery(ctq);

		return (int) (long) query.list().get(0).get(0);
	}

	@Override
	public UserInfo login(UserInfo ui) {
		Session s = sessionFactory.getCurrentSession();
		String queryString = "from UserInfo where username=? and pwd=?";
		Query query = s.createQuery(queryString);
		query.setParameter(0, ui.getUsername());
		query.setParameter(1, ui.getPwd());
		List list = query.list();
		if (list != null) {
			return (UserInfo) list.get(0);
		}
		return null;
	}

	@Override
	public List<UserInfo> queryAllUserInfo() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from UserInfo");
		return query.list();
	}

}
