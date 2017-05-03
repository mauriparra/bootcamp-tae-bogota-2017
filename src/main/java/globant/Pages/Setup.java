package globant.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browser, String url) {
		if (browser.equals("chrome")) {
			driver= new ChromeDriver();

		} else if (browser.equals("firefox")) {
			driver= new FirefoxDriver();

		}else{
			System.out.println("Not support for my desktop");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
		
	}

}
