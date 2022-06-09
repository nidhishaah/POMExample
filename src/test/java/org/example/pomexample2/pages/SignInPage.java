package org.example.pomexample2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*

 */


public class SignInPage {

    WebDriver driver;

    By frame = By.xpath("*//div/iframe[@id='aid-auth-widget-iFrame']");
    By loginTextField = By.id("account_name_text_field");
    By signInButton = By.id("sign-in");
    By passwordTextField = By.id("password_text_field");
    By errorMsg = By.id("alertInfo");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrames(){
        driver.switchTo().frame(driver.findElement(frame));
    }

    public void enterLogin(String arg){
        driver.findElement(loginTextField).sendKeys(arg);
    }

    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }

    public void enterPassword(String arg){
        driver.findElement(passwordTextField).sendKeys(arg);
    }

    public String getErrorMessage(){
       return driver.findElement(errorMsg).getText();
    }
}
