package com.google.qa.testcases;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.google.qa.base.TestBase;
import com.google.qa.db.LuxDetails;
import com.google.qa.pages.HomePage;

public class MyTest extends TestBase{

	public MyTest() {
		super();
		
		
	}
	
	@Before
	public void SetUp() {
		init();
		
		
	}											 			
	
	@Test
	public void test() {
		HomePage page = new HomePage();
		page.Search("real madrid");
		
		LuxDetails details = new LuxDetails();
		details.setTeamID(5);
		details.setName("real");
		details.setRank(1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(details);
		
		session.getTransaction().commit();
		
	    assertEquals("title wrong", "real madrid - Google Search", page.getTtile());
	}

}
