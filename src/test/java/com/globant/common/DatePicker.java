/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.common;

import org.openqa.selenium.WebElement;

/**
 * Class to define my custom datepicker
 * @author fabian.acero
 */
public class DatePicker {
    
    WebElement element;
    String value;

    public DatePicker(WebElement element, String value) {
        this.element = element;
        this.value = value;
    }

    public WebElement getElement() {
        return element;
    }

    public String getValue() {
        return value;
    }    
}
