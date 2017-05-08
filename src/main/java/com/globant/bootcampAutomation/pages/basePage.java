package com.globant.bootcampAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class basePage {

    public WebDriver driver;

    public basePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText (WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
