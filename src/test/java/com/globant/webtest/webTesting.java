/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
public class webTesting {
    
    private WebDriver driver;
    
    public webTesting() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void goToMainPage() {
        driver.get("https://www.decameron.com");
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
