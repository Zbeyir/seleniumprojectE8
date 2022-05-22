package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {

    public static void main(String[] args) {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        ReviewUtils.staticWait(2);

        //3. Click to “Hockey” radio button
        //  ==> ben burada //label[.='Hockey']----> bunu yazdim o zaman false aldim
        //  cünkü bu radio button un degil, yazinin onun icin
        WebElement elementHockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        elementHockeyBtn.click();

        ReviewUtils.staticWait(2);

        //4. Verify “Hockey” radio button is selected after clicking.
        if (elementHockeyBtn.isSelected()) {
            System.out.println("Button is selected. Verification passed!");
        } else {
            System.out.println("Button is not selected. Verification failed!");
        }


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        driver.close();


    }
}

/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS



 */
