package com.suthan.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			Properties prop = cfg.getProperties();
			
			builder=builder.applySettings(prop);
			
			StandardServiceRegistry registry =builder.build();
			
			sessionfactory=cfg.buildSessionFactory(registry);
			
		
			
			session = sessionfactory.openSession();
			tx=session.beginTransaction();
		Employee emp = new Employee();
		//emp.setEno(5);
		emp.setEname("AAA");
		emp.setEsal(1000);
		emp.setEaddr("London");
		session.save(emp);
		tx.commit();
		System.out.println("Employee insert successfulluy");
		
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Employee insert failure");
		}finally {
			session.close();
			sessionfactory.close();
		}

	}

}