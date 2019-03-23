package com.thegreatcourse.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.library.Base;

public class TestingScreenshots extends Base {

	@Test(enabled = false)
	public void testing_screen_capture1() {
		try {
			driver.get("http://www.google.com/");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void testing_screen_capture2() {
		try {
			driver.get("http://www.costco.com/");
			myLibrary.captureScreenshot("frank", "C:/Users/Musabay Technologies/Desktop/");
			myLibrary.captureScreenshot("frank2", "C:/Users/Musabay Technologies/Desktop");
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

}
