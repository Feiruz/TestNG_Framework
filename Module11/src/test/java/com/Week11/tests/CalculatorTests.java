package com.Week11.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.library.Base;
import com.library.ExcelManager;

public class CalculatorTests extends Base {

	private int counter = 0;
	
	@DataProvider(name = "MortgageTestData")
	private Object[][] calculatorData() {
		ExcelManager excelReader = new ExcelManager("src/test/resources/data/CalculaterTestData1.xls");
		Object[][] data;
		data = excelReader.getExcelData("Calculater");
		return data;
	}
	
	@BeforeMethod
	public void beforeTest(){
		driver.get("https://www.mortgagecalculator.net/");
		String browserTitle = driver.getTitle();
		System.out.println("website title is: '" + browserTitle + "'");
		//assertEquals(browserTitle, "Mortgage Calculator 2018 - FREE & Easy Calculator Tool");
	}

	@Test(dataProvider = "MortgageTestData")
	public void dataDrivenTests(String amount, String Myear, String Mmonth, String intYear, String intMonth,
			String intType, String intRate, String startMonth, String startYear, String paymentPeriod, String expectedResult) {
		try {		
			counter ++;
			
			myLibrary.enterTextField(By.id("amount"), amount);

			myLibrary.enterTextField(By.xpath("//*[@id='amortizationYears']"), Myear);

			myLibrary.enterTextField(By.cssSelector("#amortizationMonths"), Mmonth);

			myLibrary.enterTextField(By.id("interestTermYears"), intYear);

			myLibrary.enterTextField(By.cssSelector("#interestTermMonths"), intMonth);

			myLibrary.selectDropDown(By.id("interestType"), intType);

			myLibrary.enterTextField(By.xpath("//*[@id='rate']"), intRate);

			myLibrary.selectDropDown(By.id("startMonth"), Integer.valueOf(startMonth));

			myLibrary.selectDropDown(startYear, By.id("startYear"));

			myLibrary.selectDropDown(By.cssSelector("#paymentMode"), paymentPeriod);

			myLibrary.clickButton(By.cssSelector("#button"));

			Thread.sleep(5 * 1000);

			WebElement monthlyPaymentResult = driver.findElement(By.id("summaryMonthly"));
			// String monthlyPaymentTxt = monthlyPaymentResult.getText();
			String monthlyPaymentTxt = monthlyPaymentResult.getAttribute("value");

			System.out.println("Test Scenario: " + counter + ",  Monthly payment amount is: " + monthlyPaymentTxt + ", Expected: ["+expectedResult+"]");
			assertEquals(monthlyPaymentTxt, expectedResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
