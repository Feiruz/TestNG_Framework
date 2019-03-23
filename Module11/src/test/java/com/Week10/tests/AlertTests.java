package com.Week10.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.library.Base;

public class AlertTests extends Base{
	final static Logger logger = Logger.getLogger(AlertTests.class);
	
	@Test
	public void testing_popup_alert(){
		createAlert();
		myLibrary.customWait(2);	
		logger.info("Accepting alert.");
		isAlertPresent().accept();
		
		
		//isAlertPresent().dismiss();
		myLibrary.customWait(2);
		
		
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		//alert.dismiss();
	}
	
	private void createAlert(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('Hello! How are you?');");		
	}

	public Alert isAlertPresent(){		
		Alert alert = null;
		try{
			alert = driver.switchTo().alert();
			logger.info("Alert detected: {" + alert.getText() + "}");		
		}catch(Exception e){			
			logger.info("Alert Not detected!");
		}		
		return alert;
	}
		
}
