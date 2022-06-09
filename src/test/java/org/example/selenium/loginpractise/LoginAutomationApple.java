package org.example.selenium.loginpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAutomationApple {
    public static void main(String[] args) {

        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://apple.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shopping Bag")));

        //$x("*//li[@class='ac-gn-item ac-gn-bag ac-gn-bag-small']/div/a")
        driver.findElement(By.linkText("Shopping Bag")).click();
        //  driver.findElement(By.xpath("*//li[@id='ac-gn-bag']/div/a")).click();

        //Wait until element show up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));

        driver.findElement(By.linkText("Sign in")).click();
        //driver.findElement(By.xpath("*//li[@class='ac-gn-bagview-nav-item ac-gn-bagview-nav-item-signIn']/a")).click();

        //Switch to inner frame
        driver.switchTo().frame(driver.findElement(By.xpath("*//div/iframe[@id='aid-auth-widget-iFrame']")));

        //Wait until login text field loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_name_text_field")));

        //     $x("//input[@id='account_name_text_field']")
        driver.findElement(By.id("account_name_text_field")).sendKeys("test@gmail.com");


        driver.findElement(By.id("sign-in")).click();


        //Wait until element show up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_text_field")));

        driver.findElement(By.id("password_text_field")).sendKeys("password");

        //Wait until element show up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-in")));
        //driver.findElement(By.xpath("*//button[@id='sign-in']")).click();
         driver.findElement(By.id("sign-in")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertInfo")));
        String actual = driver.findElement(By.id("alertInfo")).getText();

        String expected = "This Apple ID has been locked for security reasons.";

        System.out.println(actual.equals(expected));

        driver.findElement(By.xpath("*//div/button[starts-with(@id,'unlock-account')]")).click();

        // driver.findElement(By.xpath("//input[@id='account_name_text_field']")).sendKeys("test@gmail.com");
      //  driver.close();
    }
}
