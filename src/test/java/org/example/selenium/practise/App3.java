package org.example.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App3 {
    public static void main(String[] args) throws InterruptedException {

        //Chrome Driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.apple.com");

//        WebElement webElement = driver.findElement(By.linkText("Learn more"));
//        webElement.click();
       // System.out.println(webElement.getText());


//        driver.findElement(By.xpath("//*[@id=\"ac-gn-bag\"]/div/a")).click();
//
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id='ac-gn-bagview-content']/nav/ul/li[2]/a")).click();
//    Thread.sleep(5000);
       // System.out.println(driver.findElement(By.xpath("//input[@id='account_name_text_field']")).getText());
                //sendKeys("nidhi.shaah@gmail.com");
        driver.navigate().to("https://appleid.apple.com/account");
        Thread.sleep(3000);
      //  driver.findElement(By.xpath("//*[@id='create-link']")).click();
      //
        //  driver.findElement(By.className("generic-input-field")).sendKeys("Nidhi");
        driver.findElement(By.xpath("*//div/span[text()='First name']/preceding-sibling::input")).sendKeys("Nidhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("*//div/span[text()='Last name']/preceding-sibling::input")).sendKeys("Shah");


        Thread.sleep(10000);
        driver.quit();

    }


}
