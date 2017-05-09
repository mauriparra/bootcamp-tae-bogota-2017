package com.globant.bootcampAutomation.finalProjectTests;

import com.globant.bootcampAutomation.finalProjectPages.latamHomePage;
import com.globant.bootcampAutomation.finalProjectPages.latamSelectYourFlightPage;
import com.globant.bootcampAutomation.utility.testBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 5/5/2017.
 */
public class latamValidFlightBookingTest extends testBase {

    @DataProvider(name = "booking")

    public static Object[][] credentials() {
        return new Object[][] { { "BOG", "NYC",true,false,"08","05","2017","03","04","2018",4,2,1,false,true,false }};
    }

    @Test (dataProvider = "booking", description = "This scenario will test for a valid full flight booking, including types os trips,a wide range of dates, a variety of passengers number and type of cabin chosen")
    public void bookFlightTest (String originCity, String destinationCity, Boolean roundtrip,Boolean oneWayTrip, String departureDay, String departureMonth, String departureYear, String returnDay, String returnMonth, String returnYear, int numberOfAdults, int numberOfChildren, int numberOfInfants, Boolean economycabin, Boolean premiumEconomyCabin, Boolean premiumBusinessCabin ){

        latamHomePage homePage = PageFactory.initElements(driver,latamHomePage.class);

        homePage.setOriginCity(originCity);
        homePage.setDestinationCity(destinationCity);
        homePage.setTypeOfTrip(roundtrip,oneWayTrip);
        homePage.setDepartureDate(departureDay,departureMonth,departureYear);
        if(roundtrip==true){ homePage.setReturnDate(returnDay,returnMonth,returnYear);}
        homePage.setNumberOfPassengers(numberOfAdults,numberOfChildren,numberOfInfants);
        homePage.setCabin(economycabin,premiumEconomyCabin,premiumBusinessCabin);

        latamSelectYourFlightPage selectYourFlightPage = homePage.clickSearchYourFlightButton();

        Assert.assertTrue(selectYourFlightPage.validateSelectYourFlightTitle());
        Assert.assertTrue(selectYourFlightPage.validateItineraryTitle());
        Assert.assertTrue(selectYourFlightPage.validateAvailableFaresTitle());

    }
}
