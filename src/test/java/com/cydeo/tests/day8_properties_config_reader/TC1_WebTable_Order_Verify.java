package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
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


    //we use the utility method we created.
    @Test
    public void test2(){

        // method static oldugu icin burada direkt class adini yazdik
       String customerDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerDate1 = " + customerDate1);

        String customerDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerDate2 = " + customerDate2);

    }


    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");

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
