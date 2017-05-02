package com.globant.bootcampAutomation.TestCases;

import com.globant.bootcampAutomation.Pages.AmazonHomePage;
import com.globant.bootcampAutomation.Pages.AmazonLogInPage;
import com.globant.bootcampAutomation.Utility.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 4/28/2017.
 */
public class TestAmazonLogIn extends TestBase {

    @Test (priority = 1, description = "Test valid log in")
    public void testLogIn() {

        //Created page object of AmazonHomePage using PageFactory
        AmazonHomePage homePage = PageFactory.initElements(driver, AmazonHomePage.class);

        //Call the method of the page object
        homePage.clickOnLogIn();
        Reporter.log("=====Click on Sign up button in homePage=====", true);

        //Created page object of AmazonLogIn using PageFactory
        AmazonLogInPage logInPage = PageFactory.initElements(driver, AmazonLogInPage.class);

        //Call the method of the page object
        logInPage.loginAmazon("rack2106@hotmail.com", "mao1020754347", false);
        Reporter.log("=====Click on Submit button in LoginPage=====", true);

        //If the log in is successful, the application should go afterwards to home page
        Assert.assertEquals(driver.getTitle(),"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
        Reporter.log("=====Log in function validated=====", true);
    }

    @Test (priority = 2, description = "Test invalid log in")
    public void testInvalidLogIn() {

        //Created page object of AmazonHomePage using PageFactory
        AmazonHomePage homePage = PageFactory.initElements(driver,AmazonHomePage.class);

        //Call the method of the page object
        homePage.clickOnLogIn();
        Reporter.log("=====Click on Sign up button in homePage=====", true);

        //Created page object of AmazonLogIn using PageFactory
        AmazonLogInPage logInPage = PageFactory.initElements(driver, AmazonLogInPage.class);

        //Call the method of the page object
        logInPage.loginAmazon("abc@gmail.com", "abc123456", true);
        Reporter.log("=====Click on Submit button in LoginPage=====", true);

        //If the log in is unsuccessful, the application should display an error message
        Assert.assertEquals(true, logInPage.invalidLogIn());
        Reporter.log("=====Password or email incorrect=====", true);
        Reporter.log("=====Invalid log in error message validated=====", true);

    }

}
