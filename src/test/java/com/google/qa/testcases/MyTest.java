package com.google.qa.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.qa.base.TestBase;
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
		
	 
	    assertEquals("title wrong", "barcelona - Google Search", page.getTtile());
	}

}
