package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    public  WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }
    @AfterMethod
    public void closeMethod(){
        driver.close();
    }

    @Test
    public void dropdown_task5(){

        //TC #5: Selecting state from State dropdown and verifying result


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


    }

    @Test
    public void dropdown_task6(){

        //C #6: Selecting date on dropdown and verifying

       //we located the dropdown and it is ready to use
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        //3. Select “December 1st, 1923” and verify it is selected.

        //Select year using  : visible text
        HandleWait.staticWait(2);
        yearDropdown.selectByVisibleText("1923");

        //Select month using   : value attribute
        HandleWait.staticWait(2);
        monthDropdown.selectByValue("11");

        //Select day using : index number
        HandleWait.staticWait(2);
        dayDropdown.selectByIndex(0);
        HandleWait.staticWait(2);

        //creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //create assertions
       // Assert.assertTrue(expectedDay.equals(actualDay));  // another way
        Assert.assertEquals(expectedDay, actualDay);
        Assert.assertEquals(expectedMonth, actualMonth);
        Assert.assertEquals(expectedYear, actualYear);


    }

}

// BUNLAR 5. GÜN DEN KALAN TASK LAR

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


/*
C #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number
 */
