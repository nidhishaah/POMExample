package org.example.selenium.loginpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginPage {

    public static void main(String[] args) {
        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
     //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java interview book");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.linkText("Elements of Programming Interviews in Java: The Insiders' Guide")).click();

        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.linkText("Go to Cart")).click();



        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,400)");
        // driver.findElement(By.xpath("*//span/span[@class='a-button-text']")).click();
        driver.findElement(By.id("a-autoid-1-announce")).click();
        driver.findElement(By.id("quantity_2")).click();
        jse.executeScript("scroll(0,-400)");
        driver.findElement(By.name("proceedToRetailCheckout")).click();

        driver.findElement(By.id("ap_email")).sendKeys("nidhiguj.nrg@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("abcd1234");
        driver.findElement(By.id("signInSubmit")).click();
    }
}
