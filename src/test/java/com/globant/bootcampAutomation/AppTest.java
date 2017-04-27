package com.globant.bootcampAutomation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    int num1 = 3; int num2 = 5; int num3 = 8; int num4 = 16;
       @org.testng.annotations.Test
       public void sumTest() {
           assertEquals(13,num2 + num3);
       }

       @org.testng.annotations.Test
       public void subTest() {
           assertEquals(2,num2 - num1);
       }

       @org.testng.annotations.Test
       public void timesTest() {
           assertEquals(15, num1 * num2);
       }

       @org.testng.annotations.Test
       public void divTest() {
           assertEquals(2,num4 / num3);
       }

       @org.testng.annotations.Test
       public void maxTest() {
           assertEquals(15,num2 + num4 - num1 * 2);
       }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */


    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
