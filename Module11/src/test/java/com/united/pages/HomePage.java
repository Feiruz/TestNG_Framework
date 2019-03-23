package com.united.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.Base;

public class HomePage extends Base {

	public HomePage goto_United_Website() {
		driver.get("http://www.united.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Website title is: " + pageTitle);
		String expectedTitle = "United Airlines – Airline Tickets, Travel Deals and Flights";
		assertEquals(pageTitle, expectedTitle);
		return this;
	}

	public HomePage selectOneWay() {
		myLibrary.handleCheckBoxRadioBtn(By.id("oneway"), true);
		return this;
	}

	public HomePage selectRoundTrip() {
		myLibrary.handleCheckBoxRadioBtn(By.id("roundtrip"), true);
		return this;
	}

	public HomePage enterFromAirport(String inputOriginAirportName, String dropDownAirportText) {
		try {
			myLibrary.enterTextField(By.id("bookFlightOriginInput"), inputOriginAirportName);
			Thread.sleep(1 * 1000);
			List<WebElement> dropDownElems = driver.findElements(By.className("app-components-AutocompleteLocationDropdown-autocompleteLocationDropdown__autocompleteLocationContainer--3YtAp"));
			WebElement fromList = dropDownElems.get(0); // fromAirportOptionsList
			List<WebElement> airPortOptions = fromList.findElements(By.className("app-components-AutocompleteLocationDropdownItem-autocompleteLocationDropdownItem__locationList--oeLvp"));
			for(WebElement airport : airPortOptions){
				WebElement targetAirport = airport.findElement(By.tagName("span"));
				if(dropDownAirportText.contains(targetAirport.getText())){
					targetAirport.click();
					break;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
