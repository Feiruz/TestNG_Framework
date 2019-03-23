package com.united.tests;

import org.testng.annotations.Test;

import com.library.Base;
import com.united.pages.HomePage;

public class SearchingTicketTests extends Base {

	HomePage myHomePage = new HomePage();
	
	@Test
	public void searchVacationTicket(){
		myHomePage.goto_United_Website();
		myHomePage.selectOneWay();
		myHomePage.selectRoundTrip();
		myHomePage.enterFromAirport("Washington", "Washington, DC, US (DCA - National)");	
		
	}
}
