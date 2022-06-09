package org.example.selenium.practise;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
    public class ScreenshotDemo {
        public static void main(String[] args) throws  IOException {
            try {
                System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
                // Initialize WebDriver
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();            //always write wait code after this
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                /*for page load**/


                driver.get("http://perscholas.org");
           //-----Call take screenshot function-------------

           File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          //screenshot copied from buffer is saved at the mentioned path.
          FileUtils.copyFile(f, new File("C://Users//PSAdmin//Downloads//Demoscreenshot01.png"));
          driver.close();
		   }
           catch (Exception e)
           {
               System.out.println(e.getMessage());
                e.printStackTrace();
            }
    }
}
