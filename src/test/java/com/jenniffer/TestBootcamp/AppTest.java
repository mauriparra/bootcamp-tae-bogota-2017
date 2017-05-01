package com.jenniffer.TestBootcamp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest{
	@Test
	  public void testAbsolute(){
	  	int result = Math.abs(-14);
	  	Assert.assertEquals(result,14);
	  	Assert.assertEquals(Math.abs(0), 0);
	  	Assert.assertEquals(Math.abs(45.9756), 49);
	  	Assert.assertEquals(Math.abs(2/2), 1);
	  }

	  @Test
	  public void testMaxValue1(){
			Assert.assertEquals(Math.max(245,564), 564);
		}

	  @Test
	  public void testFloor() {
			double result = Math.floor(15.21);
			int operator = Math.floorDiv(25, 5);
			Assert.assertEquals(result, 15);
			Assert.assertEquals(operator, 5);
		}

	  @Test
	  public void testSqrt() {
			Assert.assertEquals(Math.sqrt(25.5), 5.0);
		}

	  @Test
	  public void testPow() {
			double operato1 = 25.5;
			double operator2 = 15.21;
			Assert.assertEquals(Math.pow(operato1, operator2),2.47);
		}

	  @Test
	  public void testCos() {
			double angulo = Math.cos(90.0);
			double coseno0 = Math.cos(0);
			Assert.assertEquals(angulo, -0.44807);
			Assert.assertEquals(coseno0, 1);
	  }
}
