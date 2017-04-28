/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.webtest;

import static com.globant.webtest.Constants.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 *
 * @author admin
 */
public class WebTesting {
    
    private WebDriver driver;
    
    public WebTesting() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void goToMakeTest() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        
        driver.findElement(By.id("sigAge")).sendKeys(AGENCY);
        driver.findElement(By.cssSelector("#divCiud>input")).sendKeys("Bogota.COLOMBIA");
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
        Assert.assertEquals(RESULTS_TITLE, driver.getTitle());
    }

    @BeforeMethod(description = "Opens the Web Browser")
    public void setUpMethod() throws Exception {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterMethod(description = "Closes the Web Browser")
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
