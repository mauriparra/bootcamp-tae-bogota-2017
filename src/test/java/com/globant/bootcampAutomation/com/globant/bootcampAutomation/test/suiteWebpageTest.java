package com.globant.bootcampAutomation.com.globant.bootcampAutomation.test;

import com.globant.bootcampAutomation.com.globant.bootcampAutomation.pages.CreateUserPage;
import com.globant.bootcampAutomation.com.globant.bootcampAutomation.pages.ReturnCreateUserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class suiteWebpageTest {

    private WebDriver driver;


    private static String pageUrl = "https://secure.alkomprar.com/customer/account/create/";

    @BeforeMethod
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(this.pageUrl);
    }

    public CreateUserPage initCreate(){
        CreateUserPage createUser = PageFactory.initElements(driver, CreateUserPage.class);
        return createUser;
    }

    @Parameters({"firstname","lastname","email","region","city","password"})
    @Test(description = "Fill create user form with new user")
    public void testCreateUserFirstTimeSuccess(String firstname, String lastname, String email, String region, String city, String password) {
        ReturnCreateUserPage returnPage = initCreate().fillFormAlkomprar(firstname,lastname,email,region,city,password);
        Assert.assertEquals("http://www.alkomprar.com/gracias-registro-alkomprar", returnPage.currentUrl());
    }

    @Parameters({"firstname","lastname","email","region","city","password"})
    @Test(description = "Fill create user form with existent user")
    public void testCreateUserFail(String firstname, String lastname, String email, String region, String city, String password) {
        ReturnCreateUserPage returnPage = initCreate().fillFormAlkomprar(firstname,lastname,email,region,city,password);
        Assert.assertEquals("https://secure.alkomprar.com/customer/account/login/",returnPage.currentUrl());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
