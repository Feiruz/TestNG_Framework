package com.thegreatcourse.pages;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.Base;

public class CheckoutProgressPage extends Base {

	public CheckoutProgressPage waitUntilPageLoadComplete(){
		WebElement continueBtnElem = myLibrary.fluentWait(By.id("checkout-sigin"));
		Assert.assertNotNull(continueBtnElem, "Waiting for Checkout Progress page loading - Failed");
		return this;
	}
	
	public CheckoutProgressPage complete_CheckoutMethodSection(String emailAddress){
		myLibrary.enterTextField(By.id("login-email"), emailAddress);
		//myLibrary.handleCheckBoxRadioBtn(By.id("no_have_pass"), true);
		myLibrary.clickHiddenElement(By.id("no_have_pass"));
		myLibrary.clickButton(By.id("checkout-sigin"));		
		return this;
	}
	
	public CheckoutProgressPage complete_BillingAddressSection()
	{
		WebElement emailElem = myLibrary.waitForElementVisibility(By.id("billing:firstname"));
		myLibrary.enterTextField(emailElem, "Frank");
		
		myLibrary.enterTextField(By.id("billing:lastname"), "FrankLast");
		myLibrary.enterTextField(By.id("billing:street1"), "10 apple street");
		myLibrary.enterTextField(By.id("billing:city"), "Moon");
		myLibrary.selectDropDown(By.id("billing:region_id"), "Virginia");
		myLibrary.enterTextField(By.id("billing:postcode"), "12345");
		myLibrary.enterTextField(By.id("billing:customer_password"), "123456");
		myLibrary.enterTextField(By.id("billing:confirm_password"), "123456");
		
		WebElement btn = driver.findElement(By.id("billing-buttons-container"));
		WebElement continueBtn = btn.findElement(By.tagName("button"));
		continueBtn.click();
		
		return this;
	}
	
	public CheckoutProgressPage complete_Shipping_Method(){
		WebElement shippingSection =  myLibrary.waitForElementVisibility(By.id("checkout-shipping-method-load"));
		assertNotNull(shippingSection);
		
		myLibrary.clickButton(By.cssSelector("#shipping-method-buttons-container > button > span > span"));
		return this;
	}
	
	public CheckoutProgressPage complete_Credit_Info(){
		WebElement iframe = myLibrary.waitForElementVisibility(By.id("vantiv-payframe"));
		// swtich into iframe
		driver.switchTo().frame(iframe);
		myLibrary.enterTextField(By.id("accountNumber"), "1234567897897974564");
		myLibrary.selectDropDown(By.id("expMonth"), "April");		
		myLibrary.selectDropDown(By.id("expYear"), "2020");
		
		// exit from iframe
		driver.switchTo().defaultContent();
		//myLibrary.handleCheckBoxRadioBtn(By.cssSelector("#payment_form_vantiv_cc_frame > li:nth-child(2) > label"), false);
		myLibrary.handleCheckBoxRadioBtn(By.id("payment-vantiv-cc-save-in-vault"), false);
		
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
