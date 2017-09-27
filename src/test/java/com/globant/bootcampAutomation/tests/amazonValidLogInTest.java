package com.globant.bootcampAutomation.tests;

import com.globant.bootcampAutomation.utility.amazonLogInTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 4/28/2017.
 */
public class amazonValidLogInTest extends amazonLogInTest {

    @Test (priority =1,description = "Test valid log in")
    public void testLogIn() {

        //Inherited the method go to Log In from the abstract class amazon log in test
        super.goToLogIn("xxxxxx@hotmail.com","xxxxxxxxx",false);

        //If the log in is successful, the application should go afterwards to home page
        Assert.assertTrue(super.validation());
        Reporter.log("=====Log in function validated=====", true);
    }

}

