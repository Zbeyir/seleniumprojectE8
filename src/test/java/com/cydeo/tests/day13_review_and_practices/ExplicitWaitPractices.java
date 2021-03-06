package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    DynamicControlPage dynamicControlPage;

    @BeforeMethod
    public void setUpMethod() {

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls ");

        dynamicControlPage = new DynamicControlPage();

    }


    @AfterMethod
    public void close() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }


    @Test
    public void remove_button_test() {

        BrowserUtils.sleep(2);


        //3- Click to “Remove” button
        dynamicControlPage.removeButton.click();

        //4- Wait until “loading bar disappears”
       // Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        /*
        BU KISIM ÖNEMLI----
        CÜNKÜ
        bu ksimi yapmadigimizda hata aliyorduk, özellikle en alta ki assert lerden
        cünkü waitler cakisiyor
        ya bunun gibi yukariya '0' yaz--> 1-ilk yöntem --> mantikli olan bu yani yukaridaki
        yada implicitlyWait nerede varsa git oraya '0' yaz --> 2.- yöntem---> bu biraz zor
         */
      //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
      //  wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);


        //5- Verify:
        //a. Checkbox is not displayed

        try {
            //assertFalse method will pass the test if the boolean value returned is: false
            Assert.assertFalse(dynamicControlPage.checkbox.isDisplayed()); // ikisinide kullanabiliriz

            Assert.assertTrue(!dynamicControlPage.checkbox.isDisplayed());  // ikisinide kullanabiliriz
        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }
        /*
        BU TRY CATCH COK ÖNEMLI---
        cünkü sayfa .checkbox siliyor yani---> //p[@id='message'] bizim kod dogru
        ama yukariada -->removeButton.click(); yapilinca
        bizim .checkbox sayfadan siliniyor ve olayi bus ekilde yakaliyoruz
        evet kodumuz dogrumu dogru ama sayfa dan silinin ce görükmüyor,
         zaten bizden istenen de bu ve bunu verify etmis olduk
         */


        //b. “It’s gone!” message is displayed.
        //NOTE: FOLLOW POM

        Assert.assertTrue(dynamicControlPage.message.isDisplayed());  // ikisinide kullanabiliriz
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's gone!"));  // ikisinide kullanabiliriz

    }



    @Test
    public void enable_button_test(){


        System.out.println("dynamicControlPage.inputBox.isEnabled() = "
                + dynamicControlPage.inputBox.isEnabled());
        //bu yukarisini click den önce kontrol amac li yazdik

        //3- Click to “Enable” button
        dynamicControlPage.enableButton.click();

        System.out.println("dynamicControlPage.inputBox.isEnabled() = "
                + dynamicControlPage.inputBox.isEnabled());
        /*
        buranin sonucu hala false cikiyor, click olmasina ragmen
        cünkü alttaki wait ten sonra yazdigimizda tam dogru sonuca ulasacagiz
        ve assert te de ulasiyoruz gördügün gibi
         */

        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.isDisplayed());

        //Check the String value is matching as expected: “It's enabled!”
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's enabled!"));

        //NOTE: FOLLOW POM

    }
}
