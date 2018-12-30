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
		init();
		
		
	}
	
	@Test
	public void test() {
		HomePage page = new HomePage();
	}

}
