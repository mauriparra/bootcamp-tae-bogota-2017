/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.pages;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author fabian.acero
 */
public class WebSite {
    WebDriver driver;

    public WebSite(WebDriver driver){
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
}
