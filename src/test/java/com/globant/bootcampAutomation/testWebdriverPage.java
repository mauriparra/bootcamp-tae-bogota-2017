package com.globant.bootcampAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class testWebdriverPage {
    private WebDriver driver;
    String firstname = "Test6", lastname = "Tester6", email = "test6@Tester.com", password = "bootcamp2017$";

    @BeforeSuite
    public void initDriver() throws Exception {
        System.out.println("You are testing in chrome");
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Create user form with new data")
    public void testCreateUserForm() {
        System.out.println("Create user in alkomprar");
        driver.get("https://secure.alkomprar.com/customer/account/create/");
        System.out.println("Enter data");
        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(email);
        Select dropdownState = new Select(driver.findElement(By.id("region_idx")));
        dropdownState.selectByValue("908");
        Select dropdownCity = new Select(driver.findElement(By.id("cityx")));
        dropdownCity.selectByValue("11001");
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("id_accept_terms")).click();
        driver.findElement(By.cssSelector("div.buttons-set.form-buttons .button")).click();
        System.out.println("submit");
        String result = new WebDriverWait(driver, 5).until(new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                return d.getCurrentUrl();
            }
        });
        Assert.assertEquals("http://www.alkomprar.com/gracias-registro-alkomprar",result);
        System.out.println("Yeah. We finish with a new account");
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}
