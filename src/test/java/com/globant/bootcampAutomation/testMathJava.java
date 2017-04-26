package com.globant.bootcampAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testMathJava {
    int num1 = 5, num2 = 4, num4 = 25, num5 = -2;
    double num3 = 2.5;
    String word = "hola";

	@Test (description = "Test for Java Math library add success",priority = 0)
	public void testAddSuccess(){
		Assert.assertEquals(9, num1 + num2);
	}

	@Test (description = "Test for Java Math library add fail ", priority = 1)
	public void testAddWrong(){
		Assert.assertEquals(9, num1 + num3);
	}

    @Test(description = "Test for Java Math Library modulus success",priority = 4)
    public void testModSuccess(){
	    Assert.assertEquals(1, num1 % num2);
    }

    @Test(description = "Test for Java Math Library modulus fail",priority = 5)
    public void testModFail(){
        Assert.assertEquals("a", num1 % num2);
    }

    @Test(description = "Test for Java Math Library division success",priority = 3)
    public void testDivSuccess(){
        Assert.assertEquals(2.0, num1 / num3);
    }

    @Test(description = "Test for Java Math Library division fail",enabled = false, priority = 4)
    public void testDivFail(){
        Assert.assertEquals(2.0, num1 / 0);
    }

    @Test(description = "Test for Java Math Library square root success",priority = 6)
    public void testSquareRootSuccess(){
        Assert.assertEquals(5.0, Math.sqrt(num4));
    }

    @Test(description = "Test for Java Math Library square root fail", priority = 7)
    public void testSquareRootFail(){
        Assert.assertEquals(5.0, Math.sqrt(num1));
    }

    @Test(description = "Test for Java Math Library pow function success", priority = 6)
    public void testPowSuccess(){
        Assert.assertEquals(625.0, Math.pow(num1, num2));
    }

    @Test(description = "Test for Java Math Library pow function fail", priority = 7)
    public void testPowFail(){
        Assert.assertEquals(625.0, Math.pow(num1, num4));
    }

    @Test(description = "Test for Java Math Library max function success", priority = 5)
    public void testMaxSuccess(){
        Assert.assertEquals(5, Math.max(num1, num2));
    }

    @Test(description = "Test for Java Math Library max function fail", priority = 8)
    public void testMaxFail(){
        Assert.assertEquals(625.0, Math.max(num4, num5));
    }

}
