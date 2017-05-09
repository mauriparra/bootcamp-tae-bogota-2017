package com.globant.bootcampAutomation.finalProjectPages;

import com.globant.bootcampAutomation.pages.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by MauricioLeonardo on 5/5/2017.
 */
public class latamSelectYourFlightPage extends basePage {

    public latamSelectYourFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[@class='wa-focus-tab']")
    WebElement selectYourFlightTitle;

    @FindBy (xpath = ".//*[@id='itineraryContainer']/h2")
    WebElement itineraryTitle;

    @FindBy (xpath = ".//*[@id='faresMatrixContainer']/h2")
    WebElement availableFaresTitle;

    WebDriverWait driverWait = new WebDriverWait(driver,20);

    public Boolean validateSelectYourFlightTitle (){

        driverWait.until(ExpectedConditions.visibilityOf(selectYourFlightTitle));
        boolean validBooking = false;
        if (selectYourFlightTitle.isDisplayed()) {
            validBooking = true;
        }
        return validBooking;
    }

    public Boolean  validateItineraryTitle (){

        Boolean validBooking = false;
        if (itineraryTitle.isDisplayed()){
            validBooking = true;
        }
        return validBooking;
    }

    public Boolean validateAvailableFaresTitle (){

        Boolean validBooking = false;
        if (availableFaresTitle.isDisplayed()){
            validBooking = true;
        }

        return validBooking;
    }

}
