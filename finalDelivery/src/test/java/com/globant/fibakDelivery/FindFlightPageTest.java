package com.globant.fibakDelivery;

import org.testng.annotations.Test;

import com.globant.finalDelivery.FindFlightPage;

public class FindFlightPageTest {

	public FindFlightPage findlight;
	
  @Test
  public void chooseFligth() {
	  findlight.changePassenger(new String[]{FindFlightPage.AFE_OPTIONS[1]});
  }
}
