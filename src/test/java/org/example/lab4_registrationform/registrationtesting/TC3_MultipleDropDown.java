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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC3_MultipleDropDown {
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
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl  + "\\src\\test\\resources\\RegistrationForm.html");
        System.out.println("Performing TestCase 3");
    }

    @Test(groups = { "group1"}, priority = 3)
    public void multipleDropDownForHobbies() throws InterruptedException{


        /*-------- Selecting hobbies option | Multiple DropDown --- */
        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect2"));

        /* Create an object of Select class and pass the dropdown of type WebElement as an argument. */
        Select multiplechoicelist = new Select(dropdown);
        int totalNoOfDropdown = multiplechoicelist.getOptions().size();
        System.out.println("Total Number of Dropdown:" + totalNoOfDropdown);
        // Verify total number of dropdowns
        Assert.assertEquals(totalNoOfDropdown, 5, "Verified total number of dropdowns ");

        // Verify that dropdown allows the multiple-choice list or not.
        if(multiplechoicelist.isMultiple())
        {
            //Selecting option as 'Reading'-- ByValue
            multiplechoicelist.selectByValue("Reading");
            //Selecting the option as 'Singing'-- ByValue
            multiplechoicelist.selectByValue("Singing");
            // Selecting the option Swimming by visible
            multiplechoicelist.selectByVisibleText("Swimming");
            Thread.sleep(10000);


            // Verify that the number of choices in the list selected.

            if(multiplechoicelist.getAllSelectedOptions().size() == 3)
            {
                System.out.println("3 options have been chosen:");
            }
            else {
                System.out.println("Code not worked");
            }

            /* Create a List. For this, create an object of ArrayList class by using the reference of List interface. */
            List<String> expectedSelection = new ArrayList<String>();

            // Call add() method of List to add expected elements for selection.
            expectedSelection.add("Reading");
            expectedSelection.add("Singing");
            expectedSelection.add("Swimming");

            /* Iterating WebElement by using the advanced for loop to retrieve the actually selected elements and then add selected elements in the list using add() method. */
            List<String> actualSelection = new ArrayList<String>();
            for(WebElement element : multiplechoicelist.getAllSelectedOptions())
            {
                actualSelection.add(element.getText()); /* Here, getText() method of WebElement class has been used to add the text label of all the options in the list */
            }
            /* Now compare actualSelection with expectedSelection by using containsAll() method to check that correct options are selected in the list. */


            if(actualSelection.containsAll(expectedSelection))
            {
                System.out.println(actualSelection);
            }

        } // end main if
        else {
            System.out.println("Dropdown does not allow multiple-choice");
        }
    }

    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }

}
