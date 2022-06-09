package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoAssertions_Lab2 {
    String className = "HardAssertion";
    @BeforeClass
    public void beforeClass() {
    }

    @Test
    public void test_UsingHardAssertion() {
        Assert.assertTrue(true == true);
        Assert.assertEquals("HardAssertion", "HardAssertion");
        Assert.assertEquals(className, "HardAssertion");
        System.out.println("Successfully passed!");
        String str1 = "Hello";
        String str2 = "Hello";
        Assert.assertSame(str1, str2, "Contents are not Same");
        System.out.println("Test case one passed successfully");
        Assert.assertNotSame(str1, str2, "Contents are not same");
        System.out.println("Test case one passed successfully");
    }

    @Test
    public void compareNumeric()
    {
        Assert.assertTrue(5 > 2);
        System.out.println("5 is greater than 2");
        Assert.assertFalse(5 > 2); // Here, condition is true. So, test case will be marked as failed and the next statement will not be executed.
        System.out.println("5 is greater than 2");
        Assert.assertFalse("Selenium" == "Java", "Matched"); // Here, condition is false. So, test case will be passed by assertion.
    }


    @AfterClass
    public void afterClass() {
    }

}


