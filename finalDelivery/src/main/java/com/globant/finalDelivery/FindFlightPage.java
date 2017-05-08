package com.globant.finalDelivery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.globant.fibakDelivery.HomePageTest;

public class FindFlightPage {
	
	@FindBy(id = "minibe__button--passenger")
	private WebElement newPassengers;
	
	@FindBy(id= "validate_typo_button")
	private WebElement confirmButton;
	
	@FindBy(id = "minibe__button--search")
	private WebElement newSearch;
	
	@FindBy(id = "idValidateFormButtonFlight")
	private WebElement continueSearch;
	
	public static final String[] AFE_OPTIONS = new String []{"Senior (65 years and older)","Adult (25 - 64 years)"};

	 void changePassenger(String[] passengers){
		newPassengers.click();
		WebElement passengersQuantityView = HomePageTest.driver.findElement(By.xpath("//label[@for='tnr__itp__"+passengers.length+"']"));
		passengersQuantityView.click();
		for (int i = 0; i < passengers.length; i++) {
			String passenger = passengers[i];
			int index = i + 1;
			Select select = new Select(HomePageTest.driver.findElement(By.id("pax__"+index)));
			select.selectByVisibleText(passenger);
		}
		newPassengers.click();
		newSearch.click();
	}

}
