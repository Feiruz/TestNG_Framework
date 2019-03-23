package com.thegreatcourse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.Base;

public class ScienceCoursesPage extends Base{

	public ScienceCoursesPage waitUntilPageLoadComplete(){
		WebElement categoryGridElem = myLibrary.fluentWait(By.className("category-products"));
		Assert.assertNotNull(categoryGridElem, "Waiting for category science page loading - Failed");
		return this;
	}
	
	public ScienceCoursesPage selectACourse(String courseName){
		WebElement course = driver.findElement(By.partialLinkText(courseName));
		course.click();
		return this;
	}
	
}
