package org.example.selenium.slides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
    public static void main(String[] args) {
        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        String fileUrl = System.getProperty("user.dir");
        driver.get(fileUrl  + "\\src\\main\\java\\htmlresources\\indextwo.html");
        driver.manage().window().maximize();
        // identify element
        WebElement inputElement = driver.findElement(By.name("firstname"));
        WebElement selectElement=driver.findElement(By.id("optionOne"));
        WebElement aElement = driver.findElement(By.id("redirect"));

        // get  attribute with getAttribute()
        System.out.println("attribute of input tag: " + inputElement.getAttribute("placeholder"));
        System.out.println("attribute of select tag : " + selectElement.getAttribute("value"));
        System.out.println("attribute of a tag : " + aElement.getAttribute("href"));
        driver.quit();
    }

}
