package org.example.pomexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleImagesPage {

    WebDriver driver;

/*    By clickImageLink = By.linkText("Images");
    By getWebElements = By.xpath("//a/div/img");


    public GoogleImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLinkImages(){
        driver.findElement(clickImageLink).click();
    }

    public List<WebElement> getWebElement(){
        return driver.findElements(getWebElements);
    }
*/
    @FindBy(linkText = "Images")
    WebElement clickImageLink;

    @FindBy(xpath ="//a/div/img" )
    List<WebElement> getWebElements;

    public GoogleImagesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnLinkImages(){
        clickImageLink.click();
    }

    public List<WebElement> getWebElement(){
        return getWebElements;
    }
}
