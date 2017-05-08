package org.qatar.automation;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.qatar.pages.HomePageQatar;
import org.qatar.pages.ReviewReservationPage;
import org.qatar.pages.Setup;
import org.testng.annotations.AfterMethod;

public class TestQatar {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = Setup.startBrowser("chrome", "http://www.qatarairways.com/us/en/homepage.page");
	}

	@Parameters({"airportStart", "airportDestination", "dateDeparting", "dateReturning", "numberAdults",
			"numberChilds", "numberInfants", "premiumClass", "promoCode"})
	@Test
	public void fillFlightOneWay(String airportStart, String airportDestination, String dateDeparting,String dateReturning, String numberAdults, String numberChilds, String numberInfants, String premiumClass,String promoCode) {
		HomePageQatar testPageHomeQatar = PageFactory.initElements(driver, HomePageQatar.class);
		testPageHomeQatar.FillAirportStartFlight(airportStart);
		testPageHomeQatar.FillAirportDestinationFlight(airportDestination);
		assertEquals(testPageHomeQatar.FillCalendarDeparting(dateDeparting), true,"Date failure Set in Datapicker Departing");
		assertEquals(testPageHomeQatar.FillCalendarReturning(dateReturning),true, "Date failure Set in Datapicker Returning");
		assertEquals(testPageHomeQatar.FillAdultSelection(numberAdults), true, "Selection Invalid from Adults");
		assertEquals(testPageHomeQatar.FillChildSelection(numberChilds), true, "Selection Invalid from Childs");
		assertEquals(testPageHomeQatar.FillInfantsSelection(numberInfants), true, "Selection Invalid from Infants");
		assertEquals(testPageHomeQatar.SelectButtonPremiumClass(premiumClass), true,"Selection error button premium class");
		testPageHomeQatar.FillPromoCode(promoCode);
		ReviewReservationPage testReviewReservationPage = testPageHomeQatar.ActionSearchFlight();
		
		assertEquals(testReviewReservationPage.ValidatePageReviewButtonBookSmile(), true, "Page not expected");
		assertEquals(testReviewReservationPage.ValidatePageReviewButtonModifySearch(), true, "Page not expected");
		assertEquals(testReviewReservationPage.ValidatePageReviewLineOption(), true, "Page not expected");

	}
	// public void fillFlightReturn(String oneWay,String airportStart,String
	// airportDestination,String dateDeparting, String dateReturning,String
	// numberAdults,String numberChilds,String numberInfants, String
	// premiumClass, String promoCode) throws InterruptedException {
	// HomePageQatar testPageHomeQatar=PageFactory.initElements(driver,
	// HomePageQatar.class);
	//
	// testPageHomeQatar.SelectOneWayFlight(oneWay);
	// testPageHomeQatar.FillAirportStartFlight(airportStart);
	// testPageHomeQatar.FillAirportDestinationFlight(airportDestination);
	// assertEquals(testPageHomeQatar.FillCalendarDeparting(dateDeparting),
	// true, "Date failure Set in Datapicker Departing");
	// assertEquals(testPageHomeQatar.FillCalendarReturning(dateReturning),
	// true, "Date failure Set in Datapicker Returning");
	// assertEquals(testPageHomeQatar.FillAdultSelection(numberAdults),
	// true,"Selection Invalid from Adults");
	// assertEquals(testPageHomeQatar.FillChildSelection(numberChilds),
	// true,"Selection Invalid from Childs");
	// assertEquals(testPageHomeQatar.FillInfantsSelection(numberInfants),
	// true,"Selection Invalid from Infants");
	// assertEquals(testPageHomeQatar.SelectButtonPremiumClass(premiumClass),
	// true,"Selection error button premium class");
	// testPageHomeQatar.FillPromoCode(promoCode);
	// ReviewReservationPage
	// testReviewReservationPage=testPageHomeQatar.ActionSearchFlight();
	// assertEquals(testReviewReservationPage.ValidatePageReviewReservation(),true,"Page
	// not expected");
	// Thread.sleep(5000);
	//
	// }

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
