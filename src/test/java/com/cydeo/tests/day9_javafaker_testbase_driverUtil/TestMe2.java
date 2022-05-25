package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMe2 {

    /*
    buraya dün yaptigimiz test 4 ü kopyaladim
    cünkü utility class da bugün yeni Driver class actik onu deniyorum
     */


    @Test
    public void google_search_test() {
        //Driver.getDriver --> driver

        Driver.getDriver().get("https://google.com");

        ReviewUtils.staticWait(2);

        //3- Write “apple” in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));

        ReviewUtils.staticWait(2);


        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


        ReviewUtils.staticWait(2);

        //4- Verify title:
        //Expected: apple - Google Search
        // String expectedTitle ="apple - Google'da Ara";
        String expectedTitle =ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);



    }

}
