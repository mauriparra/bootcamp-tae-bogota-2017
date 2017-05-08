package com.globant.bootcampAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by MauricioLeonardo on 5/4/2017.
 */
public class wordPressHomePage extends basePage {

    public wordPressHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".masterbar__publish")
    WebElement writebutton;

    public wordPressPostPage clickWriteButton (){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(writebutton));
        clickElement(writebutton);
        return PageFactory.initElements(driver,wordPressPostPage.class);
    }

}
