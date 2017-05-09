package com.globant.finalDelivery;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.globant.fibakDelivery.HomePageTest;

public class HomePage {

	@FindBy(id = "minibe__roundTrip--label")
	private WebElement roundWay;

	@FindBy(id = "minibe__oneWay--label")
	private WebElement oneWay;

	@FindBy(id = "minibe__od--out")
	private WebElement originInput;

	@FindBy(xpath = "//input[@id='minibe__od--in']")
	private WebElement destinationInput;

	@FindBy(xpath = "//button[@id='minibe__button--calendar_out']")
	private WebElement departureDate;

	@FindBy(id = "minibe__button--passenger")
	private WebElement passengersView;

	@FindBy(id = "validate_typo_button")
	private WebElement confirmPassengersView;

	@FindBy(id = "more_pax")
	private WebElement morePassengers;

	@FindBy(id = "minibe__button--search")
	private WebElement searchButtton;

	@FindBy(id = "minibe__button--class")
	private WebElement cabinClass;

	@FindBy(id = "tnr__icc__LH--YMCHER")
	private WebElement mostEconomyClass;

	@FindBy(id = "tnr__icc__LH--YFLEX")
	private WebElement economyClass;

	@FindBy(id = "tnr__icc__LH--WMCHER")
	private WebElement premiunClass;

	@FindBy(id = "tnr__icc__MH--CMCHER")
	private WebElement bussinesClass;

	@FindBy(id = "tnr__icc__LH--FMCHER")
	private WebElement premiereClass;

	public static final String[] AFE_OPTIONS = new String[] { "Senior (65 years and older)", "Adult (25 - 64 years)",
			"Young (18 - 24 years)", "Young (12 - 17 years)", "Child (2 - 11 years)" };

	//First scenary search fligths roud Trip,  two passengers in bussines class 
	public void searchFlighRoundTrip(String origin, String destination, String depatureYear, String departureMonth,
			String departureDay, String backYear, String backMoth, String backDay, String[] passengers) {

		Calendar calendar = GregorianCalendar.getInstance();
		if (Integer.valueOf(depatureYear) < calendar.get(Calendar.YEAR)) {
			throw new IllegalStateException("Use a valid date in the future");
		}
		if (Integer.valueOf(depatureYear) == calendar.get(Calendar.YEAR)
				&& Integer.valueOf(departureMonth) < calendar.get(Calendar.MONTH)) {
			throw new IllegalStateException("Use a valid date in the future");
		}
		if (Integer.valueOf(depatureYear) == calendar.get(Calendar.YEAR)
				&& Integer.valueOf(departureMonth) == calendar.get(Calendar.MONTH)
				&& Integer.valueOf(departureDay) < calendar.get(Calendar.DAY_OF_MONTH)) {
			throw new IllegalStateException("Use a valid date in the future");
		}
		
		if (Integer.valueOf(backYear) < Integer.valueOf(depatureYear)){
			throw new IllegalStateException("Use a valid date for return"); 
		}
		if (Integer.valueOf(backMoth) < Integer.valueOf(departureMonth)){
			throw new IllegalStateException("Use a valid date for return");
		}
		if (Integer.valueOf(backDay) < Integer.valueOf(departureDay)){
			throw new IllegalStateException("Use a valid date for return");
		}
			
		roundWay.click();
		originInput.sendKeys(origin);
		Assert.assertEquals("PAR", origin);
		originInput.sendKeys(Keys.ENTER);
		sleep(5);
		destinationInput.sendKeys(destination);
		destinationInput.sendKeys(Keys.ENTER);
		sleep(30);
		WebElement nextMonthButton = HomePageTest.driver
				.findElement(By.xpath("//*[@id='calendar']/header/div[2]/button[2]"));
		List<WebElement> date = HomePageTest.driver
				.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
		sleep(10);
		boolean clicked = true;
		while (clicked) {
			if (date.size() == 0) {
				nextMonthButton.click();
				sleep(10);
				date = HomePageTest.driver
						.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
			} else {
				try {
					date.get(0).click();
					clicked = false;
				} catch (ElementNotVisibleException e) {
					nextMonthButton.click();
					sleep(10);
					date = HomePageTest.driver
							.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
				}
			}
		}
		sleep(10);
		nextMonthButton = HomePageTest.driver.findElement(By.xpath("//*[@id='calendar']/header/div[2]/button[2]"));
		List<WebElement> backDate = HomePageTest.driver
				.findElements(By.id("calendar--" + backYear + backMoth + backDay));
		clicked = true;
		while (clicked) {
			if (backDate.size() == 0) {
				nextMonthButton.click();
				sleep(1);
				backDate = HomePageTest.driver.findElements(By.id("calendar--" + backYear + backMoth + backDay));
			} else {
				try {
					backDate.get(0).click();
					clicked = false;
				} catch (ElementNotVisibleException e) {
					nextMonthButton.click();
					sleep(1);
					backDate = HomePageTest.driver.findElements(By.id("calendar--" + backYear + backMoth + backDay));
				}
			}
		}
		sleep(10);
		passengersView.click();
		sleep(10);
		WebElement passengersQuantityView = HomePageTest.driver
				.findElement(By.xpath("//label[@for='tnr__itp__" + passengers.length + "']"));
		passengersQuantityView.click();
		sleep(10);
		for (int i = 0; i < passengers.length; i++) {
			String passenger = passengers[i];
			int index = i + 1;
			Select select = new Select(HomePageTest.driver.findElement(By.id("pax__" + index)));
			select.selectByVisibleText(passenger);
			sleep(10);
		}
		sleep(10);
		confirmPassengersView.click();
		cabinClass.click();
		sleep(10);
		bussinesClass.click();
		submit();
	}

