package org.example.lab4_registrationform.registrationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_invalidEmail {
    private WebDriver driver;
    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver","C://Drivers//chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() {
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl  + "\\src\\test\\resources\\RegistrationForm.html");
        System.out.println("Performing TestCase 4");
    }

    // Registration without providing Contact number field
    @Test(groups = { "group1"}, priority = 4)
    public void invalidEmailTest() throws InterruptedException
    {
        try{

            // firstnmae
            WebElement f_name = driver.findElement(By.name("first_name"));
            f_name.sendKeys("Abcdef");
            // Last_name
            WebElement l_name = driver.findElement(By.name("last_name"));
            l_name.sendKeys("xyz");

            WebElement U_name = driver.findElement(By.name("user_name"));
            U_name.sendKeys("user1234");

            WebElement pass = driver.findElement(By.name("user_password"));
            pass.sendKeys("password@123#");

            WebElement confPass = driver.findElement(By.name("confirm_password"));
            confPass.sendKeys("password@123#");

            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("myemail");

            String expectedErrorMsg = "Please enter a valid Email Address";
            WebElement exp = driver.findElement(By.cssSelector("small[data-bv-validator=emailAddress]"));
            String actualErrorMsg = exp.getText();
            Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

            WebElement contact_no = driver.findElement(By.name("contact_no"));
            contact_no.sendKeys("256987411255");

            WebElement genderclick =  driver.findElement(By.id("inlineRadioMale"));
            genderclick.click();
            Assert.assertEquals(true, genderclick.isSelected()); /*Verifies that the radio	 button is selected after action */

            /* --------- selecting department option ------ */
            WebElement dep_dropdown = driver.findElement(By.name("department"));
            /* Create an object of Select class and pass the dep-dropdown of type WebElement as an argument. */
            Select select_dropdown_single = new Select(dep_dropdown);
            select_dropdown_single.selectByIndex(3);
            String selectedText = select_dropdown_single.getFirstSelectedOption().getText();
            Assert.assertEquals(selectedText, "Accounting Office");


            /*-------- Selecting hobbies option --- */
            WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect2"));

            /* Create an object of Select class and pass the dropdown of type WebElement as an argument. */
            Select multiplechoicelist = new Select(dropdown);
            multiplechoicelist.selectByValue("Singing");
            String selectedTextHobbies =  multiplechoicelist.getFirstSelectedOption().getText();
            Assert.assertEquals(selectedTextHobbies, "Singing");

            WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'btn btn-warning')]"));

            /* ---------   Validate, Submit button should be disable ------- */
            Boolean checkSaveIsDisplayed = signUp.isDisplayed();
            Assert.assertTrue( true == checkSaveIsDisplayed);
            Thread.sleep(10000);
        }
        catch(NoSuchElementException nsee){
            System.out.println(nsee.toString());
        }
    }

    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }

}
