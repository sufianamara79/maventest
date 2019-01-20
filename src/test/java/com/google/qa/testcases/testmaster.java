package com.google.qa.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.HomePage;

public class testmaster extends TestBase{

	public testmaster() {
		super();
		
		
	}
	
	@Before
	public void SetUp() {
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void test() {
		HomePage page = new HomePage();
		
	    assertEquals("go  have coffe)", true, 2);
	}

}
