package com.cydeo.tests.day4_findElemnets_checkboxes_radio;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) {

        //Practice: Checkboxes
        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");

        //we have to locate checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        /*
        bu yukariyi html sayfasindan kopyalip gelmeden önce dikkat;;
         yazi spam' in icinde bizim aradigimiz input' un icinde
         */

        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isSelected(), expecting false = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isSelected(), expecting true = " + checkbox2.isSelected());

        //4. Click checkbox #1 to select it.
        HandleWait.staticWait(2);
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        HandleWait.staticWait(2);
        checkbox2.click();
        HandleWait.staticWait(2);

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected(), expecting true = " + checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expecting false = " + checkbox2.isSelected());

        driver.close();



    }
}
/*
Practice: Checkboxes
1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
 */