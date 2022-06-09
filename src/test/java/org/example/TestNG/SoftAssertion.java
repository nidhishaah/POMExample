package org.example.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    @Test(groups={"group1"})
    public void softAssertionTest(){
        //---------Creating softAssert object-------
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Selenium", "Selenium", "1st Soft assert passed");
        System.out.println("First soft asssertion passed");
        softAssert.assertTrue("Selenium".equals("selenium"), "2nd Soft assert failed");
        System.out.println("Second soft assertion failed");
        softAssert.assertTrue("Testing".equals("testingggg"), "3rd soft assert failed");
        System.out.println("Third soft assertion failed");
        //-------Collates the assertion results and marks test as pass or fail---
        softAssert.assertAll();}

}
