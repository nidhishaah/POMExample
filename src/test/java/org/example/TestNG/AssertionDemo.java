package org.example.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AssertionDemo {
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite(groups = {"group1"})
    public void setUp()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        htmlReporter =
                new ExtentHtmlReporter("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\MyOwnReport1.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DEKTOP-34GJ352");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Nidhi Shah");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
    String className = "HardAssertion";
    @Test(groups={"group1"})
    public void test_UsingHardAssertion() {
        test = extent.createTest("Test Case 4", "PASSED test case");
        Assert.assertTrue(true == true);
        Assert.assertEquals("HardAssertion", "HardAssertion");
        Assert.assertEquals(className, "HardAssertion");
        System.out.println("Successfully passed!");
        String str1 = "Hello";
        String str2 = "Hello";
        Assert.assertSame(str1, str2, "Contents are not Same");
        System.out.println("Test case one passed successfully");
        Assert.assertNotSame(str1+"a", str2, "Contents are not same");
        System.out.println("Test case two passed successfully");
    }
    @Test(groups={"group1"})
    public void compareNumeric()
    {
        test = extent.createTest("Test Case 5", "PASSED test case");
        Assert.assertTrue(5 > 2);
        System.out.println("5 is greater than 2");
        Assert.assertFalse(5 < 2);
        // Here, condition is true. So, test case will be marked as failed and the next statement will not be executed.

        System.out.println("5 is greater than 2");
        Assert.assertFalse("Selenium" == "Java", "Matched"); // Here, condition is false. So, test case will be passed by assertion.
    }

    @AfterTest(groups={"group1"})
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }

}


