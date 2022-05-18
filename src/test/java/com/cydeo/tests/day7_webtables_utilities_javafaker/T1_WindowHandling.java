package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeMethod(){
        driver.quit();
    }


    @Test
    public void window_handling_test(){

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        HandleWait.staticWait(3);
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        HandleWait.staticWait(3);
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        HandleWait.staticWait(3);


        //4. Create a logic to switch to the tab where Etsy.com is open

        /*
        for (String windowHandle : driver.getWindowHandles()) {

        }

         */
        //bu yukaru da kin den se assagi da yaptigimiz in daha basit oldugunu idda ediyor gürhan
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;  // normalde bunu yazmadan önce 4 tane window un URL sini yaziyordu sonuncu olarak da google nin ki ni, ama simdi break ten ötürü yazmiiirrr

            }

        }


        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        String expectedInTitle =  "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

       // Assert.assertTrue(driver.getTitle().contains("Etsy")); ===> yukarida ki daha sonra baktigimizda daha anlasilirmisss

    }


}

/*
TC #1: Window Handle practice
 1. Create new test and make set ups
2. Go to : https://www.amazon.com
3. Copy paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”

Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
 */