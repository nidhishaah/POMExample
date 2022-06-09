package org.example.lab5_parametrization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("email");

    By password = By.id("password");

    public void clearEmail(){
        driver.findElement(email).clear();
    }

    public void clearPassword(){
        driver.findElement(password).clear();
    }

    public void sendEmail(String arg){
        driver.findElement(email).sendKeys(arg);
    }

    public void sendPassword(String arg){
        driver.findElement(password).sendKeys(arg);
    }
}
