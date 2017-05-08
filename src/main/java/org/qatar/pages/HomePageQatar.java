package org.qatar.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class defines the mapping of the HomeQatar page and the methods to operate with WebDriver
 * @author: Sergio Gonzalez Rios
 * @version: 08/05/2017/
 */

public class HomePageQatar {
	WebDriver driver;
	 /**
     * Builder for WebDriver controller
     */

	public HomePageQatar(WebDriver driver1) {
		this.driver = driver1;
	}
	/**
     * Method that finds the months from the numbers.
     * @param numberMonth Number of the month.
     * @return name month
     */
	private String MonthCalendarCoversor(String numberMonth) {
		ArrayList<String> month = new ArrayList<String>();
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		return month.get(Integer.parseInt(numberMonth) - 1);
	}
	/**
     * Method that finds month in date picker and set date
     * @param month,year,day these are the parts from date
     * @return boolean if date is set return true or false
     */
	private boolean searchMonthAndYearInCalendar(String month, String year, String day) {
		//System.out.println(day+month+year);
		int counterMaximusClicksNextButton = 6;
		for (int i = 0; i < counterMaximusClicksNextButton; i++) {
			if (monthPickerTitleGroupFirst.getText().equalsIgnoreCase(month) && yearPickerTitleGroupFisrt.getText().equalsIgnoreCase(year)) {
				List<WebElement> columns = calendarPickerMonthGroupFirst.findElements(By.tagName("td"));
				if (selectDayinCalendar(day,columns)) {
					return true;
				} else {
					return false;
				}

			}
			if (monthPickerTitleGroupMiddle.getText().equalsIgnoreCase(month)&& yearPickerTitleGroupMiddle.getText().equalsIgnoreCase(year)) {
				List<WebElement> columns = calendarPickerMonthGroupMiddle.findElements(By.tagName("td"));
				if (selectDayinCalendar(day,columns)) {
					return true;
				} else {
					return false;
				}

			}
			if (monthPickerTitleGroupLast.getText().equalsIgnoreCase(month)&& yearPickerTitleGroupLast.getText().equalsIgnoreCase(year)) {
				List<WebElement> columns = calendarPickerMonthGroupLast.findElements(By.tagName("td"));
				if (selectDayinCalendar(day,columns)) {
					return true;
				} else {
					return false;
				}
			}

			nextPageCalendar.click();

			//System.out.println(i);
		}
		
		System.out.println("Date Invalid");
		return false;
	}
	/**
     * Method that set day in date picker 
     * @param day,List<WebElement> columns, day to set and elements the picker
     * @return boolean if day is set return true or false
     */

	private boolean selectDayinCalendar(String day,List<WebElement> columns) {
		
		for (WebElement cell: columns) {
	          if (cell.getText().equals(day)) {
	        	  if(cell.getAttribute("class").contains("ui-state-disabled")){
	        		  System.out.println("Day Invalid");
	        		  return false;
	        		 
	        		  
	        	  }else{
	        		  cell.click();
	        		  return true;                  
	        	  }
	              
	          }
	      }

		return false;
	}
	/**
     * Mapping of page elements from Home Page Qatar.
     */
	
	@FindBy(how = How.CSS, using = "#joneway")
	WebElement selectOneWay;
	@FindBy(how = How.ID, using = "FromTemp")
	WebElement OriginAirport;
	@FindBy(how = How.CSS, using = "ul.ui-autocomplete a.ui-corner-all")
	WebElement listResultAirport;
	@FindBy(how = How.ID, using = "ToTemp")
	WebElement DestinationAirport;
	@FindBy(how = How.ID, using = "departingHidden")
	WebElement DateInitialFlight;
	@FindBy(how = How.ID, using = "returningHidden")
	WebElement DateReturnFlight;
	@FindBy(how = How.ID, using = "adults")
	WebElement DropdownSelectAdults;
	@FindBy(how = How.ID, using = "children")
	WebElement DropdownSelectChildren;
	@FindBy(how = How.ID, using = "infants")
	WebElement DropdownSelectInfant;
	@FindBy(how = How.ID, using = "bookingClassm")
	WebElement CheckBoxPremiumClass;
	@FindBy(how = How.ID, using = "promoCode")
	WebElement InputPromoCode;
	@FindBy(how = How.ID, using = "bookFlight")
	WebElement ButtonSearchFlight;

	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-first span.ui-datepicker-month")
	WebElement monthPickerTitleGroupFirst;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-middle span.ui-datepicker-month")
	WebElement monthPickerTitleGroupMiddle;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-last span.ui-datepicker-month")
	WebElement monthPickerTitleGroupLast;

	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-first span.ui-datepicker-year")
	WebElement yearPickerTitleGroupFisrt;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-middle span.ui-datepicker-year")
	WebElement yearPickerTitleGroupMiddle;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-last span.ui-datepicker-year")
	WebElement yearPickerTitleGroupLast;
		
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-first table.ui-datepicker-calendar")
	WebElement calendarPickerMonthGroupFirst;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-middle table.ui-datepicker-calendar")
	WebElement calendarPickerMonthGroupMiddle;
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-last table.ui-datepicker-calendar")
	WebElement calendarPickerMonthGroupLast;
	
