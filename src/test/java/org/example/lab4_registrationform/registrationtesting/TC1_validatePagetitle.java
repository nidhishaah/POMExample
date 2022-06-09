package org.example.lab4_registrationform.registrationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_validatePagetitle {
    private WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver" , "C://Drivers//chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() {
        // Configuring the system properties of chrome driver
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl  + "\\src\\test\\resources\\RegistrationForm.html");
        System.out.println("Performing TestCase 1");
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }


    /*   Validating the title of the web page, Title Page must be Registration   Form */
    @Test(groups = { "group1"}, priority = 1)
    public void verifyTitle(){
        Assert.assertEquals("Registration Form", driver.getTitle());
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
