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
public class latamInvalidDateFlightBookingTest extends testBase {

    @DataProvider(name = "dateSelected")

    public static Object[][] credentials() {
        return new Object[][] { {"07","05","2017"}};
    }

    @Test (dataProvider = "dateSelected", description = "This scenario will test the reponse of the application to dates out of its scope")
    public void invalidDateSelected (String departureDay, String departureMonth, String departureYear){

        latamHomePage homePage = PageFactory.initElements(driver,latamHomePage.class);

        homePage.setDepartureDate(departureDay,departureMonth,departureYear);

        Assert.assertFalse(homePage.validDepartureDateSelected());
    }
}