	@FindBy(how = How.CSS, using = "div.ui-datepicker-group.ui-datepicker-group-last span.ui-icon")
	WebElement nextPageCalendar;
	
	
	@FindBy(how = How.CSS, using = "#styledSelectadults")
	WebElement buttonSelectAdults;
	@FindBy(how = How.CSS, using = "#uladults")
	WebElement listAdultsSelection;
	
	@FindBy(how = How.CSS, using = "#styledSelectchildren")
	WebElement buttonSelectChilds;
	@FindBy(how = How.CSS, using = "#ulchildren")
	WebElement listChildsSelection;
	
	
	@FindBy(how = How.CSS, using = "#styledSelectinfants")
	WebElement buttonSelectInfants;
	@FindBy(how = How.CSS, using = "#ulinfants")
	WebElement listInfantsSelection;
	
	
	@FindBy(how = How.CSS, using = "label[for='bookingClassm']")
	WebElement buttonPremiumClass;
	
	@FindBy(how = How.ID, using = "promoCode")
	WebElement inputPromocode;
	
	@FindBy(how = How.ID, using = "bookFlight")
	WebElement buttonSearchFlight;
	
	
	/**
     * Method that assigns iatacoud in the field From.
     * @param iatacode airport
     */
	public void FillAirportStartFlight(String iataCode) {
		OriginAirport.click();
		OriginAirport.sendKeys(iataCode);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(listResultAirport));
		listResultAirport.click();
	}
	/**
     * Method that assigns iatacoud in the field To.
     * @param iatacode airport
     */

	public void FillAirportDestinationFlight(String iataCode) {
		DestinationAirport.click();
		DestinationAirport.sendKeys(iataCode);
		listResultAirport.click();
	}
	/**
     * Method that fill calendar departing.
     * @param date date from start flight
     * @return boolean if date is set return true or false in calendar
     */

	public boolean FillCalendarDeparting(String date) {
		if (date.isEmpty()){
			return false;
		}
		String[] calendar = date.split("-");
		String month = MonthCalendarCoversor(calendar[1]);
		String year = calendar[2];
		int  day = Integer.parseInt(calendar[0]);
		if (searchMonthAndYearInCalendar(month, year,Integer.toString(day))) {
			return true;
		}

		return false;
	}
	
	/**
     * Method that fill calendar Returning.
     * @param date date from returning flight
     * @return boolean if date is set return true or false in calendar
     */
	public boolean FillCalendarReturning(String date) {
		if(date.isEmpty()){
			return false;
		}
		String[] calendar = date.split("-");
		String month = MonthCalendarCoversor(calendar[1]);
		String year = calendar[2];
		int  day = Integer.parseInt(calendar[0]);
		if (searchMonthAndYearInCalendar(month, year,Integer.toString(day))) {
			return true;
		}
		return false;
	}
	/**
     * Method that fill field adults .
     * @param adults number valid from adults
     * @return boolean if field is selected correctly
     */
	public boolean FillAdultSelection(String adults){
		buttonSelectAdults.click();
		int numberAdults=Integer.parseInt(adults);
		List<WebElement> list = listAdultsSelection.findElements(By.tagName("li"));
	      for (WebElement selection: list) {
	          if (selection.getText().equals(Integer.toString(numberAdults))) {
	        	  selection.click();
	        	  return true;	        	  
	          }
	      }
	      return false;
	}
	/**
     * Method that fill field child.
     * @param child number valid from child
     * @return boolean if field is selected correctly
     */
	public boolean FillChildSelection(String child){
		buttonSelectChilds.click();
		int numberChilds=Integer.parseInt(child);
		List<WebElement> list = listChildsSelection.findElements(By.tagName("li"));
	      for (WebElement selection: list) {
	          if (selection.getText().equals(Integer.toString(numberChilds))) {
	        	  selection.click();
	        	  return true;	        	  
	          }
	      }
	      return false;
	}
	/**
     * Method that fill field infants.
     * @param infants number valid from infants
     * @return boolean if field is selected correctly
     */
	
	public boolean FillInfantsSelection(String infants){
		buttonSelectInfants.click();
		int numberInfants=Integer.parseInt(infants);
		List<WebElement> list = listInfantsSelection.findElements(By.tagName("li"));
	      for (WebElement selection: list) {
	          if (selection.getText().equals(Integer.toString(numberInfants))) {
	        	  selection.click();
	        	  return true;	        	  
	          }
	      }
	      return false;
	}
	/**
     * Method that fill checkbox premium class
     * @param check if yes the check is fill
     * @return boolean if field is selected correctly
     */
	public boolean SelectButtonPremiumClass(String check){
		if(check.equals("yes")){
			buttonPremiumClass.click();
			return true;
		}if(check.equals("no")){
			return true;
		}
		return false;
	}
	/**
     * Method that fill promocode
     * @param code code promotional
     * @return boolean if field is fill correctly
     */
	public boolean FillPromoCode(String code){
		if(code.isEmpty()){
			return true;
		}else{
			inputPromocode.click();
			inputPromocode.sendKeys(code);
		}
		return false;
	}
	/**
     * Method that send consult 
     * @return next page from review
     */
	public ReviewReservationPage ActionSearchFlight(){
		buttonSearchFlight.click();
		return PageFactory.initElements(driver, ReviewReservationPage.class);
	}
//	public void SelectOneWayFlight(String select){
//		if(select.equals("yes")){
//			selectOneWay.click();
//		}	
//	}

}
