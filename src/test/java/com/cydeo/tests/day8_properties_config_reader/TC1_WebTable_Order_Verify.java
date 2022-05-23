package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }
    @AfterMethod
    public void closeMethod(){
        driver.quit();
    }

    @Test
    public void order_name_verify_test(){

        WebElement bobElement = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]"));

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBob = "Bob Martin";
        String actualBob = bobElement.getText();

        Assert.assertEquals(expectedBob, actualBob);

        //3. Verify Bob Martin’s order date is as expected
        WebElement dateElement = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[5]"));

        //Expected: 12/31/2021

        String expectedDate = "12/31/2021";
        String actualDate = dateElement.getText();

        Assert.assertEquals(expectedDate, actualDate);





    }



}

/*
TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */
