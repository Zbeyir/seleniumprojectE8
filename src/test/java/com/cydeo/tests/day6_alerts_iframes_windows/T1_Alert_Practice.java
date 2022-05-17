package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void closeMethod(){
        driver.close();
    }


    @Test
    public void alert_test1(){

        //TC #1: Information alert practice

        //3. Click to “Click for JS Alert” button
        HandleWait.staticWait(2);

        // ==>  //button[.='Click for JS Alert']  ==> burhanin ki daha kisa
        WebElement clickForJSAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickForJSAlertButton.click();

        HandleWait.staticWait(2);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert(); // burada da karsimizi 2 tane Alert cikiyor biz selenium olani seciyourz

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        //==> p[@id=‘result‘] ==> gürhanin yolu
        WebElement resultText = driver.findElement(By.id("result"));

        //Failure message will you only be displayed id assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed.");



        String expectedResultText = "You successfully clicked an alert";
        String actualResultText = resultText.getText();

        Assert.assertEquals(expectedResultText, actualResultText,"Actual result text is NOT as expected!!!");



        HandleWait.staticWait(2);

    }


}

/*
TC #1: Information alert practice
1. Open browser
2. Go to website: https://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.

TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.

TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.


 */
