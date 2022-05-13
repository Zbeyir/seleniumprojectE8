package com.cydeo.tests.day4_findElemnets_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {

    public static void main(String[] args) {


        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydoeLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));

        System.out.println("cydoeLink.isDisplayed() = " + cydoeLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();

        //we are refreshing the web element reference by re-assigning (re-locating) the web element
        cydoeLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        /*
        eger bu yukaridakini yazmadigimiz da hata mesaji olarak 1 alacagiz
        StaleElementReferenceException.... baslayan
        onun icin yazdik bunu
         */

        //5- Verify it is displayed, again.
        System.out.println("cydoeLink.isDisplayed() = " + cydoeLink.isDisplayed());

        driver.close();



    }
}

/*

TC #6: StaleElementReferenceException Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate “CYDEO” link, verify it is displayed.
4- Refresh the page.
5- Verify it is displayed, again.



This is a simple StaleElementReferenceException to understand what is
this exception and how to handle it.
 */