package com.google.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public TestBase() {
		InputStream input = null;
		try {
			

			input = new FileInputStream("/Users/sufianamara/eclipse-workspace/maventest/src/main/java/com/google/qa/config/config.properties");

			// load a properties file
			prop.load(input);


		} catch (IOException ex) {
			ex.printStackTrace();
		} 
    }
	
	public static void init() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
	}

}
