package com.globant.bootcampAutomation.finalProjectPages;

import com.globant.bootcampAutomation.pages.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by MauricioLeonardo on 5/5/2017.
 */
public class latamHomePage extends basePage {

    public latamHomePage( WebDriver driver ) {
        super(driver);
    }

    @FindBy(id = "compra-select-origin")
    WebElement originField;

    @FindBy(xpath = ".//*[@id='ui-id-1']//li/a/span")
    List<WebElement> originCities;

    @FindBy(id = "compra-select-destination")
    WebElement destinationCity;

    @FindBy(xpath = ".//*[@id='ui-id-2']//li/a/span")
    List<WebElement> destinationCities;

    @FindBy(xpath = "//label[@data-value='showDepartureAndReturn']")
    WebElement roundTripButton;

    @FindBy(xpath = "//label[@data-value='showDepartureOnly']")
    WebElement oneWayButton;

    @FindBy(xpath = "//div[@class='box-component departureDay col-xs-12 col-md-12']")
    WebElement departureCalendarField;

    @FindBy(xpath = "//div[@class='flightDate-calendar-cont shadow-box animable']")
    WebElement departureCalendar;

    @FindBy(xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//td")
    List<WebElement> allDatesOddMonths;

    @FindBy(xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-last']//td")
    List<WebElement> allDatesEvenMonths;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
    List<WebElement> calendarTitle;

    @FindBy(xpath = "//a[@data-handler='next']")
    WebElement nextMonthCalendarButton;

    @FindBy(xpath = "//div[@class='box-component returnDay col-xs-12 col-md-12']")
    WebElement returnCalendarField;

    @FindBy(id = "compra-passenger-count-id")
    WebElement numberOfPassengers;

    @FindBy(partialLinkText = "Add children or babies")
    WebElement addChildrenOrBabiesOption;

    @FindBy (xpath = "//div[@class='box-panel shadow-box spinners col-xs-12 col-sm-12']")
    WebElement addPassengersTable;

    @FindBy(xpath = "//div[@class='box-counter passenger-count__adults-region']//span[@class='input-group-btn more']")
    WebElement addAdultButton;

    @FindBy(xpath = "//div[@class='box-counter passenger-count__children-region']//span[@class='input-group-btn more']")
    WebElement addChildrenButton;

    @FindBy(xpath = "//div[@class='box-counter passenger-count__infants-region']//span[@class='input-group-btn more']")
    WebElement addInfantButton;

    @FindBy(id = "compra-cabins-id")
    WebElement cabinDropdown;

    @FindBy(id = "dropdown-view175-Y")
    WebElement economyCabin;

    @FindBy(id = "dropdown-view175-W")
    WebElement premiumEconomyCabin;

    @FindBy(id = "dropdown-view175-J")
    WebElement premiumBusinessCabin;

    @FindBy(css = ".button.item-component.btn-green.NoFocusable")
    WebElement searchYourFlightButton;

    WebDriverWait driverWait = new WebDriverWait(driver,20);

    public void setOriginCity( String iataCode ) {

        clickElement(originField);
        setElementText(originField, iataCode);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(originCities));
        WebElement city = originCities.get(0);
        city.click();
    }

    public void setDestinationCity( String iataCode ) {

        clickElement(destinationCity);
        setElementText(destinationCity, iataCode);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(destinationCities));
        WebElement city = destinationCities.get(0);
        city.click();
    }

    public void setTypeOfTrip( Boolean roundTrip, Boolean oneWayTrip ) {
        if (oneWayTrip) {
            clickElement(oneWayButton);
        } else if (roundTrip) {
            clickElement(roundTripButton);
        }
    }

    public void setDepartureDate( String day, String month, String year ) {

        clickElement(departureCalendarField);
        driverWait.until(ExpectedConditions.visibilityOf(departureCalendar));

        int selectedMonth = Integer.valueOf(month);
        String monthString;
        switch (selectedMonth) {
            case 1:
                monthString = "January ";
                break;
            case 2:
                monthString = "February ";
                break;
            case 3:
                monthString = "March ";
                break;
            case 4:
                monthString = "April ";
                break;
            case 5:
                monthString = "May ";
                break;
            case 6:
                monthString = "June ";
                break;
            case 7:
                monthString = "July ";
                break;
            case 8:
                monthString = "August ";
                break;
            case 9:
                monthString = "September ";
                break;
            case 10:
                monthString = "October ";
                break;
            case 11:
                monthString = "November ";
                break;
            case 12:
                monthString = "December ";
                break;
            default:
                monthString = "Invalid month";
                break;
        }

        String selectedMonthAndYear = monthString + year;

        outerLoop:
        for (int i = 0; i < calendarTitle.size(); i++) {

            String title = calendarTitle.get(i).getText();

            if ((title.equalsIgnoreCase(selectedMonthAndYear)) && (i == 1)) {

                for (int j = 1; j < allDatesEvenMonths.size(); j++) {

                    String date = allDatesEvenMonths.get(j).getText();

                    if (!(date.equals(" "))) {
                        int intDate = Integer.valueOf(date);
                        if (intDate < 10) {
                            date = "0" + date;
                        }
                    }

                    if (date.equalsIgnoreCase(day)) {
                        allDatesEvenMonths.get(j).click();
                        break outerLoop;
                    }
                }
            } else if ((title.equalsIgnoreCase(selectedMonthAndYear)) && (i == 0)) {

                for (int j = 1; j < allDatesOddMonths.size(); j++) {

                    String date = allDatesOddMonths.get(j).getText();

                    if (!(date.equals(" "))) {
                        int intDate = Integer.valueOf(date);
                        if (intDate < 10) {
                            date = "0" + date;
                        }
                    }

                    if (date.equalsIgnoreCase(day)) {
                        allDatesOddMonths.get(j).click();
                        break outerLoop;
                    }
                }
            } else if (i == 1) {
                nextMonthCalendarButton.click();
                i = 0;
            }
        }
    }

