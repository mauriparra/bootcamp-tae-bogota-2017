package com.globant.bootcampAutomation.tests;

import com.globant.bootcampAutomation.pages.wordPressHomePage;
import com.globant.bootcampAutomation.pages.wordPressLogInPage;
import com.globant.bootcampAutomation.pages.wordPressPostPage;
import com.globant.bootcampAutomation.utility.testBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 5/4/2017.
 */
public class wordPressPost extends testBase {

    @Test(description = "Test a valid login in wordpress")
    public void testPost (){

        wordPressLogInPage logIn = PageFactory.initElements(driver,wordPressLogInPage.class);

        logIn.setText_EmailLogin("xxxxx@hotmail.com");
        logIn.setText_PasswordLogin("xxxxxxxx");
        logIn.clickRememberMeButton(false);
        wordPressHomePage homePage = logIn.clickLoginSubmitButton();
        wordPressPostPage postPage = homePage.clickWriteButton();
        postPage.setText_PostTitle("Hello! Testing wordpress post function");
        postPage.clickPublishButton();
        postPage.waitForPostConfirmation();
        Assert.assertTrue(postPage.successfulPost());
    }
}
