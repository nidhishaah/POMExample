package org.example.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class lab3 {

    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();

        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl+"\\src\\main\\java\\htmlresources\\form.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        WebElement txtone = driver.findElement(By.id("info"));
        System.out.println("Title: " + txtone);
        System.out.println("Output of Node Button 1 = " + driver.findElement(By.id("btn1")).getText());

        WebElement fnamefield = driver.findElement(By.name("fname"));
        WebElement lnamefield = driver.findElement(By.name("lname"));
        WebElement usernamefield= driver.findElement(By.id("username"));
        WebElement emailfield= driver.findElement(By.cssSelector("input[type='email']"));
        WebElement addressfield = driver.findElement(By.id("address"));
        WebElement addressfield2 = driver.findElement(By.id("address2"));

        // Enter something to search for
        fnamefield.sendKeys("Adam");
        lnamefield.sendKeys("fink");
        usernamefield.sendKeys("adam123");
        emailfield.sendKeys("adam123@mail.com");
        addressfield.sendKeys("25-25 102st nyc, NY, 1102");
        addressfield2.sendKeys("suit 502");

        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,1500)");

        //--------Selecting the first checkbox-----
        WebElement CheckboxOne =  driver.findElement(By.xpath("//label[text()='Shipping address is the same as my billing address']"));
        //------Selecting the second checkbox using XPath and value attribute----
        WebElement CheckboxTwo =  driver.findElement(By.xpath("//input[@value='save']"));

        Boolean statusCheckone = CheckboxOne.isSelected();
        Boolean statusCheckTwo = CheckboxTwo.isSelected();

        // use an if condition to check if boolean returned false
// If false then it was not selected click and select the checkbox
        if (statusCheckone == false) {
            CheckboxOne.click();
            System.out.println("Test has selected Selenium checkbox");
        }
        else {
            System.out.println("checkbox was selected on default");
        }

        // Repeat the process for checkbox two
        if (statusCheckTwo == false) {
            CheckboxTwo.click();
            System.out.println("Test has selected Rest api checkbox");
        } else {
            System.out.println("Rest Api checkbox was selected on default");
        }

        // selection first radiobox for payment methods --> by dynamically
        int a = driver.findElements(By.xpath("//input [@name='paymentMethod']")).size();
        System.out.println(a);
//        for(int i=1;i<=a;i++)
//        {

       // JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,2000)");
        Thread.sleep(2000);
            WebElement RadioBOne = driver.findElements(By.xpath("//input[@name='paymentMethod']")).get(3);
            Boolean statusRadioOne = RadioBOne.isSelected();
            if (statusRadioOne == false) {
                driver.findElements(By.xpath("//input[@name='paymentMethod']")).get(3).click();
                System.out.println("Test has selected Payment method Crpto Radio Box");
            }
            else {
                System.out.println(" Radio Box was selected on default");
            }

//        }

        //selection second radiobox for crypto option --> by customized path locator
        WebElement RadioBTwo = driver.findElement(By.xpath("//input[@value='BitCoin']"));
        Boolean statusRadioTwo = RadioBTwo.isSelected();

        // Repeat the process for Radio box Two one
        if (statusRadioTwo == false) {
            RadioBTwo.click();
            System.out.println("Test has selected BitCoin RadioBox");
        } else {
            System.out.println("BitCoin RadioBox was selected on default");
        }


        // Check if Save button is displayed on the WebPage
        WebElement saveButton = driver.findElement(By.id("demo"));

        Boolean checkSaveIsDisplayed = saveButton.isDisplayed();
        if (checkSaveIsDisplayed == true) {
            System.out.println("save button is displayed");
        }

        // Check if Save button is not enabled on the WebPage

        Boolean checkSaveIsEnabled = saveButton.isEnabled();

        if (checkSaveIsEnabled == false) {
            System.out.println("save button is not enabled");
        }

        Thread.sleep(6000);
        //  web element by using the "xpath" attribute
        driver.findElement(By.cssSelector("input[type=submit]")).submit();

    }
}
