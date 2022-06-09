package org.example.lab4_registrationform.registrationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TC2_FillFOrmData {
    private WebDriver driver;
    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver","C://Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() {
        // Configuring the system properties of chrome driver
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl + "\\src\\test\\resources\\RegistrationForm.html");
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

    @Test(groups = { "group1"}, priority = 2)
    public void fillFormData() throws InterruptedException{
        try{
            // firstnmae
            WebElement f_name = driver.findElement(By.name("first_name"));
            // Last_name
            WebElement l_name = driver.findElement(By.name("last_name"));
            WebElement U_name = driver.findElement(By.name("user_name"));
            WebElement pass = driver.findElement(By.name("user_password"));
            WebElement confPass = driver.findElement(By.name("confirm_password"));
            WebElement contact_no = driver.findElement(By.name("contact_no"));
            WebElement email = driver.findElement(By.name("email"));

            f_name.sendKeys("Abcdef");
            l_name.sendKeys("xyz");
            U_name.sendKeys("user1234");
            pass.sendKeys("password@123#");
            confPass.sendKeys("password@123#");
            email.sendKeys("myemail@hmail.com");
            contact_no.sendKeys("256987411255");

            WebElement genderclick =  driver.findElement(By.id("inlineRadioMale"));
            genderclick.click();
            Assert.assertEquals(true, genderclick.isSelected());
            //Verifies that the radio button is selected after action
            System.out.println("Male option is selected - Assert passed");

            // selecting department option
            WebElement dep_dropdown = driver.findElement(By.name("department"));
            /* Create an object of Select class and pass the dep-dropdown of type WebElement as an argument. */
            Select select_dropdown_single = new Select(dep_dropdown);
            select_dropdown_single.selectByIndex(3);
            String selectedText =  select_dropdown_single.getFirstSelectedOption().getText();
            Assert.assertEquals(selectedText, "Accounting Office");

            // Selecting hobbies option
            WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect2"));

            /* Create an object of Select class and pass the dropdown of type WebElement as an argument */
            Select multiplechoicelist = new Select(dropdown);
            multiplechoicelist.selectByValue("Singing");
            multiplechoicelist.selectByValue("Swimming");
            String selectedTextHobbies = multiplechoicelist.getFirstSelectedOption().getText();
            Assert.assertEquals(selectedTextHobbies, "Singing");
            Thread.sleep(10000);
            WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'btn btn-warning')]"));
            signUp.click();
            Thread.sleep(10000);
        }
        catch(NoSuchElementException nsee){
            System.out.println(nsee.toString());
        }
    }

    @AfterMethod
    public void afterMethod() {
       // driver.quit();
    }
}


