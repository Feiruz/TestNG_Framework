package com.thegreatcourse.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.Base;

public class HomePage extends Base{

	public HomePage goto_theGreatCoursesWebsite(){
		driver.get("https://www.thegreatcourses.com/");
		String actualPageTitle = driver.getTitle();
		System.out.println("Website title is: " + actualPageTitle);
		assertEquals(actualPageTitle, "Online Courses & Lectures for Home Study and Lifelong Learning");		
		return this;
	}
	
	public HomePage click_CategoryScience(){
		WebElement categoriesElem = driver.findElement(By.cssSelector(".itemslider-wrapper.itemslider-categories"));
		List<WebElement> courses = categoriesElem.findElements(By.tagName("a"));
		myLibrary.clickButton(courses.get(1));			
		return this;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
