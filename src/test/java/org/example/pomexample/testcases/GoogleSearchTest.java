package org.example.pomexample.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.example.pomexample.library.SelectBrowser;
import org.example.pomexample.pages.GoogleImagesPage;
import org.example.pomexample.pages.GoogleSearchPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchTest {

    WebDriver driver;
    GoogleSearchPage googleSearchPage;
    GoogleImagesPage googleImagesPage;
    public static List<WebElement> pics=new ArrayList<>();
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeSuite
    public void setUpReport(){

            //create the HtmlReporter in that path by the name of  MyOwnReport.html
            //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
            htmlReporter =
                    new ExtentHtmlReporter("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\MyOwnReportGoogle.html");
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
    public void launchBrowser(){
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(priority = 1)
    public void searchProductOnGoogleTest(){
        test = extent.createTest("searchProductOnGoogleTest", "PASSED test case");
    googleSearchPage = new GoogleSearchPage(driver);
    googleSearchPage.inputIntoASearchTextField("sunrise photos");

    }


    @Test(priority = 2)
    public void getPicsFromGoogleTest() throws IOException {
        test = extent.createTest("getPicsFromGoogleTest", "PASSED test case");
        googleImagesPage = new GoogleImagesPage(driver);
        googleImagesPage.clickOnLinkImages();
        pics= googleImagesPage.getWebElement();
        Assert.assertTrue(pics.size() > 0);

        WebElement webElement = pics.get(0);
        String attribute = webElement.getAttribute("src");
        Assert.assertNotNull(attribute);
      //  System.out.println(attribute);
        driver.get(attribute);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));

        //-----Call take screenshot function-------------

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //screenshot copied from buffer is saved at the mentioned path.
        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\" +
        "Week 14-Selenium\\Selenium_ActivateIT\\src\\test\\resources\\screenshots\\sun1.png"));


    }

    @AfterTest(groups={"group1"})
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }

}
