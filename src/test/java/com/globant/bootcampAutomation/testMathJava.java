package com.globant.bootcampAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testMathJava {
    int num1 = 5, num2 = 4, num4 = 25;
    double num3 = 2.5;
    String word = "hola";

	@Test (description = "Test for Java Math library add success")
	public void testAddSuccess(){
		Assert.assertEquals(9, num1 + num2);
	}

	@Test (description = "Test for Java Math library add fail ")
	public void testAddWrong(){
		Assert.assertEquals(9, num1 + num3);
	}

    @Test(description = "Test for Java Math Library modulus success")
    public void testModSuccess(){
	    Assert.assertEquals(1, num1 % num2);
    }

    @Test(description = "Test for Java Math Library modulus fail")
    public void testModFail(){
        Assert.assertEquals("a", num1 % num2);
    }

    @Test(description = "Test for Java Math Library division success")
    public void testDivSuccess(){
        Assert.assertEquals(2.0, num1 / num3);
    }

    @Test(description = "Test for Java Math Library division fail")
    public void testDivFail(){
        Assert.assertEquals(2.0, num1 / 0);
    }

    @Test(description = "Test for Java Math Library square root success")
    public void testSquareRootSuccess(){
        Assert.assertEquals(5.0, Math.sqrt(num4));
    }

    @Test(description = "Test for Java Math Library square root fail")
    public void testSquareRootFail(){
        Assert.assertEquals(5.0, Math.sqrt(num1));
    }

}
