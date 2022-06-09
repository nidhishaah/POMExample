package org.example.selenium.slides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchApp {

    public static void main(String[] args) {
        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div/button[text()='Start']")).click();

        //No sync

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        WebElement webElement = driver.findElement((By.xpath("//div[@id='finish']/h4")));
        String expected = "Hello World!";

        System.out.println(webElement.isDisplayed());
        //System.out.println(webElement.getText().equals(expected));


    }
}