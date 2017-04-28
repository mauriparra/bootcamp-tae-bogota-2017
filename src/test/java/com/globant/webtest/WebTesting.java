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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.findElement(By.id("navBooking")).click();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origenCompAereo")));
        inputName.sendKeys("Bogota.COLOMBIA");
        //WebElement hotelSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id=hotelWrapperHotel1]>button")));
        //hotelSelector.click();
        //driver.findElement(By.cssSelector("div[id=hotelWrapperHotel1]>button")).click();
        driver.findElement(By.id("entradaCompAereo1")).sendKeys("Mar, 16 May 2017");
        driver.findElement(By.id("salidaCompAereo1")).sendKeys("Mar, 18 May 2017");
        Select selectAdults = new Select(driver.findElement(By.id("selectAereoHab1Adultos")));
        selectAdults.selectByValue("2");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("buscarAereo")));
        submitButton.click();
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
