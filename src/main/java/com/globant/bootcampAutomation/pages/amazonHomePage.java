package com.globant.bootcampAutomation.pages;

import com.globant.bootcampAutomation.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class amazonHomePage extends basePage {

    //Extending the basePage abstract super class to get public variables and methods

    //Using the constructor to overload the driver to be used in each page object
    public amazonHomePage (WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "nav-link-accountList")
    WebElement accountList;

    public amazonLogInPage clickOnLogIn() {
        accountList.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, amazonLogInPage.class);
    }

    public String homePageTitle (){
        String title =  driver.getTitle();
        return title;
    }

    public boolean validLogIn (){
        if (homePageTitle()=="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"){}
        return true;
    }

}
