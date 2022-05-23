package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTask {

    /*
     automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving
a full 24 hour window (you can attempt to use the DatePicker).

     */

    /*
    When we have more than one window is opened how can we switch to different windows
    getWindowHandles() ----> Set of Strings : we want to take out any duplicate values
    driver.switchTo().window(string of windowHandle)

     */

    @Test
    public void windowsTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://shino.de/parkcalc/");

        //click on first calendar
        driver.findElement(By.xpath("//img[@src='cal.gif'][1]"));

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles);

        ReviewUtils.staticWait(2);

        driver.quit();

//öf öf öf---puf puf puf
        //son 30 dakikayi izlemedim
    }

}
