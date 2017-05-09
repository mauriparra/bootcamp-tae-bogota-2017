package com.globant.bootcampAutomation.lufthansa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewFlightPage {
	
	protected WebDriver driver;
	
	@FindBy(className = "panel-flights")
	private WebElement panelFlights;

    public ViewFlightPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public boolean confirmSelectFlightsPage() {
		
		if(panelFlights.isDisplayed())
			return true;
		else
			return false;
	}
}
