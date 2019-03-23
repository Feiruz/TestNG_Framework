package com.thegreatcourse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.Base;

public class AddToCartPage extends Base {
	private String cssString = "#main-content > div > div.col-main.grid-full.in-col1 > div.block.cart-item-wrapper > div > div.actions > button.button.btn-checkout";
	
	public AddToCartPage waitUntilPageLoadComplete(){		
		WebElement checkOutBtnElem = myLibrary.fluentWait(By.cssSelector(cssString));
		Assert.assertNotNull(checkOutBtnElem, "Waiting for Add to Cart page loading - Failed");
		return this;
	}
	
	public AddToCartPage click_ProceedToCheckOutBtn(){		
		myLibrary.clickButton(By.cssSelector(cssString));
		
		return this;
	}
}
