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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.util.DatePicker;

/**
 *
 * @author admin
 */
public class InitialPage extends BasePage{
    
	private List<DatePicker> datePickerList;
	private static String CSS_SINGLE_TRIP = "label[for='flightSearchForm.tripType.oneWay']";
	private Boolean isOneWayFly;

	@FindBy(css="div[aria-describedby='cookieConsentDialog'")
	WebElement cookieContenDialog;
	
	@FindBy(how = How.ID, using = "cookieConsentPolicyLink")
	WebElement linkCookiesPolicy;
	
	@FindBy(how = How.ID, using = "cookieConsentPolicy")
	WebElement contentCookiesPolicy;
	
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
	
	public Boolean getIsOneWayFly() {
		return isOneWayFly;
	}

	public ResultPage fillBooking(String iataDeparture, String iataArrival,String passengersNumber){
		
		linkCookiesPolicy.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(contentCookiesPolicy));
		acceptCookiesButton.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOf(cookieContenDialog));
		
		if(isOneWayFly){
			radioFlyTypeGroup.findElement(By.cssSelector(CSS_SINGLE_TRIP)).click();
		}
		
		fillAutocompleteInput(departureInput, iataDeparture, departureResult);
		fillAutocompleteInput(arrivalInput, iataArrival, arrivalResult);
		setSelectorValue(passengersSelect, passengersNumber);
		selectDatePickers(datePickerList);
		submitBookingButton.click();
		waitElement(By.className(CSS_LOADER_IMAGE));
		
		return PageFactory.initElements(driver, ResultPage.class);
	}
	
	/**
	 * Sets the datepicker list values
	 * @param departureDate
	 * @param arrivalDate
	 */
	public void setInitialParams(Boolean isOneWayFly, String departureDate, String arrivalDate){
		
		this.isOneWayFly = isOneWayFly;
		datePickerList = Arrays.asList(new DatePicker(departureDatePicker, departureDate));

		if(!isOneWayFly){
			datePickerList.add(new DatePicker(arrivalDatePicker, arrivalDate));
		}
	}

	/**
	 * Returns the datepicker list
	 * @return
	 */
	public List<DatePicker> getDatePickerList() {
		return datePickerList;
	}
	
}
