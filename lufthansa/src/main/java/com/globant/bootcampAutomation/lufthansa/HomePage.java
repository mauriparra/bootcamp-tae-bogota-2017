package com.globant.bootcampAutomation.lufthansa;

import static org.testng.Assert.assertFalse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private List<WebElement> columns;
	private static final String ONEWAY_RESERVATION = "Oneway";
	private static final String ROUND_TRIP_RESERVATION = "Round Trip";
	private static final String YES_TRAVEL_CHILDREN = "Yes";
	
	@FindBy(id = "flightmanager-tab-1")
	private WebElement flightFormLink;
	
	@FindBy(id = "flightmanager-tabpanel-1")
	private WebElement flightFormTab;
	
	@FindBy(id = "flightmanagerFlightsFormReturnLabel")
	private WebElement checkRoundTripOption;
	
	@FindBy(id = "flightmanagerFlightsFormOnewayLabel")
	private WebElement checkOnewayOption;
	
	@FindBy(id = "flightmanagerFlightsFormOrigin")
	private WebElement originCity;
	
	@FindBy(id = "flightmanagerFlightsFormDestination")
	private WebElement destinationCity;
	
	@FindBy(id = "flightmanagerFlightsFormOutboundDateDisplay")
	private WebElement outbondDate;
	
	@FindBy(id = "flightmanagerFlightsFormInboundDateDisplay")
	private WebElement inbondDate;
	
	@FindBy(xpath = ".//*[@id='flightmanagerFlightsForm']/div[7]/div/a")
	private WebElement travelWithChildrenLink;
	
	@FindBy(id = "flightmanagerFlightsFormAdults")
	private WebElement selectFlightAdults;
	
	@FindBy(id = "flightmanagerFlightsFormChildren")
	private WebElement selectFlightChildren;
	
	@FindBy(id = "flightmanagerFlightsFormInfants")
	private WebElement selectFlighInfants;
	
	@FindBy(id = "flightmanagerFlightsFormCabin")
	private WebElement selectFlightCabin;
	
	@FindBy(css = "#flightmanagerFlightsForm .btn-primary")
	private WebElement btnSubmitForm;

	@FindBy(id = "flightmanagerFlightsFormdestinationPopupList")
	private WebElement popUpDestinationFlight;	
	
	@FindBy(id = "flightmanagerFlightsFormOriginPopupList")
	private WebElement popUpOriginFlight;
	
	@FindBy(css = ".months-wrapper > .month:nth-child(1) .days")
	private WebElement calendarLeft;
	
	@FindBy(css = ".months-wrapper > .month:nth-child(2) .days")
	private WebElement calendarRight;
	
	@FindBy(css = ".months-wrapper .month-head .next")
	private WebElement nextCalendarLink;
	
	@FindBy(xpath = ".//*[@id='flightmanagerFlightsForm']/div[6]/div/div/span[1]/button")
	private WebElement minusAdultButton;
	
	@FindBy(xpath = ".//*[@id='flightmanagerFlightsForm']/div[6]/div/div/span[2]/button")
	private WebElement plusAdultButton;
	
	@FindBy(id = "flightmanagerFlightsFormChildrenInfantsBlock")
	private WebElement flightChildrenBox;
	
@FindBy(className = "lhfa-global-error")
private WebElement boxError;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillBookingForm(String bookingType, String originCityText, String destinationCityText, String outbondText, String inbondText, String adultPassenger, String travelWithChildren, String childrenPassenger, String infantPassenger, String cabinType) throws InterruptedException {
		wait = new WebDriverWait(driver, 30); 
		Select flightAdults = new Select(selectFlightAdults);
		Select flightChildren = new Select(selectFlightChildren);
		Select flightInfants = new Select(selectFlighInfants);
		Select flightCabin = new Select(selectFlightCabin);
		
		if(bookingType.equals(ONEWAY_RESERVATION))
			checkOnewayOption.click();
		
		originCity.click();
		originCity.sendKeys(originCityText);
		destinationCity.sendKeys(destinationCityText);
		outbondDate.click();
		dateFlight(outbondText);		
		dateFlight(inbondText);
		selectFields(flightAdults, adultPassenger);
		
		if(travelWithChildren.equals(YES_TRAVEL_CHILDREN)) {
			travelWithChildrenLink.click();		
			wait.until(ExpectedConditions.elementToBeClickable(flightChildrenBox));
			selectFields(flightChildren, childrenPassenger);
			selectFields(flightInfants, infantPassenger);
		}
		
		selectFields(flightCabin, cabinType);
		
		btnSubmitForm.click();			
	}
	
    public void calendarMap(String day, int differenceMonth, int differenceYear) throws InterruptedException {
    	
    	if((differenceMonth == 0) && (differenceYear == 0))
    		columns = calendarLeft.findElements(By.tagName("button"));
    	
    	else if((differenceMonth == 1) && (differenceYear == 0))
    		columns = calendarRight.findElements(By.tagName("button"));
    	
    	else {
    		
    		for(int i = 0; i < (differenceMonth - 1); i++)
    			nextCalendarLink.click();
    		
    		if(((differenceMonth >= 2) && (differenceYear == 0)) || ((differenceMonth == 12) && (differenceYear == 1))) {
    			columns = calendarRight.findElements(By.tagName("button"));
    		}
    		
    		else {
    			assertFalse(nextCalendarLink.isEnabled());
    		}
    	}
    		
    	for(WebElement cell : columns) {

			if(cell.getText().equals(day)) {
				cell.click();
				break;
			}
		}
    }
    
    public void dateFlight(String dateFlight) throws InterruptedException {
    	
    	Calendar actualDate = new GregorianCalendar();

    	String[] dateFlightParts = dateFlight.split("-");
    	
    	int monthNext = Math.abs(Integer.parseInt(dateFlightParts[1]) - (actualDate.get(Calendar.MONTH) + 1));
    	int yearNext = Integer.parseInt(dateFlightParts[2]) - actualDate.get(Calendar.YEAR);
    	
    	if((Integer.parseInt(dateFlightParts[1]) <= (actualDate.get(Calendar.MONTH) + 1)) && (yearNext == 1))
    		monthNext = 12 - monthNext;
    	
    	else if((Integer.parseInt(dateFlightParts[1]) >= (actualDate.get(Calendar.MONTH) + 1)) && (yearNext == 1))
    		monthNext = 11 + monthNext;
    				
    	calendarMap(dateFlightParts[0], monthNext, yearNext);
    }
    
    public void selectFields(Select select, String optionText) {
    	
    	List<WebElement> options = select.getOptions();

    	for (WebElement option : options) {
    		System.out.println(option.getText());
    		
	    	if(optionText.equals(option.getText()))    		
	    	  option.click();
	    	
	    	else {
	    		//assert
	    		System.out.println("no");
	    	}
    	}
    }
    
    public ViewFlightPage goToViewFlightPage() {
    	return PageFactory.initElements(driver, ViewFlightPage.class);
    }
}

