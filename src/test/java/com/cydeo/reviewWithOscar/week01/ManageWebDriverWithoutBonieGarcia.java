package com.cydeo.reviewWithOscar.week01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageWebDriverWithoutBonieGarcia {

    public static void main(String[] args) {

        // without Bonnie Garcia
        /*
        Get the driver which is suitable for your OS, and browser version
        Then give the path to Java System settings
         */

      //  System.setProperty("webdriver.chrome.driver","C:/Users/Oscar/Desktop/chromedriver.exe");
        // bu yukari oscar in kini degol de kendikini yazmak lazim

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/index.html");




    }
}
