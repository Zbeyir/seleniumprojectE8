package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    @Test
    public void dropdown_task5(){

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

        //we located the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        HandleWait.staticWait(2);
        stateDropdown.selectByVisibleText("Illinois");
        HandleWait.staticWait(2);

        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        HandleWait.staticWait(2);

        //5. Select California
        stateDropdown.selectByIndex(5);
        HandleWait.staticWait(2);

        //Use all Select options. (visible text, value, index)
        // evet bu görevlerin 3 nü de yaptik

        /*
        ####dikkat bu method larda hatam hep deslect e secmem oldu###
        3. , 4. , 5. maddelerde herbirinde ayri method uyguladik
        5. method da index num 1 den basliyor burada ve california 5. sirada onun icin 5 yazdik
         */

        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOptionText, actualOptionText);

        driver.close();

    }


}

/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */
