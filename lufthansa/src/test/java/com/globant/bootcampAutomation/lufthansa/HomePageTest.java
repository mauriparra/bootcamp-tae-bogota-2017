package com.globant.bootcampAutomation.lufthansa;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends StartTest {
	
	@Test
	@Parameters({ "bookingType", "originCity", "destinationCity", "outbondDate", "inbondText", "adultPassenger", "travelWithChildren", "childrenPassenger", "infantPassenger", "cabinType" })
	public void validateBookingForm(String bookingType, String originCity, String destinationCity, String outbondDate, String inbondText, String adultPassenger, String travelWithChildren, String childrenPassenger, String infantPassenger, String cabinType) throws Exception {
	//public void validateBookingForm() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillBookingForm(bookingType, originCity, destinationCity, outbondDate, inbondText, adultPassenger, travelWithChildren, childrenPassenger, infantPassenger, cabinType);
		//homePage.fillBookingForm("Round Trip", "BERLIN", "ber", "08-05-2017", "08-05-2018", "3 Adults", "Yes", "4 Children (2 to 11 years)", "4 Infants (up to 2 years)", "First");
		//System.out.println("TEST");
		ViewFlightPage viewFlightPage = homePage.goToViewFlightPage();
		assertTrue(viewFlightPage.confirmSelectFlightsPage());

	}

}
