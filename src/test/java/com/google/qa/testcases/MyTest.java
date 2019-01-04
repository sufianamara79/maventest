package com.google.qa.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.google.qa.base.TestBase;
import com.google.qa.db.LuxDetails;
import com.google.qa.pages.HomePage;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class MyTest extends TestBase{
	 public static final String SAMPLE_XLSX_FILE_PATH = "/Users/sufianamara/Downloads/Financial Sample.xlsx" ;
	 
	public MyTest() {
		super();
		
		
	}
	
	@Before
	public void SetUp() {
		init();
		
		
	}											 			
	
//	@Test
//	public void test() {
//		HomePage page = new HomePage();
//		page.Search("real madrid");
//		
//		LuxDetails details = new LuxDetails();
//		details.setTeamID(7);
//		details.setName("real");
//		details.setRank(1);
//		
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//	 
//		Session session = sessionFactory.openSession();
//		
//		session.beginTransaction();
//		
//		session.save(details);
//		
//		session.getTransaction().commit();
//		
//		session.close();
//		
//		session = sessionFactory.openSession();
//		
//		session.beginTransaction();
//		
//		details = null;
//		
//		details = session.get(LuxDetails.class, 3);
//		
//		List<LuxDetails> all = new ArrayList<LuxDetails>();
//		
//		Criteria criteria  = session.createCriteria(LuxDetails.class);
//		
//		all = criteria.list();
//		
//	    assertEquals("title wrong", "real", details.getName());
//	   
//	    
//	    session.evict(details);
//	    details.setName("Mary");
//	     
//	    session.merge(details);
//	    
//		session.getTransaction().commit();
//		
//		session.close();
//		
//		session = sessionFactory.openSession();
//		
//		session.beginTransaction();
//		
//		details = null;
//		
//		details = session.get(LuxDetails.class, 3);
//		
//		assertEquals("title wrong", "Mary", details.getName());
//	}
	
	@Test
	public void ReadExcelTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		HomePage page = new HomePage();
		//page.Search("real madrid");
		
		page.Download();
		
		 Thread.sleep(2000);
		
		String searchQ = null;
		
		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
		
		// Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        
        
        for (Row row: sheet) {
            for(Cell cell: row) {
            	 if (cell.getColumnIndex() == 1) {
            		 String cellValue = dataFormatter.formatCellValue(cell);
            		 searchQ = cellValue;
            		 break;
            	 }
            }
            System.out.println();
        }
        
       // page.Search(searchQ);
        
        assertEquals("title wrong", "Mary", page.getTtile());
		

	}


}
