package globant.NeiderBarbosa.Ana.Page;




import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;


public class FlightReservationPage extends BasePage {
	
	
	
	@FindBy(xpath = "//a[@class='btn-numset-more m_addChildButton']") private WebElement addMorePerson;
	@FindBy(id= "Members3_ticket") private WebElement addPerson1;
	@FindBy(id= "Members2_ticket") private WebElement addPerson11;
	@FindBy(id= "Members4_ticket") private WebElement addPerson15;
	@FindBy(id= "Members1_ticket") private WebElement addPerson16;
	@FindBy(id= "calendar-wrap") private WebElement calendarWrap;
	@FindBy(id= "module-calendar") private WebElement moduleCalendar;
	@FindBy(id= "wayToDateTicket") private WebElement dateIncio;
	@FindBy(id= "ArrApoText") private WebElement destiny;		
	@FindBy(id= "DepApoText") private WebElement origin;
	@FindBy(xpath = "//div[@class='module-box airport-select cf m_departureAirport']") 	private WebElement moduleOrigin;
	@FindBy(xpath = "//div[@class='module-box airport-select cf m_arrivalAirport']")    private WebElement moduleDestiny;
	@FindBy(xpath = "//li[@class='next']") 	private WebElement nextMonth;
	
	private String locateMonth = "//p[@class='month']" ;
	private String locaterAutocomplete = "//ul[@class='result-list']" ;	 
	private String locaterListAutocompleteOriginOrDestinyFirstElement =  "//li[@class='d_listItem listItem d_active']" ;
	private String locaterListAutocompleteOriginOrDestiny =  "//li[@class='d_listItem listItem']" ;
	private String locaterTableCalendar = "tbl-calendar";
	
	private int numberCalendarBox = 0;
	
	String[] monthCalendar = new String[13];
	String[] classDayCalendar = new String[35];
	String[] dayCalendar = new String[35];
	int[] yearCalendar  = new int[13];
	int[] monthCalendarNumber = new int [13];
	
	List<WebElement> days ;
    
	//setup methods
	
	public FlightReservationPage(WebDriver driver) {
		super(driver);
	}
	public SelectFlightPage SubmitPage(){
		return PageFactory.initElements(driver, SelectFlightPage.class);
		
	}
	
	//select methods
	
	public boolean opcion (WebElement webelement , String person){
		if(sendSelect(webelement).getOptions().size() < Integer.parseInt(person)){
			return false;
		}else{
			sendSelect(webelement).selectByValue(person);
			return true;
		}
	}

	public int transVariable(String list , int pocision){
		String[]split = list.split(" ");
		return Integer.parseInt(split[pocision]);
	}
	public int arrayToMonth(String month){
		if (month.equals("May"))
			return 5;
		if(month.equals("June"))
			return 6;
		if(month.equals("July"))
			return 7;
		if(month.equals("August"))
			return 8;
		if (month.equals("September"))
			return 9;
		if(month.equals("October"))
			return 10;
		if(month.equals("November" ))
			return 11;
		if(month.equals("December"))
			return 12;			
		if (month.equals("January"))
			return 1;
		if(month.equals("February"))
			return  2;
		if(month.equals("March" ))
			return  3;
		if(month.equals("April"))
			return  4;
		return 0;		
	}	
	public boolean verifyMonth(int userMonth){
		List<WebElement> year =handlerListByClass(calendarWrap, locaterTableCalendar);
		String element =  year.get(0).getText();
		int monthNumber = arrayToMonth(element) ;
		if ( userMonth < monthNumber)
			return false;
		else
			return true;		
	}
	public boolean verifyYear(int userYear){
		List<WebElement> year =handlerListByClass(calendarWrap, locaterTableCalendar);
		String element =  year.get(0).getText();
		if ( userYear < transVariable(element, 1))
			return false;
		else
			return true;		
	}
	public boolean verifyYearNext(int userYear){
		List<WebElement> year =handlerListByClass(calendarWrap, locaterTableCalendar);
		String element =  year.get(0).getText();
		if ( userYear == transVariable(element, 1))
			return true;
		else
			return false;		
	}
	
