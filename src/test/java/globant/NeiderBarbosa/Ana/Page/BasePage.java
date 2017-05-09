package globant.NeiderBarbosa.Ana.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public WebDriver driver;
	
	private WebElement webElement;
	
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> handlerList(WebElement webElement , String selector){
		List<WebElement> elements =	webElement.findElements(By.xpath(selector));		
		return elements;
	}
	public List<WebElement> handlerListByClass(WebElement webElement , String selector){
		List<WebElement> elements =	webElement.findElements(By.className(selector));		
		return elements;
	}
	public List<WebElement> handlerListByTag(WebElement webElement , String selector){
		List<WebElement> elements =	webElement.findElements(By.tagName(selector));		
		return elements;
	}
	public void sendText(WebElement origin, String data ){
		webElement = origin;
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(data);
	}
	
	public void handlerListForTowElements(String selector , String selectorFristElement , WebElement moduleOrigin){
		List<WebElement> elements =	moduleOrigin.findElements(By.xpath(selector));
		elements.add(0, moduleOrigin.findElement(By.xpath(selectorFristElement)));
		elements.get(0).click();
	}
	
	public Select  sendSelect(WebElement webElement) {
		Select Select = new Select(webElement);
		return Select;
	}		
}