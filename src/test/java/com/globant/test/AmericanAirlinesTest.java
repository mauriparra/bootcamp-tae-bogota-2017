package com.globant.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.globant.pages.InitialPage;
import com.globant.pages.ResultPage;

/**
 *
 * @author admin
 */
public class AmericanAirlinesTest {
    
    WebDriver driver;
    private static final String URL = "https://www.aa.com/";
    
    public AmericanAirlinesTest() {
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(description = "Fills the booking engine")
    @Parameters({"oneway-fly", "iata-departure", "iata-arrival", "passengers-number", "departure-date", "arrival-date"})
    public void fillBooking(Boolean isOneWayFly, String iataDeparture, String iataArrival,
    		String passengersNumber, String departureDate, String arrivalDate){
    	
    	InitialPage initialPage = PageFactory.initElements(driver, InitialPage.class);
    	ResultPage resultPage = initialPage.fillBooking(isOneWayFly, iataDeparture, iataArrival, passengersNumber, departureDate, arrivalDate);
    	resultPage.validateResult();
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        /*driver.close();
        driver.quit();*/
    }
}
