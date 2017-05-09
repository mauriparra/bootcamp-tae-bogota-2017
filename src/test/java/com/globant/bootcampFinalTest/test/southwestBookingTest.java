package com.globant.bootcampFinalTest.test;

import com.globant.bootcampFinalTest.pages.BookingHomepage;
import com.globant.bootcampFinalTest.pages.SelectFlightsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class southwestBookingTest {

    private WebDriver driver;

    protected static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    protected static final String CHROME_PATH = "C:/chromedriver.exe";
    protected static final String INITIAL_URL = "https://www.southwest.com/";

    @BeforeMethod
    public void setup() throws Exception {
        System.setProperty(CHROME_PROPERTY, CHROME_PATH);
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(INITIAL_URL);
    }

    public BookingHomepage initPage(){
        BookingHomepage prepareBooking = PageFactory.initElements(driver, BookingHomepage.class);
        return prepareBooking;
    }

    @Parameters({"depart","arrival","departDate","arrivalDate","type","adults","seniors"})
    @Test(description = "search flight in Southwest Booking")
    public void fillAndSearchFlight(String depart, String arrival, String departDate, String arrivalDate, String type, Integer adults, Integer seniors) {
        SelectFlightsPage bookingResult = initPage().searchFlight(depart, arrival, departDate, arrivalDate, type, adults, seniors);
        Assert.assertTrue(bookingResult.validateFlightPage().isDisplayed());
    }

    @Parameters({"depart","arrival","departDate","arrivalDate","type","adults","seniors"})
    @Test(description = "search flight and validate the date in the return page")
    public void fillAndValidateDepartDate(String depart, String arrival, String departDate, String arrivalDate, String type, Integer adults, Integer seniors) {
        SelectFlightsPage bookingResult = initPage().searchFlight(depart, arrival, departDate, arrivalDate, type, adults, seniors);
        String[] fromDate = departDate.split("/");
        String month = (fromDate[0].length() < 2)? "0"+fromDate[0] : fromDate[0];
        String day = (fromDate[1].length() < 2)? "0"+fromDate[1] : fromDate[1];
        String originDate = fromDate[2]+"/"+month+"/"+day;
        Assert.assertEquals(originDate, bookingResult.validateDepartDate());
    }

    @Parameters({"depart","arrival","departDate","arrivalDate","type","adults","seniors"})
    @Test(description = "validate return message for max passengers")
    public void validateMaxPassengers(String depart, String arrival, String departDate, String arrivalDate, String type, Integer adults, Integer seniors) {
        SelectFlightsPage bookingResult = initPage().searchFlight(depart, arrival, departDate, arrivalDate, type, adults, seniors);
        Assert.assertTrue(bookingResult.validatePassengers());
    }

    @Parameters({"depart","arrival","departDate","type"})
    @Test(description = "validate the datePicker behavior after a click over in a past date")
    public void validatePastDepartDate(String depart, String arrival, String departDate, String type) {
        initPage().validateDatePicker(depart, arrival, departDate, type);
        WebElement datePicker = driver.findElement(By.id("calendar-descendant"));
        Assert.assertTrue(datePicker.isDisplayed());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
