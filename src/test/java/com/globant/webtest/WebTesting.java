/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.webtest;

import com.globant.pages.HomePage;
import com.globant.pages.QuotePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
public class WebTesting {
    
    private WebDriver driver;
    
    @BeforeMethod(description = "All actions before testing")
    @Parameters({"url"})
    public void setUpMethod(String url) throws Exception {
        driver = new ChromeDriver();
        driver.get(url);
    }
    
    @Test(description = "Starts all the web test")
    @Parameters({"agency_code", "results_title", "city_name","city_value","hotel_value","adult_number","start_date","end_date","user_id"})
    public void liquidationTest(String agencyCode, String resultsTitle, String cityName, String cityValue,
                                String hotelValue, String adultNumber, String startDate,
                                String endDate, String userId) {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        QuotePage quotePage = homePage.fillBookingEngine(agencyCode,cityName,cityValue,hotelValue,startDate,endDate,adultNumber);
        quotePage.loginAgent(userId);
        quotePage.selectAHotel(resultsTitle);
    }
    
    @AfterMethod(description = "All actions after testing")
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
}
