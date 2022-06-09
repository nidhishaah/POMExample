package org.example.pomexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    WebDriver driver;
    
    By searchTextField = By.name("q"); 

    public GoogleSearchPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    
    public void inputIntoASearchTextField(String arg1){
       // driver.get("http://www.google.com");
        driver.findElement(searchTextField).sendKeys(arg1+ Keys.ENTER);
    }
    
}
