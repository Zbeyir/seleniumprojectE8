package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeMethod(){
        driver.quit();
    }

    /*
    bu sinifi 9. gün Grühan ile birlikte olusturduk
   day9 'da TestMe class 'da var denemesi git bak
   bura utilities class degil, aksine tüm Test Case lerin parent 'i
     */


}