	public boolean verifyMonthNext(int userMonth , int pocision){
		List<WebElement> year =handlerListByClass(calendarWrap, locaterTableCalendar);
		String element =  year.get(pocision).getText();
		if ( userMonth == transVariable(element, 0)){
			List<WebElement> month =handlerListByClass(calendarWrap, locaterTableCalendar);
			List<WebElement> weeks =handlerListByTag(month.get(numberCalendarBox), "tr");
			List<WebElement> day   =handlerListByTag(weeks.get(1), "td");
			day.addAll(handlerListByTag(weeks.get(2), "td"));
			day.addAll(handlerListByTag(weeks.get(3), "td"));
			day.addAll(handlerListByTag(weeks.get(4), "td"));
			day.addAll(handlerListByTag(weeks.get(5), "td"));	
			for(int i = 0;i<35;i++){
				dayCalendar[i] = day.get(i).getText();
				classDayCalendar[i] = day.get(i).getAttribute("Class");
			}
			days = day;
			return true;
		}else
			return false;
	}
	
	public boolean validateDay(int day){
		int aux = 0;
		for(int i = 0 ;true;i++){
			if (dayCalendar[i].equals(""))
				dayCalendar[i] = "0";
			if (Integer.parseInt(dayCalendar[i]) == day){
				if( classDayCalendar[i].equals("d_calEmpty")){
					return false;
				}else{
					if( classDayCalendar[i].equals("d_calDisable")){
						return false;
					}else{
						aux = i;
					}
				}
				days.get(aux).click();
				return true;	
			}else{
				return false;
			}
		}
	}
	
	// Input methods
	
	public boolean person(int typePerson , String numberPerson){
		switch (typePerson) {
		case 1:
			return opcion( addPerson1 , numberPerson);
		case 2:
			return opcion( addPerson11 , numberPerson);
		case 3:
			return opcion( addPerson15 , numberPerson);
		case 4:
			return opcion( addPerson16 , numberPerson);	
		}
		return false;
	}
    public boolean genereateDates ( int day , int month , int year){
		boolean aux = false;
    	dateIncio.click();
		if (verifyYear(year) == false)
			aux =  verifyYear(year);
			else
				if (verifyMonth(month)== false)
					aux = verifyMonth(month);
    				else{
						int cont= 0;
						do{
						if( verifyMonthNext(month , 0) == true){
							if(verifyYearNext(year)==true){
								aux = true;
							}else{
								if( verifyMonthNext(month , 1) == true){
									if(verifyYearNext(year)==true){
										aux = true;
									}else{
										if( verifyMonthNext(month , 2) == true){
											if(verifyYearNext(year)==true){
												aux = true;
											}
										}
									}
								}
							}
						}
						nextMonth.click();
						cont++;
						}while(cont <= 3);
					}
					if (aux = true){
						if (validateDay(day)==false);
						aux = false;
					}
			return aux;	
	}
	public boolean selectOrigin (String threeFirsLetter)  {
		sendText(origin,  threeFirsLetter);
		moduleOrigin.findElement(By.xpath(locaterAutocomplete));
		handlerListForTowElements(locaterListAutocompleteOriginOrDestiny ,locaterListAutocompleteOriginOrDestinyFirstElement ,moduleOrigin);
		return true;
	}	
	public boolean selectDestiny (String threeFirsLetter)  {
		//addMorePerson.click();
		sendText(destiny,  threeFirsLetter);
		moduleDestiny.findElement(By.xpath(locaterAutocomplete));
		handlerListForTowElements(locaterListAutocompleteOriginOrDestiny ,locaterListAutocompleteOriginOrDestinyFirstElement ,moduleDestiny);
		return true;
	}

}



