package com.thegreatcourse.tests;

import org.testng.annotations.Test;

import com.library.Base;
import com.thegreatcourse.pages.AddToCartPage;
import com.thegreatcourse.pages.CheckoutProgressPage;
import com.thegreatcourse.pages.ChooseProductFormatPage;
import com.thegreatcourse.pages.HomePage;
import com.thegreatcourse.pages.ScienceCoursesPage;

public class BuyACourseTests extends Base{

	HomePage myHomePage = new HomePage();
	ScienceCoursesPage sciencePage = new ScienceCoursesPage();
	ChooseProductFormatPage cpfPage = new ChooseProductFormatPage();
	AddToCartPage atcPage = new AddToCartPage();
	CheckoutProgressPage copPage = new CheckoutProgressPage();
	
	@Test
	public void buy_NightSky_course(){
		myHomePage.goto_theGreatCoursesWebsite();
		myHomePage.click_CategoryScience();
		sciencePage.waitUntilPageLoadComplete();
		sciencePage.selectACourse("Our Night Sky");		
		cpfPage.waitUntilPageLoadComplete();
		cpfPage.select_DVD();	
		cpfPage.click_AddToCartBtn();
		atcPage.waitUntilPageLoadComplete();
		atcPage.click_ProceedToCheckOutBtn();
		copPage.waitUntilPageLoadComplete();
		String tempEmail = "test"+myLibrary.getCurrentTime()+"@test.com";	
		System.out.println("Email: [" + tempEmail + "]");
		copPage.complete_CheckoutMethodSection(tempEmail);
		copPage.complete_BillingAddressSection();
		copPage.complete_Shipping_Method();
		copPage.complete_Credit_Info();
		
		
	}
}














