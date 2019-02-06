package com.google.qa.base;

import java.io.File;
import org.apache.commons.codec.binary.Base64;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Properties;

import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;

public class TestBase {
	
   public static WebDriver driver;
	public static Properties prop = new Properties();
	private IDataSet loadedDataSet;
	 private IDatabaseTester dbtester;
	 private static LocalTime timestamp = LocalTime.now();

     @Rule public TestName name = new TestName();
	
	
	public TestBase() {
		InputStream input = null;
		try {
			

			input = new FileInputStream("./src/main/java/com/google/qa/config/config.properties");

			// load a properties file
			prop.load(input);


		} catch (IOException ex) {
			ex.printStackTrace();
		} 
    }
	
	protected IDatabaseConnection getConnection() throws Exception{
			Class driverClass = Class.forName("org.postgresql.Driver");
			Connection jdbcConnection = 
			      DriverManager.getConnection("jdbc:postgresql://localhost:5432/Teams", "postgres", "kingkong7");
			return new DatabaseConnection(jdbcConnection);      
		}
	// Load the data which will be inserted for the test
	protected IDataSet getDataSet() throws Exception{
			loadedDataSet = 
		                 new FlatXmlDataSetBuilder().build(new File("/Users/sufianamara/eclipse-workspace/maventest/src/main/resources/input.xml"));
			return loadedDataSet;
		}
	
	public void init() throws Exception {
		
		// initialize your database connection here
//		dbtester = new JdbcDatabaseTester("org.postgresql.Driver","jdbc:postgresql://localhost:5432/Teams","postgres","kingkong7");
//		dbtester.setSchema("pvt");
		
		IDatabaseConnection connection = this.getConnection();
		connection.getConfig().setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		
		
        // ...

        // initialize your dataset here
        IDataSet dataSet = this.getDataSet();
        // ...

        
        try { 
           DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet); 
    } catch (Exception e) { 
           e.printStackTrace(); 
    }
        
           connection.close();
//        
//        dbtester.setDataSet(dataSet);
        
//        try {
//			dbtester.onSetup();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
		
//		String hubUrl = "http://192.168.178.95:4444/wd/hub";
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		System.out.println("Starting chrome on grid");
//        
//		capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
//        
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		
		
//		driver = (new RemoteWebDriver(new URL(hubUrl), capabilities));
		
		driver.get(prop.getProperty("url"));
	}
	
	public void screenShot() {
		
		File localScreenshots = new File(new File("target"), "screenshots");

        File screenshot = new File(localScreenshots, this.name.getMethodName() + "_" + timestamp.getHour() + "." + timestamp.getMinute() + ".png");   

        try {

               FileUtils.moveFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), screenshot);

        } catch (WebDriverException e) {

              

               e.printStackTrace();

              

        } catch (IOException e) {

       

               e.printStackTrace();

        }
		
		
	}

}
