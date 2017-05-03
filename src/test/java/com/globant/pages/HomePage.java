/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import com.globant.common.DatePicker;
import static com.globant.webtest.Constants.*;
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

/**
 *
 * @author admin
 */
public class HomePage extends WebSite{
    
    @FindBy(how = How.ID, using = "sigAge")
    private WebElement agencyCodeInput;
    
    @FindBy(css="#divCiud>input")
    private WebElement cityNameInput;
    
    @FindBy(how = How.ID, using = "hotel")
    private WebElement hotelNameInput;
    
    @FindBy(how = How.ID, using = "hab1adultos")
    private WebElement adultsRoomSelect;
    
    @FindBy(how = How.NAME, using = "FECHA_LLEGADA")
    private WebElement startDate;
    
    @FindBy(how = How.NAME, using = "FECHA_SALIDA")
    private WebElement endDate;
    
    @FindBy(how = How.CLASS_NAME, using = "botonNaranjaFlecha")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
  
    public QuotePage fillBookingEngine(){
        
        setInputValue(agencyCodeInput, AGENCY_CODE);
        setInputValue(cityNameInput, CITY_NAME);
        
        setJavaScriptElementValue(CITY_SELECTOR, CITY_VALUE);
        setSelectorValue(hotelNameInput, HOTEL_VALUE);
        
        List<DatePicker> datePickers = Arrays.asList(new DatePicker(startDate, START_DATE), new DatePicker(endDate, END_DATE));
        selectBookingDatePickers(datePickers);
        
        setSelectorValue(adultsRoomSelect, ADULT_NUMBER);
        submitButton.click();
        waitElement("SpanLabelDivLoad");
        
        return PageFactory.initElements(getDriver(), QuotePage.class);
    }
}
