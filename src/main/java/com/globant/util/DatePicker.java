package com.globant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openqa.selenium.WebElement;

/**
 * Class to define my custom datepicker
 * @author fabian.acero
 */
public class DatePicker {
    
    private WebElement element;
    private String value;
    private int year;
    private int month;
    private int day;

    public DatePicker(WebElement element, String value) {
        this.element = element;
        this.value = value;
        setDateValues();
    }

    public WebElement getElement() {
        return element;
    }

    public String getValue() {
        return value;
    }
    
    public int getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = Integer.parseInt(year);
	}

	public int getMonth() {
		return month;
	}

	private void setMonth(String month) {
		this.month = Integer.parseInt(month) - 1;
	}

	public int getDay() {
		return day;
	}

	private void setDay(String day) {
		this.day = Integer.parseInt(day);
	}

	/**
     * Sets all date values based on the matches format DD-MM-YYYY
     * @param date
     * @return String Array
     */
    private void setDateValues(){
    	
    	String[] dateValue = new String[3];
    	Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
    	Matcher matcher = pattern.matcher(value);
    	
    	if(matcher.find()){
    		dateValue = value.split("-");    		
    		setDay(dateValue[0]);
    		setMonth(dateValue[1]);
    		setYear(dateValue[2]);
    	}
    }
    
    /**
     * Gets the calendar title based on the param dates
     * @return String, the calendar title
     */
    public String getMonthName(){
    
    	String[] spMonths = {"Enero","Febrero","Marzo","Abril","Mayo", "Junio",
    			"Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    	
    	String monthTitle = spMonths[this.month];
    	monthTitle += " " + this.year;
    	
    	return monthTitle;
    }
    
}
