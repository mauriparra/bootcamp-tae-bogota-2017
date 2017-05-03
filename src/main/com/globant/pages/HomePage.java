package com.globant.pages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.globant.common.DatePicker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

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
  
    public QuotePage fillBookingEngine(String agencyCode, String cityName, String cityValue,
                                       String hotelValue, String strStartDate, String strEndDate, String adultNumber){
               
        agencyCodeInput.sendKeys(agencyCode);
        cityNameInput.sendKeys(cityName);
        
        setJavaScriptElementValue("#CIUDAD_ORIGEN", cityValue);
        setSelectorValue(hotelNameInput, hotelValue);

        List<DatePicker> datePickers = Arrays.asList(new DatePicker(startDate, strStartDate), new DatePicker(endDate, strEndDate));
        selectBookingDatePickers(datePickers);
        
        setSelectorValue(adultsRoomSelect, adultNumber);
        submitButton.click();
        waitElement("SpanLabelDivLoad");
        
        return PageFactory.initElements(getDriver(), QuotePage.class);
    }
}
