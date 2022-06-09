package org.example.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab1 {

    public static void main(String[] args) throws InterruptedException {
        // Configuring the system properties of chrome driver
        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        //Navigating through a particular website
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl  + "\\src\\main\\java\\htmlresources\\form.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement txtone = driver.findElement(By.id("info"));

        System.out.println("Title: " + txtone);
        System.out.println("Output of Node Button 1 = " + driver.findElement(By.id("btn1")).getText());

        System.out.println("Output of Node Button 2 = " + driver.findElement(By.id("btn2")).getText());

        System.out.println("Output of Node P = " + driver.findElement(By.id("p1")).getText());
        // Find the text input element by different elements
        WebElement fnamefield = driver.findElement(By.name("fname"));
        WebElement lnamefield = driver.findElement(By.name("lname"));
        WebElement usernamefield = driver.findElement(By.id("username"));
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement addressfield = driver.findElement(By.id("address"));
        WebElement addressfield2 = driver.findElement(By.id("address2"));


        System.out.println("Attribute input one : " + lnamefield.getAttribute("class"));

        System.out.println("Attribute iput two : " + usernamefield.getAttribute("type"));

        System.out.println("Attribute input three : " + usernamefield.getAttribute("placeholder"));

        System.out.println("Attribute input three : " + emailfield.getAttribute("placeholder"));

        System.out.println("Attribute input four : " + addressfield.getAttribute("placeholder"));

        // Enter some data to input fields on form
        fnamefield.sendKeys("Adam");
        lnamefield.sendKeys("fink");
        usernamefield.sendKeys("adam123");
        emailfield.sendKeys("adam123@mail.com");
        addressfield.sendKeys("25-25 102st nyc, NY, 1102");
        addressfield2.sendKeys("suit 502");
        // In order to follow the test visually, included a 7-second pause here

        driver.findElement(By.id("same-address")).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,1500)");

    //    driver.findElement(By.xpath("//input[@id='save-info']")).click();

        //Selecting the first checkbox using XPath and text
     //   driver.findElement(By.xpath("//label[text()='Shipping address is the same as my billing address']")).click();
        Thread.sleep(2000);
        //Selecting the second checkbox using XPath and value attribute
        driver.findElement(By.xpath("//input[@value='save']")).click();

        int a = driver.findElements(By.xpath("//input [@name='paymentMethod']")).size();
        System.out.println(a);
//        for(int i=1;i<=a;i++)
//        {
// we will handle the radio buttons by using the index of a particular radio button.
 driver.findElements(By.xpath("//input[@name='paymentMethod']")).get(3).click();
//        }

        /*selection second radiobox for crypto option --> by customized path locator */
        driver.findElement(By.xpath("//input[@value='BitCoin']")).click();

        driver.findElement(By.cssSelector("input[type=submit]")).submit();
        //  driver.findElement(By.xpath("//input[@type='button']")).submit();

/**
 *         driver.findElement(By.xpath("//input[@value='BitCoin']")).click();
 *         driver.findElement(By.xpath("//*[@id=\"paypal\"]")).click();
 *         driver.findElement(By.xpath("/html/body/div/div[2]/form/input")).click();
 */
        Thread.sleep(7000);





    }

}
