package org.example.pomexample2.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.example.pomexample2.library.SelectBrowser;
import org.example.pomexample2.pages.AppleMainPage;
import org.example.pomexample2.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppleTestCases {

    WebDriver driver;
    AppleMainPage appleMainPage;
    SignInPage signInPage;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeSuite
    public void setUpReport(){

        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        htmlReporter =
                new ExtentHtmlReporter("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\AppleReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DEKTOP-34GJ352");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Nidhi Shah");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Demo Report");
        htmlReporter.config().setReportName("My Google Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void setUpBrowser(){
        driver = SelectBrowser.StartBrowser("Chrome");

        driver.get("http://apple.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(priority = 1)
    public void clickOnBagTest() throws IOException {
        test = extent.createTest("clickOnBagTest", "PASSED test case");
        appleMainPage= new AppleMainPage(driver);
        appleMainPage.clickOnShoppingBag();
        appleMainPage.clickOnSignIn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //screenshot copied from buffer is saved at the mentioned path.
        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\Apple2.png"));
        test.addScreenCaptureFromPath("Apple2.png");
    }

    @Test(priority = 2)
    public void signInWithWrongCredentialsTest() throws IOException {
        test = extent.createTest("signInWithWrongCredentialsTest", "PASSED test case");
        signInPage = new SignInPage(driver);
        signInPage.switchFrames();
        signInPage.enterLogin("test123@gmail.com");
        signInPage.clickSignInButton();
        signInPage.enterPassword("abcd");
        signInPage.clickSignInButton();
        String error = signInPage.getErrorMessage();
        String expected = "This Apple ID has been locked for security reasons.";
        Assert.assertEquals(error,expected);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertInfo")));


        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //screenshot copied from buffer is saved at the mentioned path.
        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\Apple1.png"));
        test.addScreenCaptureFromPath("Apple1.png");

    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }




}
