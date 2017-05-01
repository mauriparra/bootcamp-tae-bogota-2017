/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import static com.globant.webtest.Constants.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author admin
 */
public class HomePage {
    
    @FindBy(css="input[class*='sbox-destination']")
    private WebElement destinationInput;
    
    @FindBy(css="a[class*='sbox-search']")
    private WebElement buttonSearch;
    
    @FindBy(css="span[class*='eva-icon-close-circled']")
    private WebElement buttonClosePopUp;
    
    public HomePage(){
        //PageFactory.initElements(driver, this);
    }
    
    public void fillBookingEngine(){
        
        //WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);        
        destinationInput.sendKeys(DESTINATION_NAME);
        buttonClosePopUp.click();
        buttonSearch.click();
        //driver.findElement(By.id("sigAge")).sendKeys(AGENCY);
        /*driver.findElement(By.cssSelector("#divCiud>input")).sendKeys("Bogota.COLOMBIA");
        String scriptText = "document.querySelector('#CIUDAD_ORIGEN').setAttribute('value','" + CITY_VALUE + "')";
        ((JavascriptExecutor)driver).executeScript(scriptText);
        (new Select(driver.findElement(By.id("hotel")))).selectByValue(HOTEL_VALUE);
        (new Select(driver.findElement(By.id("hab1adultos")))).selectByValue("3");
        
        String[][] calendarData = new String[][]{
            {"FECHA_LLEGADA", START_DATE},
            {"FECHA_SALIDA", END_DATE}
        };
                
        for(String[] date: calendarData){
            driver.findElement(By.name(date[0])).click();
            WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
            List<WebElement> calendarColums = calendar.findElements(By.tagName("td"));
            for (WebElement cell: calendarColums){
                if (cell.getText().equals(date[1])){
                    cell.findElement(By.tagName("a")).click();
                    break;
                }
            }
        }

        driver.findElement(By.className("botonNaranjaFlecha")).click();
        WebElement loaderSpinner = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SpanLabelDivLoad")));
        wait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
        Assert.assertEquals(RESULTS_TITLE, driver.getTitle());*/
    }
}