	//Two scenary Search fligts in class economy, one passenger 
	public void searchOneWay(String origin, String destination, String depatureYear, String departureMonth,
			String departureDay, String[] passengers) {
		
		Calendar calendar = GregorianCalendar.getInstance();
		if (Integer.valueOf(depatureYear) < calendar.get(Calendar.YEAR)) {
			throw new IllegalStateException("Use a valid date in the future");
		}
		if (Integer.valueOf(depatureYear) == calendar.get(Calendar.YEAR)
				&& Integer.valueOf(departureMonth) < calendar.get(Calendar.MONTH)) {
			throw new IllegalStateException("Use a valid date in the future");
		}
		if (Integer.valueOf(depatureYear) == calendar.get(Calendar.YEAR)
				&& Integer.valueOf(departureMonth) == calendar.get(Calendar.MONTH)
				&& Integer.valueOf(departureDay) < calendar.get(Calendar.DAY_OF_MONTH)) {
			throw new IllegalStateException("Use a valid date in the future");
		}

		oneWay.click();
		originInput.sendKeys(origin);
		sleep(5);
		destinationInput.sendKeys(destination);
		sleep(5);
		WebElement nextMonthButton = HomePageTest.driver
				.findElement(By.xpath("//*[@id='calendar']/header/div[2]/button[2]"));
		List<WebElement> date = HomePageTest.driver
				.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
		sleep(1);
		boolean clicked = true;
		while (clicked) {
			if (date.size() == 0) {
				nextMonthButton.click();
				sleep(1);
				date = HomePageTest.driver
						.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
			} else {
				try {
					date.get(0).click();
					clicked = false;
				} catch (ElementNotVisibleException e) {
					nextMonthButton.click();
					sleep(1);
					date = HomePageTest.driver
							.findElements(By.id("calendar--" + depatureYear + departureMonth + departureDay));
				}
			}
		}
		sleep(2);
		passengersView.click();
		sleep(1);

		WebElement passengersQuantityView = HomePageTest.driver
				.findElement(By.xpath("//label[@for='tnr__itp__" + passengers.length + "']"));
		passengersQuantityView.click();
		sleep(1);
		for (int i = 0; i < passengers.length; i++) {
			String passenger = passengers[i];
			int index = i + 1;
			Select select = new Select(HomePageTest.driver.findElement(By.id("pax__" + index)));
			select.selectByVisibleText(passenger);
			sleep(1);
		}
		sleep(3);
		confirmPassengersView.click();
		cabinClass.click();
		sleep(2);
		mostEconomyClass.click();
		submit();
	}

	public FindFlightPage submit() {
		searchButtton.submit();
		return PageFactory.initElements(HomePageTest.driver, FindFlightPage.class);
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void resultMatch(String origen) {
		originInput.click();

	}

}
