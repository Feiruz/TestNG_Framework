package com.Week10.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.library.Base;

public class WindowHandleTests extends Base {
	final static Logger logger = Logger.getLogger(WindowHandleTests.class);

	@Test(enabled = false)
	public void testing_two_browsers() {
		driver.get("http://demo.guru99.com/popup.php/");
		String browser1 = driver.getWindowHandle();
		logger.info("browsers: " + browser1);
		myLibrary.highlightElement(By.tagName("body"));

		WebElement clickHereLink = driver.findElement(By.partialLinkText("Click Here"));
		clickHereLink.click();

		Set<String> browsers2 = driver.getWindowHandles();
		logger.info("browsers: " + browsers2);

		Iterator<String> iterator = browsers2.iterator();
		while (iterator.hasNext()) {
			String window = iterator.next();
			if (!browser1.equals(window)) {
				driver.switchTo().window(window);
				myLibrary.highlightElement(By.tagName("body"));
			}
		}
	}

	@Test(enabled = true)
	public void testing_multiple_browsers() {
		// opens browser1
		driver.get("http://demo.guru99.com/popup.php/");		

		// opens browser2
		WebElement clickHereLink = driver.findElement(By.partialLinkText("Click Here"));
		clickHereLink.click();

		// opens browser3
		WebElement clickHereLink2 = driver.findElement(By.partialLinkText("Click Here"));
		clickHereLink2.click();
			
		myLibrary.switchToWindow(1);
		myLibrary.highlightElement(By.tagName("body"));
	}

	
	
	
	
	
	
	
	
	
}
