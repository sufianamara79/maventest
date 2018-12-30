package com.google.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTtile() {
		
		return driver.getTitle();
	}

}
