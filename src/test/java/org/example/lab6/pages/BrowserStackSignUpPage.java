package org.example.lab6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackSignUpPage {
    WebDriver driver;
    By Header = By.xpath("//h1");
    By userName = By.xpath("//*[@id='user_full_name']");
    By businessEmail = By.xpath("//*[@id='user_email_login']");
    By password = By.xpath("//*[@id='user_password']");

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
        System.out.println("Home page heading : " +getheadertext);
    }
    public void enterFullName(String arg1) {
        driver.findElement(userName).sendKeys(arg1);
    }
    public void enterBusinessEmail(String arg1) {
        driver.findElement(businessEmail).sendKeys(arg1);
    }
    public void enterPasswrod(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }

    /**
     *     WebDriver driver;
     *                @FindBy(xpath = "//h1")
     * 		WebElement Header;
     *                @FindBy(xpath = "//*[@id='user_full_name']")
     * 		WebElement userName;
     *
     *        @FindBy(xpath = "//*[@id='user_email_login']")
     * 		WebElement businessEmail;
     *
     *
     *        @FindBy(xpath = "//*[@id='user_password']")
     * 		WebElement password;
     *
     * 		public SignUpPage(WebDriver driver) {
     * 		this.driver = driver;
     * 		PageFactory.initElements(driver, this);
     *        }
     *
     * 		public void veryHeader() {
     * 			String getheadertext = Header.getText().trim();
     * 			assertEquals("Create a FREE Account", getheadertext);
     *        }
     * 		public void enterFullName(String arg1) {
     * 			userName.sendKeys(arg1);
     *        }
     * 		public void enterBusinessEmail(String arg1) {
     * 			businessEmail.sendKeys(arg1);
     *        }
     * 		public void enterPasswrod(String arg1) {
     * 			password.sendKeys(arg1);
     *        }
     */

}
