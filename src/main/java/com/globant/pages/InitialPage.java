/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.util.DatePicker;

/**
 *
 * @author admin
 */
public class InitialPage extends BasePage{
    
	@FindBy(how = How.ID, using = "cookieConsentAccept")
	WebElement acceptCookiesButton;
	
	@FindBy(css="ul[role='radiogroup']")
	WebElement radioFlyTypeGroup;
	
	@FindBy(how = How.ID, using="reservationFlightSearchForm.originAirport")
	WebElement departureInput;
	
	@FindBy(how = How.ID, using="ui-id-3")
	WebElement departureResult;
	
	@FindBy(how = How.ID, using="reservationFlightSearchForm.destinationAirport")
	WebElement arrivalInput;
	
	@FindBy(how = How.ID, using="ui-id-4")
	WebElement arrivalResult;
	
	@FindBy(how = How.ID, using="flightSearchForm.adultOrSeniorPassengerCount")
	WebElement passengersSelect;
	
	@FindBy(how = How.ID, using="aa-leavingOn")
	WebElement departureDatePicker;
	
	@FindBy(how = How.ID, using="aa-returningFrom")
	WebElement arrivalDatePicker;
	
	@FindBy(how = How.ID, using="flightSearchForm.button.reSubmit")
	WebElement submitBookingButton;
	
	
	public InitialPage(WebDriver driver){
		super(driver);
	}
	
	public ResultPage fillBooking(Boolean isOneWayFly, String iataDeparture, String iataArrival,
    		String passengersNumber, String departureDate, String arrivalDate){
		
		acceptCookiesButton.click();
		driver.findElement(By.id("aa-booking-module")).click();
		
		if(isOneWayFly){
			radioFlyTypeGroup.findElement(By.cssSelector("label[for='flightSearchForm.tripType.oneWay']")).click();
		}
		
		fillAutocompleteInput(departureInput, iataDeparture, departureResult);
		fillAutocompleteInput(arrivalInput, iataArrival, arrivalResult);
		setSelectorValue(passengersSelect, passengersNumber);
		
		List<DatePicker> datePickers = Arrays.asList(new DatePicker(departureDatePicker, departureDate), new DatePicker(arrivalDatePicker, arrivalDate));
		selectDatePickers(datePickers);
		submitBookingButton.click();
		//waitElement(By.className(CSS_LOADER_IMAGE));
		
		return PageFactory.initElements(driver, ResultPage.class);
	}
	
}
