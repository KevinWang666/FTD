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

	//手动处理事务
	@Test
	public void testTransaction() {
		//定义事务属性
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		dtd.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		dtd.setTimeout(10);
		//平台模版
		PlatformTransactionManager ptm = new HibernateTransactionManager(sf);
		//获得事务状态
		TransactionStatus transactionStatus = ptm.getTransaction(dtd);
		//数据库操作.....
		
		//提交
		ptm.commit(transactionStatus);
		//回滚
		ptm.rollback(transactionStatus);
	}

	@Test
	public void testCreatTable() throws Exception {
		// 5.x创建表的方法
		Configuration config = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void testAdd() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Customer c = new Customer("qqq", "唐马儒", "火星", "911", "12581", "无", "懒得写", sdf.parse("1888-8-8"),
				sdf.parse("2000-0-0"));
		Customer random = new Customer(getRandomString(5), getRandomString(3), getRandomString(6), getRandomNumber(11),
				getRandomNumber(6), "无", "懒得写", sdf.parse("1988-9-9"), sdf.parse("2333-3-3"));
		cs.addCustomer(random);
	}

	@Test
	public void testUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Customer c = new Customer(3, "qqq", "叶良辰", "江湖", "911", "12581", "无", "懒得写", sdf.parse("1755-3-8"),
				sdf.parse("2333-3-3"));
		cs.updateCustomer(c);
	}

	@Test
	public void testQuery() throws Exception {
		// 记录数
		cs.getRows(new Customer());
		// 单个查询
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
		List<Customer> queryCustomerByCriteria = cs.queryCustomerByCriteria("contact", "唐马儒", "pubdate",
				new Page(100, 1));
		System.out.println(queryCustomerByCriteria);
		System.out.println("==================================================");
		// 空值处理
		List<Customer> queryCustomerByCriteria1 = cs.queryCustomerByCriteria(null, null, "customerID",
				new Page(100, 1));
		System.out.println(queryCustomerByCriteria1);

	}

	// 随机字符
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// 随机数字
	public static String getRandomNumber(int length) { // length表示生成字符串的长度
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
