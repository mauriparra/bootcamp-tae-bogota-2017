package com.globant.bootcampAutomation2.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.bootcampAutomation2.pages.HomePage;
import com.globant.bootcampAutomation2.pages.Page2;


public class TestsEtihad {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\Santi\\Instaladores\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://flights.etihad.com/en/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closePage(){
		driver.close();
		driver.quit();
	}
	
	@Parameters({"oneWay", "originCode", "destinationCode", "departureDate", "returnDate", "cabin", "adults", "children", "infants"})
	@Test(priority = 0, description = "Test search of a flight")
	public void EtihadTest(String oneWayP, String originP, String destinationP, String departureDateP, String returnDateP, String cabinP, String adultsP, String childrenP, String infantsP){
		HomePage etihadHome = PageFactory.initElements(driver, HomePage.class);
		etihadHome.SelectOneRound(oneWayP);
		etihadHome.SelectOriginAirport(originP);
		etihadHome.SelectDestinationAirport(destinationP);
		etihadHome.SelectDepartureDate(departureDateP);
		etihadHome.SelectReturnDate(returnDateP);
		etihadHome.CabinAndGuestSelect(cabinP, adultsP, childrenP, infantsP);
		Page2 etihadPage2 = etihadHome.SubmitHomePage();
		etihadPage2.firstValidatorPage2();
		String flightRulesPage2 = etihadPage2.firstValidatorPage2();
		Assert.assertEquals(flightRulesPage2, "View Fare Rules");
		boolean guestPage2 = etihadPage2.secondValidatorPage2();
		Assert.assertTrue(guestPage2);
		boolean modifyPage2 = etihadPage2.thirdValidationPage2();
		Assert.assertTrue(modifyPage2);
	}
	
	@Parameters({"oneWay", "originCode", "destinationCode","departurePastDate"})
	@Test(priority=1, description="Test a past date")
	public void DateTest(String oneWayP, String originP, String destinationP, String departurePastP){
		String classUnselectable = " ui-datepicker-unselectable ui-state-disabled ";
		HomePage etihadPastDate = PageFactory.initElements(driver, HomePage.class);
		etihadPastDate.SelectOneRound(oneWayP);
		etihadPastDate.SelectOriginAirport(originP);		
		etihadPastDate.SelectDestinationAirport(destinationP); 
		String enabledPastDate = etihadPastDate.SelectDeparturePastDate(departurePastP);
		Assert.assertEquals(enabledPastDate, classUnselectable);
	}
	
}
