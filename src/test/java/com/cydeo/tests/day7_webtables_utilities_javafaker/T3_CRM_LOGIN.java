package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeMethod(){
        driver.quit();
    }


    @Test
    public void crm_login_test(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");


        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);


        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "Portal");  // bu method u gürhan ile utilities class ta olusturduk ve oni cgirdik
        BrowserUtils.sleep(2);

    }



    @Test
    public void crm_login_test_2(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");



        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();


        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "Portal");  // bu method u gürhan ile utilities class ta olusturduk ve oni cgirdik
        BrowserUtils.sleep(2);

    }


    @Test
    public void crm_login_test_3(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser" );


        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "Portal");
        BrowserUtils.sleep(2);
    }


}

//###-----IKI TEST AYNI ANDA GECMEDI TEK TEK CALISTIRDIM ÖYLE GECTI----#######

/*
TC #3: Login scenario
1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal





         USERNAME             PASSWORD
helpdesk1@cybertekschool.com  UserUser
helpdesk2@cybertekschool.com  UserUser

 */