package com.globant.bootcampAutomation.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by MauricioLeonardo on 5/1/2017.
 */
public class BrowserFactory {

    static WebDriver driver;

    //This class is created to set the properties for each browser and to return the driver with the specified browser

    public static WebDriver startBrowser (String browserName, String url){

        if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
            driver = new ChromeDriver();

        }else if (browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

}
