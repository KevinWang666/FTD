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

import com.zuikc.dao.CustomerDao;
import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;

@Repository("customerDao")
public class CustomerDaoImp implements CustomerDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer c) {
		Session s = sessionFactory.getCurrentSession();
		s.save(c);
	}

	@Override
	public void updateCustomer(Customer c) {
		Session s = sessionFactory.getCurrentSession();
		s.update(c);
	}

	@Override
	public void deleteCustomer(Customer c) {
		Session s = sessionFactory.getCurrentSession();
		s.delete(c);
	}

	@Override
	public List<Customer> queryCustomerByPage(Page p) {
		Session s = sessionFactory.getCurrentSession();
		String queryString = "from Customer";
		Query<Customer> query = s.createQuery(queryString, Customer.class);
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		List<Customer> list = query.list();
		return list;
	}

	@Override
	public Customer queryCustomerByID(Customer c) {
		Session s = sessionFactory.getCurrentSession();
		Customer customer = s.get(Customer.class, c.getCustomerID());
		return customer;
	}

	@Override
	public List<Customer> queryCustomerByCriteria(String attrName, String attrValue, String orderAttr , Page p) {
		Session s = sessionFactory.getCurrentSession();
		//��ѯ����
		CriteriaBuilder cb = s.getCriteriaBuilder();
		//��ѯ������
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		//Ҫ��ѯ�Ķ���
		Root<Customer> root = cq.from(Customer.class);
		//����
		if (attrName != null && !"".equals(attrName)) {
			Predicate predicate = cb.equal(root.get(attrName), attrValue);
			cq.where(predicate);
		}
		//����
		if (orderAttr != null && !"".equals(orderAttr)) {
			Order order = cb.desc(root.get(orderAttr));
			cq.orderBy(order);
		}
		
		Query<Customer> query = s.createQuery(cq);
		//��ҳ
		query.setFirstResult(p.getStartNo());
		query.setMaxResults(p.getPAGE_SIZE());
		
		return query.list();
	}

	@Override
	public int getRows(Customer c) {
		//��û�и��򵥵ķ�������������������ˡ�����
		Session s = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Tuple> createTupleQuery = cb.createTupleQuery();
		Root<Customer> root = createTupleQuery.from(Customer.class);
		String customerName ;
		String contact ;
		if ((customerName = c.getCustomerName()) != null && !"".equals(customerName)) {
			Predicate equal = cb.equal(root.get("customerName"), customerName);
			createTupleQuery.where(equal);
		}else if (( contact = c.getContact() ) != null && !"".equals(contact)) {
			Predicate equal = cb.equal(root.get("contact"), contact );
			createTupleQuery.where(equal);
		}
		createTupleQuery.multiselect(cb.count(root));
		Query<Tuple> createQuery = s.createQuery(createTupleQuery);
		List<Tuple> list = createQuery.list();
		
		return (int)(long)list.get(0).get(0);
	}

	@Override
	public List<Customer> queryAllCustomer() {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery("from Customer");
		return query.list();
	}

}