    public void setReturnDate( String day, String month, String year ) {

        clickElement(returnCalendarField);
        driverWait.until(ExpectedConditions.visibilityOf(departureCalendar));

        int selectedMonth = Integer.valueOf(month);
        String monthString;
        switch (selectedMonth) {
            case 1:
                monthString = "January ";
                break;
            case 2:
                monthString = "February ";
                break;
            case 3:
                monthString = "March ";
                break;
            case 4:
                monthString = "April ";
                break;
            case 5:
                monthString = "May ";
                break;
            case 6:
                monthString = "June ";
                break;
            case 7:
                monthString = "July ";
                break;
            case 8:
                monthString = "August ";
                break;
            case 9:
                monthString = "September ";
                break;
            case 10:
                monthString = "October ";
                break;
            case 11:
                monthString = "November ";
                break;
            case 12:
                monthString = "December ";
                break;
            default:
                monthString = "Invalid month";
                break;
        }

        String selectedMonthAndYear = monthString + year;

        outerLoop:
        for (int i = 0; i < calendarTitle.size(); i++) {

            String title = calendarTitle.get(i).getText();

            if ((title.equalsIgnoreCase(selectedMonthAndYear)) && (i == 1)) {

                for (int j = 1; j < allDatesEvenMonths.size(); j++) {

                    String date = allDatesEvenMonths.get(j).getText();

                    if (!(date.equals(" "))) {
                        int intDate = Integer.valueOf(date);
                        if (intDate < 10) {
                            date = "0" + date;
                        }
                    }

                    if (date.equalsIgnoreCase(day)) {
                        allDatesEvenMonths.get(j).click();
                        break outerLoop;
                    }
                }
            } else if ((title.equalsIgnoreCase(selectedMonthAndYear)) && (i == 0)) {

                for (int j = 1; j < allDatesOddMonths.size(); j++) {

                    String date = allDatesOddMonths.get(j).getText();

                    if (!(date.equals(" "))) {
                        int intDate = Integer.valueOf(date);
                        if (intDate < 10) {
                            date = "0" + date;
                        }
                    }

                    if (date.equalsIgnoreCase(day)) {
                        allDatesOddMonths.get(j).click();
                        break outerLoop;
                    }
                }
            } else if (i == 1) {
                nextMonthCalendarButton.click();
                i = 0;
            }
        }
    }

    public void setNumberOfPassengers( int adults, int children, int infants ) {
        clickElement(numberOfPassengers);
        int maxNumberOfPassengers = 7;

        if (children > 0) {clickElement(addChildrenOrBabiesOption);}

        for (int i = 1; i < adults; i++) {clickElement(addAdultButton);}

        for (int i = 1; i <= children; i++) {clickElement(addChildrenButton);}

        for (int i = 1; i <= infants; i++) {clickElement(addInfantButton);}
    }

    public void setCabin( Boolean economy, Boolean premiumEconomy, Boolean premiumBusiness ) {

        clickElement(cabinDropdown);
        if (economy) {
            clickElement(economyCabin);

        } else if (premiumEconomy) {
            clickElement(premiumEconomyCabin);

        } else if (premiumBusiness) {
            clickElement(premiumBusinessCabin);
        }

    }

    public Boolean validDepartureDateSelected (){

        boolean validDate = true;
        if(departureCalendar.isDisplayed()){
            validDate = false;
        }
        return validDate;
    }

    public Boolean validNumberOfPassengersSelected (){

        boolean validPassengers = true;
        if (addPassengersTable.isDisplayed()){
            validPassengers = false;
        }
        return validPassengers;
    }

    public latamSelectYourFlightPage clickSearchYourFlightButton (){
        clickElement(searchYourFlightButton);
        return PageFactory.initElements(driver,latamSelectYourFlightPage.class);
    }


}
