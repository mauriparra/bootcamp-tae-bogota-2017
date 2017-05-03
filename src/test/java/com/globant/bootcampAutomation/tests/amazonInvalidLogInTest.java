package com.globant.bootcampAutomation.tests;

import com.globant.bootcampAutomation.utility.amazonLogInTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 4/28/2017.
 */
public class amazonInvalidLogInTest extends amazonLogInTest {

    @Test (description = "Test invalid log in")
    public void testInvalidLogIn(){

        //Inherited the method go to Log In from the abstract class amazon log in test
        super.goToLogIn("abc@gmail.com","abc123456",true);

        //If the log in is unsuccessful, the application should display an error message
        Assert.assertTrue(super.validation());
        Reporter.log("=====Password or email incorrect=====", true);
        Reporter.log("=====Invalid log in error message validated=====", true);
    }

}

