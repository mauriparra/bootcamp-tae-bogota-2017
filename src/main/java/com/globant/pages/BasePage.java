/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import com.globant.util.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 *
 * @author fabian.acero
 */
public class BasePage {
    WebDriver driver;
    static int TIMEOUT = 60;
    static String CSS_LOADER_IMAGE = "aa-busy-module";
    
    @FindBy(css="div[id=ui-datepicker-div]")
    private WebElement calendarDiv;
    
    @FindBy(how = How.CLASS_NAME, using = "ui-datepicker-title")
    private List<WebElement> datePickersTitles;

    @FindBy(how = How.CLASS_NAME, using = "ui-datepicker-next")
    private WebElement buttonNextCalendar;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return driver;
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
        WebElement elementToWaitFor = new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
        new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.invisibilityOf(elementToWaitFor));
    }
    /**
     * Waits until an indicated element exists
     * @param element
     */
    public void waitElement(By element){
        WebElement elementToWaitFor = new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        new WebDriverWait(getDriver(), TIMEOUT).until(ExpectedConditions.invisibilityOf(elementToWaitFor));
    }
    
    /**
     * Selects the indicated dates on the indicated datepickers
     * @param datePickers
     */
    public void selectDatePickers(List<DatePicker> datePickers){
   
        for(DatePicker datePk: datePickers){
            datePk.getElement().click();
            new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(calendarDiv));
            List<WebElement> calendarTable = findRightDatePickerMonth(datePk);
            
            for(WebElement cell: calendarTable){
            	new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(cell));
            	cell.click();
            }
        }
    }
    
    /**
     * Search and select the right calendar month. Then return the list of table's elements.
     * @param dateValues
     * @return
     */
    private List<WebElement> findRightDatePickerMonth(DatePicker datePk){

        By dayCell = By.xpath(".//table//td[(@data-handler='selectDay') and (@data-year='" + datePk.getYear() + "') and (@data-month='" + datePk.getMonth() + "')]/a[text()='" + datePk.getDay() + "']");
        List<WebElement> calendarTable = calendarDiv.findElements(dayCell);
        
        if(calendarTable.size() > 0){            	
        	return calendarTable;
        }
        
    	buttonNextCalendar.click();
    	String selectedDateTitle = datePk.getMonthName();
    	Boolean titleIsEquals = false;
    	for(WebElement dateTitle: datePickersTitles){
    		if(selectedDateTitle.equals(dateTitle.getText())){
    			titleIsEquals = true;
    			break;
    		}
    	}

    	if(!titleIsEquals){
    		findRightDatePickerMonth(datePk);
    	}
    	
    	calendarTable = calendarDiv.findElements(dayCell);
    	return calendarTable;
    }
    
    /**
     * Fills the autocomplete inputs
     * @param input
     * @param value
     * @param searchResult
     */
	public void fillAutocompleteInput(WebElement input, String value, WebElement searchResult){
		input.clear();
		input.sendKeys(value);
        WebElement autocompleteResult = new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(searchResult));
        autocompleteResult.findElement(By.cssSelector("li")).click();
	}
    
}
