package org.example.lab6.testcases;

import org.example.lab6.library.SelectBrowser;
import org.example.lab6.pages.BrowserStackHomePage;
import org.example.lab6.pages.BrowserStackSignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNumberOne {
    WebDriver driver;
    BrowserStackHomePage objHomePage;
    BrowserStackSignUpPage objSignUpPage;
    @BeforeTest
    public void browserlauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Firefox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/");
    }
    // --------invoke teskcase one-------
    @Test(priority = 1)
    public void navigate_to_homepage_click_on_getstarted() {
        objHomePage = new BrowserStackHomePage(driver);
        objHomePage.veryHeader();
        objHomePage.clickOnGetStarted();
    }
    //---------- invoke teskcase two------
    @Test(priority = 2)
    public void enter_userDetails() throws InterruptedException {
        objSignUpPage = new BrowserStackSignUpPage(driver);
        objSignUpPage.veryHeader();
        objSignUpPage.enterFullName("TestUser");
        objSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        objSignUpPage.enterPasswrod("TestUserPassword");
       // Thread.sleep(10000);
    }
    @AfterTest
    public void closeBrowser()
    {
       // driver.quit();
    }

}
