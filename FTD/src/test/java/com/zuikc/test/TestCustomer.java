package com.zuikc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zuikc.domain.Customer;
import com.zuikc.domain.Page;
import com.zuikc.service.CustomerService;

public class TestCustomer {

	SessionFactory sf;
	CustomerService cs;
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		sf = (SessionFactory) ac.getBean("sessionFactory");
		cs = (CustomerService) ac.getBean("customerService");
	}

	//�ֶ���������
	@Test
	public void testTransaction() {
		//������������
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		dtd.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		dtd.setTimeout(10);
		//ƽ̨ģ��
		PlatformTransactionManager ptm = new HibernateTransactionManager(sf);
		//�������״̬
		TransactionStatus transactionStatus = ptm.getTransaction(dtd);
		//���ݿ����.....
		
		//�ύ
		ptm.commit(transactionStatus);
		//�ع�
		ptm.rollback(transactionStatus);
	}

	@Test
	public void testCreatTable() throws Exception {
		// 5.x������ķ���
		Configuration config = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void testAdd() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Customer c = new Customer("qqq", "������", "����", "911", "12581", "��", "����д", sdf.parse("1888-8-8"),
				sdf.parse("2000-0-0"));
		Customer random = new Customer(getRandomString(5), getRandomString(3), getRandomString(6), getRandomNumber(11),
				getRandomNumber(6), "��", "����д", sdf.parse("1988-9-9"), sdf.parse("2333-3-3"));
		cs.addCustomer(random);
	}

	@Test
	public void testUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Customer c = new Customer(3, "qqq", "Ҷ����", "����", "911", "12581", "��", "����д", sdf.parse("1755-3-8"),
				sdf.parse("2333-3-3"));
		cs.updateCustomer(c);
	}

	@Test
	public void testQuery() throws Exception {
		// ��¼��
		cs.getRows(new Customer());
		// ������ѯ
		Customer queryCustomerByID = cs.queryCustomerByID(new Customer(1));
		System.out.println(queryCustomerByID);
	}

	@Test
	public void testRows() throws Exception {
		Customer c = new Customer();
		c.setCustomerName("qqq");
		int rows = cs.getRows(c);
		System.out.println(rows);
	}

	@Test
	public void testQueryByCriteria() throws Exception {
		//
		List<Customer> queryCustomerByCriteria = cs.queryCustomerByCriteria("contact", "������", "pubdate",
				new Page(100, 1));
		System.out.println(queryCustomerByCriteria);
		System.out.println("==================================================");
		// ��ֵ����
		List<Customer> queryCustomerByCriteria1 = cs.queryCustomerByCriteria(null, null, "customerID",
				new Page(100, 1));
		System.out.println(queryCustomerByCriteria1);

	}

	// ����ַ�
	public static String getRandomString(int length) { // length��ʾ�����ַ����ĳ���
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// �������
	public static String getRandomNumber(int length) { // length��ʾ�����ַ����ĳ���
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
