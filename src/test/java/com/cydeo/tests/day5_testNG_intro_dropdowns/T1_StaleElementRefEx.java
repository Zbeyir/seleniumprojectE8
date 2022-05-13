package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) {


        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        //button[@onclick='addElement()'] ==> böylede kisa yolu var copy paste yapiyorsun sayfadan
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));

        HandleWait.staticWait(2);
        addElementBtn.click();
        HandleWait.staticWait(2);


        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteElementBtn = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        System.out.println("deleteElementBtn.isDisplayed() = " + deleteElementBtn.isDisplayed());

        //5. Click to “Delete” button.
        deleteElementBtn.click();

        HandleWait.staticWait(2);

        //6. Verify “Delete” button is NOT displayed after clicking.

        try {

            System.out.println("deleteElementBtn.isDisplayed() = " + deleteElementBtn.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("--->StaleElementReferenceException exception is throw");
            System.out.println("-->this means the web element is completely deleted from the page");
            System.out.println("deleteElementBtn.isDisplayed() = false");
        }


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        driver.close();

        /*
        bu sefer try catch uyguladik cünkü bu sefer sayfadan istedigimiz sey silinmis
        baska sayfadayiz haciiii----dünkü yani bir önceki gün öyle degilde copy paste yapip
        isi kotarmistik
         */

    }
}

/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


 */