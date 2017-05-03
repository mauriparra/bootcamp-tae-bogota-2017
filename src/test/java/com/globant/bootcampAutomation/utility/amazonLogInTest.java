package com.globant.bootcampAutomation.utility;

import com.globant.bootcampAutomation.pages.amazonHomePage;
import com.globant.bootcampAutomation.pages.amazonLogInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by MauricioLeonardo on 5/3/2017.
 */
public abstract class amazonLogInTest extends testBase {

    //Create method goToLogIn to avoid code duplicity and to wrap up some simple steps
    public void goToLogIn(String uName, String uPass, Boolean uRemember) {

        //Create page object of amazonHomePage using PageFactory
        amazonHomePage homePage = PageFactory.initElements(driver, amazonHomePage.class);

        //Call the method of the page object and initialized the log in page
        amazonLogInPage logInPage = homePage.clickOnLogIn();
        Reporter.log("=====Click on Sign up button in homePage=====", true);

        //Call the method of the page object
        logInPage.loginAmazon(uName, uPass, uRemember);
        Reporter.log("=====Click on Submit button in LoginPage=====", true);


    }

    public boolean validation() {

        //Create page object of amazonHomePage using PageFactory
        amazonHomePage homePage = PageFactory.initElements(driver, amazonHomePage.class);

        //Create page object of amazonLogInPage using PageFactory
        amazonLogInPage logInPage = PageFactory.initElements(driver, amazonLogInPage.class);

        //Check for valid or invalid log in calling the methods from the page objects created before
        if (homePage.validLogIn()) {

        } else if (logInPage.invalidLogIn()) {

            return false;
        }
        return true;
    }
}