package com.globant.bootcampAutomation.com.globant.bootcampAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {
    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public Select createSelector(WebElement selector){
        Select dropdown = new Select(selector);
        return dropdown;
    }
}
