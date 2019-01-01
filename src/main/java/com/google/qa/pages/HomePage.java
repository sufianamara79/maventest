package com.google.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;
	
	@FindBy(how = How.NAME, using = "btnK")
    private WebElement btnSearch;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTtile() {
		
		return driver.getTitle();
	}
	
	public void Search(String text) {
		
		searchBox.sendKeys(text);
		btnSearch.submit();
	}

}
