package com.globant.bootcampAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by MauricioLeonardo on 4/26/2017.
 */
public class testMathClass {


    @Test (priority = 1,description = "This test will check for add feature on mathClass")
    public void testAddition(){
        int num1 = 2;
        int num2 = 3;
        Assert.assertEquals(5,num1+num2);
    }

    @Test (priority = 2,description = "This test will check for minus feature on mathClass")
    public void testSubtraction() {
        int num1 = 10;
        int num2 = 8;
        Assert.assertEquals(2, num1 - num2);

    }

    @Test (priority = 3,description = "This test will check for times feature on mathClass")
    public void testMultiplication() {
        int num1 = 5;
        int num2 = 2;
        Assert.assertEquals(10, num1 * num2);
    }

    @Test (priority = 4,description = "This test will check for random feature on mathClass")
    public void testRandom() {
        double num1 = Math.random();
        double num2 = Math.random();
        double num3 = Math.random();
        double num4 = Math.random();
        Assert.assertEquals(true, num1 != num2 && num2 != num3 && num3 != num4);
    }

    @Test (priority = 5,description = "This test will check for Pi feature on mathClass")
    public void testPi() {
        double num1 = Math.PI;
        double num2 = 3.141592653589793;
        Assert.assertEquals(num2, num1);
    }

    @Test (priority = 6,description = "This test will check for Max feature on mathClass")
    public void testMax() {
        int num1 = 10;
        int num2 = 5;
        Assert.assertEquals(10, Math.max(num1,num2));
    }

    @Test (priority = 7,description = "This test will check for Min feature on mathClass")
    public void testMin() {
        int num1 = 10;
        int num2 = 5;
        Assert.assertEquals(5, Math.min(num1,num2));
    }

    @Test (priority = 8,description = "This test will check for Abs feature on mathClass")
    public void testAbs() {
        int num1 = -10;
        int num2 = Math.abs(num1);
        Assert.assertEquals(10, num2);
    }

}
