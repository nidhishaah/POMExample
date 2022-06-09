package org.example.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.apple.com");
        webDriver.manage().window().setSize(new Dimension(500,500));


        //Edge Driver
//        System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver2.exe");
//        WebDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("http://www.apple.com");

        //Firefox driver
//        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver1.exe");
//        WebDriver geckoDriver = new FirefoxDriver();
//        geckoDriver.get("http://www.apple.com");

        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
       // System.out.println(webDriver.getPageSource());
        webDriver.findElement(By.linkText("Learn more")).click();
        WebDriver.Navigation nav = webDriver.navigate();
        nav.to("http://www.google.com");
        nav.back();
        nav.forward();
        nav.refresh();

        //webDriver.navigate().back();
        //webDriver.navigate()/forward();


        Thread.sleep(5000);
        webDriver.quit();
    }
}
