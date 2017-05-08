package com.globant.test;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.globant.pages.InitialPage;
import com.globant.pages.ResultPage;
import com.globant.util.DatePicker;

/**
 *
 * @author admin
 */
public class AmericanAirlinesTest {
    
    WebDriver driver;
    private static String URL = "https://www.aa.com/";
    static int MAX_PASSENGERS = 6;
    static int MIN_PASSENGERS = 0;
    private static String MSG_ERR_PASSENGERS = "The indicated passsenger's number '$1' is not permited";
    private static String MSG_ERR_DATES = "The indicated date '$1' isn't permit for this test";
    private static String MSG_ERR_ARRIVAL_DATE = "The arrival date '$1' most be greater than '$2'";
    
    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(description = "Fills the booking engine")
    @Parameters({"oneway-fly", "iata-departure", "iata-arrival", "passengers-number", "departure-date", "arrival-date"})
    public void fillBooking(Boolean isOneWayFly, String iataDeparture, String iataArrival,
    		String passengersNumber, String departureDate, String arrivalDate){
    	
    	InitialPage initialPage = PageFactory.initElements(driver, InitialPage.class);
    	// Validates passenger number
    	validatePassengers(passengersNumber);
    	initialPage.setInitialParams(isOneWayFly, departureDate, arrivalDate);
    	validateDates(isOneWayFly, initialPage.getDatePickerList());
    	ResultPage resultPage = initialPage.fillBooking(iataDeparture, iataArrival, passengersNumber);
    	resultPage.validateResult();
    }
    
    /**
     * Valida que las fechas cumplan con las condiciones para la realizacion del test
     * @param datePickers
     */
    private void validateDates(Boolean isOneWayFly, List<DatePicker> datePickers){
    	
    	for(DatePicker date: datePickers){
    		Assert.assertEquals(date.getDate().before(new Date()), false, MSG_ERR_DATES.replace("$1", date.getValue()));
    	}
    	
    	if(!isOneWayFly){    		
    		DatePicker departureDate = datePickers.get(0);
    		DatePicker arrivalDate = datePickers.get(1);
    		Assert.assertFalse(arrivalDate.getDate().before(departureDate.getDate()), MSG_ERR_ARRIVAL_DATE.replace("$1", arrivalDate.getValue()).replace("$2", departureDate.getValue()));
    	}
    }
    
    /**
     * Validates the number or passengers
     * @param passengersNumber
     */
    private void validatePassengers(String passengersNumber){
    	
    	int passengers = Integer.parseInt(passengersNumber);
		Assert.assertTrue(passengers < MAX_PASSENGERS, MSG_ERR_PASSENGERS.replace("$1", passengersNumber));
		Assert.assertFalse(passengers <= MIN_PASSENGERS, MSG_ERR_PASSENGERS.replace("$1", passengersNumber));
    }
    
    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
