package com.globant.bootcampAutomation;

import org.apache.xalan.xsltc.dom.SimpleResultTreeImpl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.border.EmptyBorder;
import java.util.logging.Logger;

/**
 * Created by carrio1 on 5/2/17.
 */
public class Page1 {

    WebDriver driver;

    public Page1(WebDriver driver) {
        this.driver = driver;

    }

    public static final String PAGE_URL = "http://www.turkishairlines.com/en-us";

    @FindBy(id = "from")
    WebElement from;

    @FindBy(id = "to")
    WebElement to;

    @FindBy(id = "godate")
    WebElement goDate;

    @FindBy(how = How.XPATH,using = "//*[@id=\"calendar-100000000\"]/div[3]/table/tbody/tr[4]/td[4]")
    WebElement fromDateCalendar;

    @FindBy(how = How.XPATH,using = "//*[@id=\"calendar-100000003\"]/div[3]/table/tbody/tr[4]/td[4]")
    WebElement toDateCalendar;

    @FindBy(how = How.XPATH,using = "//*[@id=\"idMatrixView\"]")
    WebElement goMatrixView;

    @FindBy(how = How.XPATH,using = "//*[@id=\"tdMatrix201705240000-201706220000\"]/div/span[1]/input")
    WebElement selectedFlight;

    @FindBy(how = How.XPATH,using = "//*[@id=\"cabine\"]")
    Select cabine;

    @FindBy(how = How.XPATH,using = "//*[@id=\"Main-Quick-Search-Ticket\"]/div[5]/button")
    WebElement submit;

    @FindBy(how = How.XPATH,using = "//*[@id=\"Main-Quick-Search-Ticket\"]/div[4]/ul/li[1]/span[2]/span[2]")
    WebElement adultsPlusCross;

    @FindBy(how = How.XPATH,using = "//*[@id=\"Main-Quick-Search-Ticket\"]/div[4]/ul/li[2]/span[2]/span[2]")
    WebElement childrenPlusCross;

    @FindBy(how = How.XPATH,using = "//*[@id=\"mainBody\"]/div[7]/ul/li")
    WebElement selectCity;

    @FindBy(how = How.XPATH,using = "//*[@id=\"mainBody\"]/div[8]/ul/li[2]")
    WebElement selectCityDestination;

    @FindBy(how = How.XPATH,using = "//*[@id=\"flow\"]/div/form/div[2]/div/button/span")
    WebElement continuePage2;

    @FindBy(how = How.XPATH,using = "//*[@id=\"idBtnSubmitSelectedDates\"]/button/span")
    WebElement contWithSelFlight;

    @FindBy(how = How.XPATH,using = "//*[@id=\"calendar-100000000\"]/div[3]/table/tbody/tr[1]/td[3]")
    WebElement pastDate;



    public void bookFlight(String fromCity, String toCity){

        new WebDriverWait(driver, 5);
        from.sendKeys(fromCity);
        selectCity.click();
        to.sendKeys(toCity);
        selectCityDestination.click();
        goDate.click();
        fromDateCalendar.click();
        toDateCalendar.click();
        adultsPlusCross.click();
        childrenPlusCross.click();
        submit.click();
        WebElement selectedFlight = (new WebDriverWait(driver, 35))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(" /html/frameset/frames")));
        driver.switchTo().frame(driver.findElement(By.xpath(" /html/frameset/frame")));
        contWithSelFlight.click();

    }

    public void maxAdults(String fromCity, String toCity){

        new WebDriverWait(driver, 5);
        from.sendKeys(fromCity);
        selectCity.click();
        to.sendKeys(toCity);
        selectCityDestination.click();
        goDate.click();
        fromDateCalendar.click();
        toDateCalendar.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        adultsPlusCross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();



    }

    public void pastDate(String fromCity, String toCity){

        new WebDriverWait(driver, 5);
        from.sendKeys(fromCity);
        selectCity.click();
        to.sendKeys(toCity);
        selectCityDestination.click();
        goDate.click();
        if (pastDate.isEnabled())
            pastDate.click();
        else driver.close();
    }
}
