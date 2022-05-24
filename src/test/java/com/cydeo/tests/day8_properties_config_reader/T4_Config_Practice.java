package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

       // We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        //bu yukari da ki ni utilities package tan cagirdik (ConfigurationReader) class
        // bu yukarida parentez in icini de (browser) i eksik (hatali) yazarsak (NullPointerException) aliriz
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://google.com ");
    }

    @AfterMethod
    public void closeMethod() {
        driver.quit();
    }

    @Test
    public void google_search_test() {

        ReviewUtils.staticWait(2);

        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));

        ReviewUtils.staticWait(2);

      //  googleSearchBox.sendKeys("apple" + Keys.ENTER);
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);
        //BU YUKARIYI DA hard cod a cevirdik---ve yine utilities package muracte ettik ve yine
        // ve hersey den önce configuration.properties file da yeni searchValue atadik

        ReviewUtils.staticWait(2);

        //4- Verify title:
        //Expected: apple - Google Search
       // String expectedTitle ="apple - Google'da Ara";
        String expectedTitle =ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";
        // burayi da hard codding yaptik (yani dinamik yaptik arattigimiz sey degisince otamatik olarak degisecek )
        //--> configuration.properties file da yeni searchValue atamistik... yani bura da ki value ne yazarsak sonuc ona göre cikacak
        //tesla yaz tesla cikacak , baska birsey yaz baska birsey cikacak

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

}


/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search


Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */