package org.example.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab2 {
    public static void main(String[] args) throws InterruptedException {
//Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();

        //Navigating to the website
        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement name = driver.findElement(By.id("name"));
        name.click();

        name.sendKeys("Per Scholas |Get the skills you need to grow your career in tech ");

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("button"));
        button.click();

    }
}
