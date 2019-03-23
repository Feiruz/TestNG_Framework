package com.Week9.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.library.Base;

public class TestPractice extends Base {
	final static Logger logger = Logger.getLogger(TestPractice.class);
	
	@Test(enabled =  true)
	public void testing_Scroll_To_View(){
		driver.get("https://www.costco.com/");
		WebElement searchField = driver.findElement(By.id("footer-search-field"));
		// move to the Element only when element is on the HTML and visible
		myLibrary.scrollToWebElement(searchField);
		assertTrue(false);
		myLibrary.customWait(1);
	}
	
	@Test (enabled = false)
	public void testing_Scroll_Vertically(){
		try{
		driver.get("https://www.costco.com/");
		myLibrary.scrollByOffsetVertical("1000"); // move down 1000 px		
		myLibrary.customWait(3);
		myLibrary.scrollByOffsetVertical("-500"); // move up 500 px	 	
		assertTrue(false);
		}catch(Exception e){
			logger.error("Error: ", e);	
			assertTrue(false);
		}
	}
	
	@Test (enabled = false) // homework, you need to test it at home
	public void testing_Scroll_Horizontlly(){
		driver.get("https://www.costco.com/");

		myLibrary.scrollByOffsetHorizontal("300");	// move right 300 px	
		myLibrary.customWait(3);
		myLibrary.scrollByOffsetHorizontal("-300");	// move left 300 px	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
