package org.example.lab5_parametrization;

import org.example.lab5_parametrization.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Parametrization {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeTest
    public void browserlauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://stackoverflow.com/users/login");
    }

    // Dataset will define here
    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){
        /* Create object array with 2 rows and 2 column- first parameter is row and second is column */
        Object [][] stackoverflowdata=new Object[2][2];

        //------ Ist Data set-------
        // Enter data to row 0 column 0
        stackoverflowdata[0][0]="username1@gmail.com";
        // Enter data to row 0 column 1
        stackoverflowdata[0][1]="Password1";

        //---------- 2nd Data set------------
        // Enter data to row 1 column 0
        stackoverflowdata[1][0]="username2@gmail.com";
        // Enter data to row 1 column 0
        stackoverflowdata[1][1]="Password2";

        // return arrayobject to testscript
        return stackoverflowdata;
    }
    //----------------- TestCase starting -------
    // this will take data from dataprovider which we created
    @Test(dataProvider="testdata")
    public void TestChrome(String emailData,String passwordData){
//

//        driver= SelectBrowser.StartBrowser("Chrome");
       loginPage = new LoginPage(driver);

       loginPage.clearEmail();
       loginPage.sendEmail(emailData);
       loginPage.clearPassword();
       loginPage.sendPassword(passwordData);

    }

}
