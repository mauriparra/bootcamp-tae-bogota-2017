/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.webtest;

import com.globant.pages.HomePage;
import com.globant.pages.QuotePage;
import static com.globant.webtest.Constants.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
public class WebTesting {
    
    private WebDriver driver;
    
    @BeforeMethod(description = "All actions before testing")
    public void setUpMethod() throws Exception {
        driver = new ChromeDriver();
        driver.get(URL);
    }
    
    @Test(description = "Starts all the web test")
    public void liquidationTest() {
       
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        QuotePage quotePage = homePage.fillBookingEngine();
        quotePage.selectAResult();
    }
    
    @AfterMethod(description = "All actions after testing")
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
