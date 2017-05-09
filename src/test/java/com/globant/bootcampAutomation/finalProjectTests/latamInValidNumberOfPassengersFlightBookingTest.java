package com.globant.bootcampAutomation.finalProjectTests;

import com.globant.bootcampAutomation.finalProjectPages.latamHomePage;
import com.globant.bootcampAutomation.utility.testBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 5/5/2017.
 */
public class latamInValidNumberOfPassengersFlightBookingTest extends testBase {

    @DataProvider(name = "numberOfPassengers")

    public static Object[][] credentials() {
        return new Object[][] { {7,2,1}};
    }

    @Test (dataProvider = "numberOfPassengers", description = "This scenario will test how the application handles number of passengers above the allowed")
    public void invalidNumberOfPassengersTest (int numberOfAdults, int numberOfChildren, int numberOfInfants){

        latamHomePage homePage = PageFactory.initElements(driver,latamHomePage.class);

        homePage.setNumberOfPassengers(numberOfAdults,numberOfChildren,numberOfInfants);

        Assert.assertFalse(homePage.validNumberOfPassengersSelected());
    }
}
