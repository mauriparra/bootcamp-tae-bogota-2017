package com.globant.bootcampAutomation.Helper;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import static com.globant.bootcampAutomation.Page1.PAGE_URL;


/**
 * Created by carrio1 on 5/8/17.
 */
public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver startBrowser(String browserName, String PAGE_URL) {

        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(PAGE_URL);

        return driver;

    }
}
