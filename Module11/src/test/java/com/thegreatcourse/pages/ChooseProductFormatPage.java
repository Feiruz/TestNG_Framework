package com.thegreatcourse.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.Base;

public class ChooseProductFormatPage extends Base{

	public ChooseProductFormatPage waitUntilPageLoadComplete(){
		WebElement chooseFormatElem = myLibrary.fluentWait(By.id("media-format-radio"));
		Assert.assertNotNull(chooseFormatElem, "Waiting for Choose Product Format page loading - Failed");
		return this;
	}
	
	public ChooseProductFormatPage select_DVD(){
		WebElement dvd = getRadioButtonFormatOptions().get(1);		
		// using library method to click radio button
		myLibrary.handleCheckBoxRadioBtn(dvd, true);
		return this;
	}
	
	public ChooseProductFormatPage select_VideoDownload(){
		// directly clicking the radio button
		WebElement videoDownload = getRadioButtonFormatOptions().get(0);
		videoDownload.click();
		return this;
	}	
	
	
	public ChooseProductFormatPage click_AddToCartBtn(){
		myLibrary.clickButton(By.id("add-to-cart-btn"));
		return this;
	}
	
	
	
	///// Helper Methods ////////
	private List<WebElement> getRadioButtonFormatOptions(){
		List<WebElement> radioOptions = new ArrayList<>();
		WebElement radioGroup = driver.findElement(By.id("media-format-radio"));
		radioOptions = radioGroup.findElements(By.tagName("label"));		
		return radioOptions;
	}
}























