package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver; // bunu buraya yazmadigimizda driver hata veriyor

    @BeforeMethod
    public void setUpMethod(){
        //Do browser driver setup
        //open browser
        driver = WebDriverFactory.getDriver("chrome");
        // biraz önce calismada cünkü yukariyi==>ebDriver driver...aman dikkat

        //maximize the page
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();

    }

    @Test
    public void selenium_test(){



        // get "https://google.com"
        driver.get("https://google.com");

        //assert: title is "Google"
        Assert.assertEquals(driver.getTitle(), "Google","Title is not matching here,");



    }

}
