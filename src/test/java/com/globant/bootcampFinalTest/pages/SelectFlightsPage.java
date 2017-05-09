package com.globant.bootcampFinalTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectFlightsPage extends Page {

    @FindBy(id = "priceItinerarySubmit")
    private WebElement nextStepButton;

    @FindBy(css = ".list_errors li")
    private WebElement errorMsg;

    public SelectFlightsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement validateFlightPage(){
        return this.nextStepButton;
    }

    public String validateDepartDate(){
        String result = new WebDriverWait(this.driver, 5).until(new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                return d.findElement(By.id("carouselTodayDepart")).getAttribute("carouselfulldate");
            }
        });
        return result;
    }

    public Boolean validatePassengers(){
        return this.errorMsg.isDisplayed();
    }
}
