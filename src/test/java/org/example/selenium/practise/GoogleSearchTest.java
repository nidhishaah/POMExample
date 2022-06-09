package org.example.selenium.practise;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchTest {
    WebDriver driver;
    public static List<WebElement> pics = new ArrayList<>();
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite(groups = {"group1"})
    public void setUpReport()
    {
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


    @BeforeClass(groups = {"group1"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver1.exe");
        // Initialize WebDriver
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @Test(priority = 1,groups = {"group1"},enabled = false)
    public void findGooglePictureTest() throws IOException {
        test = extent.createTest("findGooglePictureTest", "PASSED test case");
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("sunrise pictures"+ Keys.ENTER);
        driver.findElement(By.linkText("Images")).click();
        pics = driver.findElements(By.xpath("//a/div/img"));
        Assert.assertTrue(pics.size()>0);


//        driver.findElement(By.xpath("//img[@src='data:image/jpeg;base64,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']")).click();


        //-----Call take screenshot function-------------

//        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //screenshot copied from buffer is saved at the mentioned path.
//        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\src\\main\\resources\\pics\\Demoscreenshot01.png"));

    }


    @Test(priority = 1,dataProvider = "product-list")
    public void getPicturesScreenshotTest(String data) throws IOException {
        test = extent.createTest("findGooglePictureTest", "PASSED test case");
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys(data+ Keys.ENTER);
        driver.findElement(By.linkText("Images")).click();
        pics = driver.findElements(By.xpath("//a/div/img"));
        Assert.assertTrue(pics.size()>0);
      // test = extent.createTest("getPicturesScreenshotTest", "PASSED test case");
        WebElement webElement = pics.get(0);
        String attribute = webElement.getAttribute("src");
        Assert.assertNotNull(attribute);
        System.out.println(attribute);
        driver.get(attribute);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));

        //-----Call take screenshot function-------------

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //screenshot copied from buffer is saved at the mentioned path.
        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\test-output\\"+data+".png"));
        //extent.attachReporter((ExtentReporter) f);
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));

        test.addScreenCaptureFromPath(data+".png",data);
       // test.addScreenCaptureFromPath("src/test/resources/screenshots/"+data+".png");

    }
    @DataProvider(name = "product-list")
    public Object[][] vegetablesList() {
        //Using Object[][] return strings with values.
        String[][] veggies={{"cucumber"},{"Broccoli"},{"Walnut"}};
        return veggies;
    }

    @Test(priority = 1,groups = {"group1"},dataProvider = "product-list",enabled = false)
    public void findGooglePictureVeggiesTest(String data) throws IOException {
        test = extent.createTest("findGooglePictureTest", "PASSED test case");
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys(data+ Keys.ENTER);
        driver.findElement(By.linkText("Images")).click();
        pics = driver.findElements(By.xpath("//a/div/img"));
        Assert.assertTrue(pics.size()>0);


//        driver.findElement(By.xpath("//img[@src='data:image/jpeg;base64,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']")).click();


        //-----Call take screenshot function-------------

//        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //screenshot copied from buffer is saved at the mentioned path.
//        FileUtils.copyFile(f, new File("C:\\Users\\nidhi\\Documents\\ActivateIT\\Week 14-Selenium\\Selenium_ActivateIT\\src\\main\\resources\\pics\\Demoscreenshot01.png"));

    }

    @AfterTest(groups={"group1"})
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
}