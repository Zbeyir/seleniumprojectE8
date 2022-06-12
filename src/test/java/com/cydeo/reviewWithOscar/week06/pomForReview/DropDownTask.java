package com.cydeo.reviewWithOscar.week06.pomForReview;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTask {

    /*
     Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit
     */

    @Test
    public void task03() {

        // 1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //2. Login with username: Tester, password: test
        Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).
                sendKeys("Tester");

        Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).
                sendKeys("test");


        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        // 3. Click  Order button
        //  Driver.getDriver().findElement(By.xpath("//a[@href='Process.aspx']")).click();
        Driver.getDriver().findElement(By.linkText("Order")).click(); // another way


        //   4. Verify under Product Information, selected option is “MyMoney”
        /*
         How do we use Select class methods:
        1. Dropdown should have Select tag
        2. Find locator for the dropdown
        3. Create select class object by passing  located webElement as Constructor parameter
         */

        WebElement dropdownElement = Driver.getDriver().
                findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select dropdown = new Select(dropdownElement);

        // selected option should be “MyMoney” when you click Order button: getFirstSelectedOption method
        String expectedValue = "MyMoney";
        String actualValue = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualValue, expectedValue, "Default Option Test Failed!");


        //    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
        // select FamilyAlbum
        //  dropdown.selectByValue("FamilyAlbum"); // another way
        dropdown.selectByVisibleText("FamilyAlbum");

        ReviewUtils.staticWait(3);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "FamilyAlbum");


        WebElement quantityInput = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //  quantityInput.clear();
        // quantityInput.sendKeys("2");

        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(quantityInput).sendKeys("2").perform(); // best way


        //  Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();


        //    6. Then verify Total is equal to Quantity*PricePerUnit


        ReviewUtils.staticWait(3);
        Driver.closeDriver();


    }


}
