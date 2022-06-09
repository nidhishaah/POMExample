package org.example.lab6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BrowserStackHomePage {
    WebDriver driver;
    By Header=By.xpath("//h1");
    By getStarted=By.xpath("//*[@id='signupModalButton']");

    public BrowserStackHomePage(WebDriver driver) {
        this.driver=driver;
    }
    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
        System.out.println("Home page heading : " +getheadertext);	}
    public void clickOnGetStarted() {
        try {
            driver.findElement(getStarted).click();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Sign in Button Element is not found" + e);
        }
    }

    /**
     * //Identifying elements present on BrowserStack Home Page using PageFactory
     * // @FindBy annotation
     *        @FindBy(xpath = "//h1")
     * 	WebElement Header;
     *
     *    @FindBy(xpath = "//*[@id='signupModalButton']")
     * 	WebElement getStarted;
     *
     * 	public HomePage(WebDriver driver) {
     * 	this.driver = driver;
     * 	PageFactory.initElements(driver, this);
     *    }
     *
     * 	public void veryHeader() {
     * 	String getheadertext = Header.getText();
     * 	assertEquals("App & Browser Testing Made Easy", getheadertext);
     *        }
     * 	public void clickOnGetStarted() {
     * 	getStarted.click();
     *    }
     */

}
