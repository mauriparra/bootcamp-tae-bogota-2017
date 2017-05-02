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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author admin
 */
public class HomePage {
    
    private WebSite website;
    
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
    
    @FindBy(css="div[id=ui-datepicker-div]")
    private WebElement calendarDiv;
    
    @FindBy(how = How.CLASS_NAME, using = "botonNaranjaFlecha")
    private WebElement submitButton;

    public HomePage(WebDriver driver){
        website = new WebSite(driver);
    }
  
    public QuotePage fillBookingEngine(){
               
        agencyCodeInput.sendKeys(AGENCY_CODE);
        cityNameInput.sendKeys(CITY_NAME);
        String scriptText = "document.querySelector('#CIUDAD_ORIGEN').setAttribute('value','" + CITY_VALUE + "')";
        ((JavascriptExecutor)website.getDriver()).executeScript(scriptText);
        
        (new Select(hotelNameInput)).selectByValue(HOTEL_VALUE);

        List<DatePicker> datePickers = Arrays.asList(new DatePicker(startDate, START_DATE), new DatePicker(endDate, END_DATE));
        
        for(DatePicker datePk: datePickers){
            datePk.getElement().click();
            new WebDriverWait(website.getDriver(), TIMEOUT).until(ExpectedConditions.visibilityOf(calendarDiv));
            List<WebElement> calendarColums = calendarDiv.findElements(By.tagName("td"));
            for (WebElement cell: calendarColums){
                if (cell.getText().equals(datePk.getValue())){
                    cell.findElement(By.tagName("a")).click();
                    break;
                }
            }
        }
        
        (new Select(adultsRoomSelect)).selectByValue(ADULT_NUMBER);
        submitButton.click();
        return PageFactory.initElements(website.getDriver(), QuotePage.class);
    }
}
