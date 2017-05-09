package com.globant.bootcampAutomation2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page2 extends BasePage{

	public Page2(WebDriver driver){
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@FindBy(id = "fare-rules-anchor")
	private WebElement selectFlightPage2;
	
	@FindBy(id = "tooltip_wrapper_bconnect")
	private WebElement guestNumberPage2;
	
	@FindBy(id = "modify-search-trigger")
	private WebElement modifySearchPage2;
	
	public String firstValidatorPage2(){
		wait.until(ExpectedConditions.elementToBeClickable(selectFlightPage2));
		String textValidator1 = selectFlightPage2.getText();
		return textValidator1;
	}
	
	public boolean secondValidatorPage2(){
		wait.until(ExpectedConditions.visibilityOf(guestNumberPage2));
		boolean guestEnabled = guestNumberPage2.isDisplayed();
		return guestEnabled;
	}
	
	public boolean thirdValidationPage2(){
		wait.until(ExpectedConditions.elementToBeClickable(modifySearchPage2));
		boolean modifyAvailable = modifySearchPage2.isEnabled();
		return modifyAvailable;
	}
}
