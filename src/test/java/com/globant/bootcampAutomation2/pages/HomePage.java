package com.globant.bootcampAutomation2.pages;

import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver){
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, 30);
	String group1PathDay = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td";
	String group2PathDay = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td";
	String group3PathDay = "//*[@id='ui-datepicker-div']/div[3]/table/tbody/tr/td";
		
	@FindBy(id = "journeyTypeow")
	private WebElement oneWay;
	
	@FindBy(id = "journeyTypert")
	private WebElement roundTrip;
	
	@FindBy(xpath = "//*[@id='form_booking']/div[3]/span/input")
	private WebElement originAirport;
	
	@FindBy(xpath = "//*[@id='form_booking']/div[4]/span/input")
	private WebElement destinationAirport;
	
	@FindBy(css = ".js-destination-airport")
	private WebElement destinationClickable;
	
	@FindBy(id = "ui-id-1")
	private WebElement dropDownOrigin;
	
	@FindBy(xpath = "//*[@id='ui-id-1']/child::li[1]")
	private WebElement dropDownOriginFirstItem;
	
	@FindBy(id = "ui-id-1273")
	private WebElement dropDownDestination;
	
	@FindBy(xpath = "//*[@id='ui-id-1273']/child::li[1]")
	private WebElement dropDownDestinationFirstItem;
	
	@FindBy(xpath = "//*[@id='form_booking']/div[4]/div")
	private WebElement loadingDestination;
	
	@FindBy(id = "ui-datepicker-div")
	private WebElement firstDateCalendar;
	
	@FindBy(id = "departureDate")
	private WebElement firstDatePicker;
	
	@FindBy(id = "returnDate")
	private WebElement returnDateBtn;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table")
	private WebElement dateDayGroup1;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table")
	private WebElement dateDayGroup2;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[3]/table")
	private WebElement dateDayGroup3;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")
	private WebElement dateMonthGroup1;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")
	private WebElement dateMonthGroup2;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[3]/div/div/span[1]")
	private WebElement dateMonthGroup3;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")
	private WebElement dateYearGroup1;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")
	private WebElement dateYearGroup2;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[3]/div/div/span[2]")
	private WebElement dateYearGroup3;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[3]/div/a/span")
	private WebElement next3Months;
	
	@FindBy(css = ".passenger-control")
	private WebElement passengerSelect;
	
	@FindBy(id = "Level1")
	private WebElement economyClassBtn;
	
	@FindBy(id = "Level2")
	private WebElement businessClassBtn;
	
	@FindBy(id = "Level3")
	private WebElement firstClassBtn;
	
	@FindBy(id = "age1")
	private WebElement adultsGuests;
	
	@FindBy(xpath = "//*[@id='age2']")
	private WebElement childrenGuests;
	
	@FindBy(id = "age3")
	private WebElement infantsGuests;
	
	@FindBy(id = "promo_code")
	private WebElement passengerControl;
	
	@FindBy(id = "submit_btn")
	private WebElement submitBtn;
	
	public void SelectOneRound(String trip){
		if(trip.equalsIgnoreCase("true"))
			oneWay.click();
		else
			roundTrip.click();
	}
	
	public void SelectOriginAirport(String origin){
		originAirport.click();
		originAirport.sendKeys(origin);
		wait.until(ExpectedConditions.visibilityOf(dropDownOrigin));
		dropDownOriginFirstItem.click();
	}
	
	public void SelectDestinationAirport(String destination){
		wait.until(ExpectedConditions.invisibilityOf(loadingDestination));
		destinationAirport.click();
		destinationAirport.sendKeys(destination);
		wait.until(ExpectedConditions.visibilityOf(dropDownDestination));
		dropDownDestinationFirstItem.click();
	}
	
	public void SelectDepartureDate(String departureDate){
		StringTokenizer dateDepartureTokens = new StringTokenizer(departureDate,"/");
		String departureRawDay = dateDepartureTokens.nextToken();
		String departureRawMonth = dateDepartureTokens.nextToken();
		String departureYear = dateDepartureTokens.nextToken();
		WebElement departureDaySelection = null;
		boolean findMonth = true;
		boolean findYear = true;
		String departureMonth = MonthCase(departureRawMonth);
		String departureDay = DayCase(departureRawDay);
		while(findYear){
			if(departureYear.equals(dateYearGroup1.getText()) || departureYear.equals(dateYearGroup2.getText()) || departureYear.equals(dateYearGroup3.getText()))
				findYear = false;
			else
				next3Months.click();
		}
		while(findMonth){
			if(departureMonth.equals(dateMonthGroup1.getText())){
//				departureDaySelection = dateDayGroup1.findElement(By.xpath("//tbody[contains(.,"+departureDay+")]"));
				departureDaySelection = driver.findElement(By.xpath(group1PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else if(departureMonth.equals(dateMonthGroup2.getText())){
//				departureDaySelection = dateDayGroup2.findElement(By.xpath("//tbody[contains(.,"+departureDay+")]"));
				departureDaySelection = driver.findElement(By.xpath(group2PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else if(departureMonth.equals(dateMonthGroup3.getText())){
//				departureDaySelection = dateDayGroup3.findElement(By.xpath("//tr/td[contains(.,'"+departureDay+"')]"));
				departureDaySelection = driver.findElement(By.xpath(group3PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else
				next3Months.click();
		}
		departureDaySelection.click();
//		String enableDate = departureDaySelection.getAttribute("class");
//		
//		return enableDate;
		
	}
	public String SelectDeparturePastDate(String departureDate){
		StringTokenizer dateDepartureTokens = new StringTokenizer(departureDate,"/");
		String departureRawDay = dateDepartureTokens.nextToken();
		String departureRawMonth = dateDepartureTokens.nextToken();
		String departureYear = dateDepartureTokens.nextToken();
		WebElement departureDaySelection = null;
		boolean findMonth = true;
		boolean findYear = true;
		String departureMonth = MonthCase(departureRawMonth);
		String departureDay = DayCase(departureRawDay);
		while(findYear){
			if(departureYear.equals(dateYearGroup1.getText()) || departureYear.equals(dateYearGroup2.getText()) || departureYear.equals(dateYearGroup3.getText()))
				findYear = false;
			else
				next3Months.click();
		}
		while(findMonth){
			if(departureMonth.equals(dateMonthGroup1.getText())){
				departureDaySelection = driver.findElement(By.xpath(group1PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else if(departureMonth.equals(dateMonthGroup2.getText())){
				departureDaySelection = driver.findElement(By.xpath(group2PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else if(departureMonth.equals(dateMonthGroup3.getText())){
				departureDaySelection = driver.findElement(By.xpath(group3PathDay+"[contains(.,'"+departureDay+"')]"));
				findMonth = false;
			}
			else
				next3Months.click();
		}
		departureDaySelection.click();
		String enableDate = departureDaySelection.getAttribute("class");
		
		return enableDate;
		
	}
	
	public void SelectReturnDate(String returnDate){
		StringTokenizer dateReturnTokens = new StringTokenizer(returnDate,"/");
		String returnRawDay = dateReturnTokens.nextToken();
		String returnRawMonth = dateReturnTokens.nextToken();
		String returnYear = dateReturnTokens.nextToken();
		WebElement returnDaySelection = null;
		boolean findMonth = true;
		boolean findYear = true;
		String returnMonth = MonthCase(returnRawMonth);
		String returnDay = DayCase(returnRawDay);
		returnDateBtn.click();
		while(findYear){
			if(returnYear.equals(dateYearGroup1.getText()) || returnYear.equals(dateYearGroup2.getText()) ||returnYear.equals(dateYearGroup3.getText()))
				findYear = false;
			else
				next3Months.click();
		}
		while(findMonth){
			if(returnMonth.equals(dateMonthGroup1.getText())){
//				departureDaySelection = dateDayGroup1.findElement(By.xpath("//tbody[contains(.,"+departureDay+")]"));
				returnDaySelection = driver.findElement(By.xpath(group1PathDay+"[contains(.,'"+returnDay+"')]"));
				findMonth = false;
			}
			else if(returnMonth.equals(dateMonthGroup2.getText())){
//				departureDaySelection = dateDayGroup2.findElement(By.xpath("//tbody[contains(.,"+departureDay+")]"));
				returnDaySelection = driver.findElement(By.xpath(group2PathDay+"[contains(.,'"+returnDay+"')]"));
				findMonth = false;
			}
			else if(returnMonth.equals(dateMonthGroup3.getText())){
//				departureDaySelection = dateDayGroup3.findElement(By.xpath("//tr/td[contains(.,'"+departureDay+"')]"));
				returnDaySelection = driver.findElement(By.xpath(group3PathDay+"[contains(.,'"+returnDay+"')]"));
				findMonth = false;
			}
			else
				next3Months.click();
		}
		returnDaySelection.click();
	
	}
	
	public void CabinAndGuestSelect(String cabin, String adults, String children, String infants){
		wait.until(ExpectedConditions.elementToBeClickable(passengerControl));
		passengerControl.sendKeys(" ");
		passengerSelect.click();
		if(cabin.equalsIgnoreCase("economy"))
			economyClassBtn.click();
		else if(cabin.equalsIgnoreCase("business"))
			businessClassBtn.click();
		else if(cabin.equalsIgnoreCase("first"))
			firstClassBtn.click();
		
		adultsGuests.click();
		driver.findElement(By.xpath("//*[@id='age1']/option[contains(.,'"+adults+"')]")).click();
		adultsGuests.click();
		childrenGuests.click();
		driver.findElement(By.xpath("//*[@id='age2']/option[contains(.,'"+children+"')]")).click();
		adultsGuests.click();
		infantsGuests.click();
		driver.findElement(By.xpath("//*[@id='age3']/option[contains(.,'"+infants+"')]")).click();
		infantsGuests.click();
		passengerSelect.click();
	}
	
	public Page2 SubmitHomePage(){
		submitBtn.click();
		return PageFactory.initElements(this.driver, Page2.class);
	}
	
	public String DayCase(String rawDay){
		String correctedDay = "";
		switch(rawDay){
		case "01": correctedDay = "1"; break;
		case "02": correctedDay = "2"; break;
		case "03": correctedDay = "3"; break;
		case "04": correctedDay = "4"; break;
		case "05": correctedDay = "5"; break;
		case "06": correctedDay = "6"; break;
		case "07": correctedDay = "7"; break;
		case "08": correctedDay = "8"; break;
		case "09": correctedDay = "9"; break;
		default: correctedDay = rawDay; break;
		}
		return correctedDay;
	}
	
	public String MonthCase(String rawMonth){
		String correctedMonth = "";
		switch(rawMonth){
		case "01": correctedMonth = "January"; break;
		case "02": correctedMonth = "February"; break;
		case "03": correctedMonth = "March"; break;
		case "04": correctedMonth = "April"; break;
		case "05": correctedMonth = "May"; break;
		case "06": correctedMonth = "June"; break;
		case "07": correctedMonth = "July"; break;
		case "08": correctedMonth = "August"; break;
		case "09": correctedMonth = "September"; break;
		case "10": correctedMonth = "October"; break;
		case "11": correctedMonth = "November"; break;
		case "12": correctedMonth = "December"; break;
		}
		return correctedMonth;
	}
	

}
