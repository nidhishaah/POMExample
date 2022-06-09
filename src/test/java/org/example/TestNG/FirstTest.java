package org.example.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstTest {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite(groups = {"group1"})
    public void setUp()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        htmlReporter =
                new ExtentHtmlReporter("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\MyOwnReport.html");
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

    @Test(priority = 3,groups = {"group1"}) // Second Highest Priority
    public void a_test() {

        test = extent.createTest("Test Case 1", "PASSED test case");
        System.out.println("Test Case A");
    }

    @Test(priority = 2,groups = {"group1"}) // Lowest Priority
    public void c_test() {

        test = extent.createTest("Test Case 2", "PASSED test case");

        System.out.println("This method has serious bug");
        System.out.println("Test Case C");
    }

    @Test(priority = 1,groups = {"group1"}) // Highest Priority
    public void b_test() {

        test = extent.createTest("Test Case 3", "PASSED test case");

        System.out.println("Test Case B");
    }


    @AfterTest(groups={"group1"})
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
}
