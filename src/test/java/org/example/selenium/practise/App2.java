package org.example.selenium.practise;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class App2{
    public static void main(String[] args) throws InterruptedException {
//         Path of chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver1.exe");
         	// Initialize WebDriver
         	WebDriver driver = new ChromeDriver();
  //       Go to URL
         driver.get("https://www.perscholas.org");
         driver.manage().window().maximize();
         DesiredCapabilities capabilities = new DesiredCapabilities();//.chrome();
         capabilities.setCapability("browserName", "chrome");
         capabilities.setCapability("version", "100.0");
    //     could be changes time to time
         capabilities.setCapability("platform", "win11");
         capabilities.setCapability("build", "TestSampleApp");
         capabilities.setCapability("name", "TestJavaSample");
         capabilities.setCapability("network", true);
      //   To enable network logs
         capabilities.setCapability("visual", true);
        // To enable step by step screenshot
         capabilities.setCapability("video", true);
         //To enable video recording
         capabilities.setCapability("console", true);
         //To capture console logs
         capabilities.setCapability("timezone","UTC+05:30");
         driver.quit();	}
}

