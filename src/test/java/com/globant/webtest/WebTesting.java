/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.webtest;

import static com.globant.webtest.Constants.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
@Test
public class WebTesting {
    
    private WebDriver driver;
    
    public WebTesting() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    public void goToMainPage() {
        driver.get(URL);
    }
    
    public void fillInput(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("origenCompAereo")));
        element.sendKeys("Bogota.COLOMBIA");
        //driver.findElement(By.id("origenCompAereo")).sendKeys("Bogota.COLOMBIA");
        /*driver.findElement(By.id("hotelWrapperHotel1")).findElement(By.tagName("button")).click();*/
        /*WebElement dinamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedExceptions.presenceOfElementLocated(By.id("origenCompAereo")));*/
        /*WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedException.)*/
    }

    @BeforeClass(description = "Opens the Web Browser")
    public void setUpMethod() throws Exception {
        driver = new FirefoxDriver();
    }

    @AfterClass(description = "Closes the Web Browser")
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
