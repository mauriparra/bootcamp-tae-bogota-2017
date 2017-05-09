package com.globant.bootcampFinalTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BookingHomepage extends Page {

    @FindBy(id = "trip-type-round-trip")
    private WebElement roundTripRadio;

    @FindBy(id = "air-city-departure")
    private WebElement departBox;

    @FindBy(id = "air-city-arrival")
    private WebElement arrivalBox;

    @FindBy(css = "a.booking-form--field-icon-container.booking-form--gradient-treatment.js-depart-date-icon")
    private WebElement dateDepart;

    @FindBy(css = "div.calendar-selector-body")
    private WebElement datePicker;

    @FindBy(css = "a.booking-form--field-icon-container.booking-form--gradient-treatment.js-return-date-icon")
    private WebElement dateArrival;

    @FindBy(id = "air-pax-count-seniors")
    private WebElement seniorCount;

    @FindBy(id = "air-pax-count-adults")
    private WebElement adultCount;

    @FindBy(id = "air-city-departure-menu-item1")
    private WebElement departAutocomplete;

    @FindBy(id = "air-city-arrival-menu-item1")
    private WebElement arrivalAutocomplete;

    @FindBy(id = "en")
    private WebElement englishLanguage;

    @FindBy(id = "jb-booking-form-submit-button")
    private WebElement searchButton;

    @FindBy(id = "trip-type-one-way")
    private WebElement radioOneWay;

    @FindBy(id = "jb-number-selector-more")
    private WebElement moreButton;

    @FindBy(id = "jb-number-selector-less")
    private WebElement lessButton;

    @FindBy(css = "a.next.js-next")
    private WebElement nextMonth;

    public BookingHomepage(WebDriver driver) {
        super(driver);
    }

    private void fieldOrigin(WebElement field, String origin){
        field.sendKeys(origin);
    }

    private void datePickerUse(WebElement picker, String date){
        Integer flag = 0;
        while(flag == 0) {
            List<WebElement> columns = picker.findElements(By.tagName("td"));
            for (WebElement cell : columns) {
                if (cell.getAttribute("data-date") != null) {
                    if (cell.getAttribute("data-date").equals(date)) {
                        cell.click();
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0){
                if(nextMonth.getAttribute("class").contains("swa-g-disabled")){
                    System.out.println("Fecha " + date + " supera limite de calendario en página. ");
                    flag = 2;
                }
                else {
                    nextMonth.click();
                }
            }
        }
    }

    private void addPassengers(String passengerType, Integer qty){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.moreButton));
        for (Integer i = passengerType.equals("adults") ? 1 : 0; i < qty; i++) {
            this.moreButton.click();
        }
    }

    public void validateDatePicker(String depart, String arrival, String departDate, String type){
        driver.switchTo().frame("lightbox_pop");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.englishLanguage));
        this.englishLanguage.click();
        driver.switchTo().parentFrame();
        if(type.equals("one-way")){
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.radioOneWay));
            this.radioOneWay.click();
        }
        fieldOrigin(this.departBox, depart);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.departAutocomplete));
        this.departAutocomplete.click();
        fieldOrigin(this.arrivalBox, arrival);
        this.arrivalAutocomplete.click();
        this.dateDepart.click();
    }

    public SelectFlightsPage searchFlight(String depart, String arrival, String departDate, String arrivalDate, String type, Integer adults, Integer seniors) {
        driver.switchTo().frame("lightbox_pop");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.englishLanguage));
        this.englishLanguage.click();
        driver.switchTo().parentFrame();
        if(type.equals("one-way")){
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.radioOneWay));
            this.radioOneWay.click();
        }
        fieldOrigin(this.departBox, depart);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.departAutocomplete));
        this.departAutocomplete.click();
        fieldOrigin(this.arrivalBox, arrival);
        this.arrivalAutocomplete.click();
        this.dateDepart.click();
        datePickerUse(this.datePicker, departDate);
        if(!type.equals("one-way")){
            this.dateArrival.click();
            datePickerUse(this.datePicker, arrivalDate);
        }
        this.adultCount.click();
        if(adults > 1) {
            this.addPassengers("adults", adults);
        }else this.lessButton.click();
        if(seniors > 0) {
            this.seniorCount.click();
            addPassengers("senior", seniors);
        }
        this.searchButton.click();
        return PageFactory.initElements(this.driver, SelectFlightsPage.class);
    }

}
