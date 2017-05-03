/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import com.globant.common.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *
 * @author fabian.acero
 */
public class WebSite {
    private WebDriver driver;
    private int timeOut;

    @FindBy(css="div[id=ui-datepicker-div]")
    private WebElement calendarDiv;

    public WebSite(WebDriver driver){
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        this.timeOut = 10;
        return driver;
    }

    public int getTimeOut() {
        return this.timeOut;
    }
    /**
     * Gets the current page's title
     * @return 
     */
    public String getCurrentTitle(){
        return driver.getTitle();
    }
    
    /**
     * Gets the current page's url
     * @return 
     */
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    } 
    /**
     * Sets a value to an input element
     * @param inputElement
     * @param value 
     */
    public void setInputValue(WebElement inputElement, String value){
        inputElement.sendKeys(value);
    }
    /**
     * Selects an indicated select element value
     * @param selectElement
     * @param value 
     */
    public void setSelectorValue(WebElement selectElement, String value){
        (new Select(selectElement)).selectByValue(value);
    }
    /**
     * Triggers js code for set a value for an element
     * @param cssSelector
     * @param value 
     */
    public void setJavaScriptElementValue(String cssSelector, String value){
        String scriptText = "document.querySelector('" + cssSelector + "').setAttribute('value','" + value + "')";
        ((JavascriptExecutor)getDriver()).executeScript(scriptText);
    }
    /**
     * Waits until an indicated element exists
     * @param elementId 
     */
    public void waitElement(String elementId){
        WebElement elementToWaitFor = new WebDriverWait(getDriver(), getTimeOut()).until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
        new WebDriverWait(getDriver(), getTimeOut()).until(ExpectedConditions.invisibilityOf(elementToWaitFor));
    }
    /**
     * Waits until an indicated element exists
     * @param element
     */
    public void waitElement(By element){
        WebElement elementToWaitFor = new WebDriverWait(getDriver(), getTimeOut()).until(ExpectedConditions.presenceOfElementLocated(element));
        new WebDriverWait(getDriver(), getTimeOut()).until(ExpectedConditions.invisibilityOf(elementToWaitFor));
    }

    public void selectBookingDatePickers(List<DatePicker> datePickers){
        
        for(DatePicker datePk: datePickers){
            datePk.getElement().click();
            new WebDriverWait(getDriver(), getTimeOut()).until(ExpectedConditions.visibilityOf(calendarDiv));
            List<WebElement> calendarColums = calendarDiv.findElements(By.tagName("td"));
            for (WebElement cell: calendarColums){
                if (cell.getText().equals(datePk.getValue())){
                    cell.findElement(By.tagName("a")).click();
                    break;
                }
            }
        }
    }
}
