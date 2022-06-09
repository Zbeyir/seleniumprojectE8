package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick {

    @Test
    public void t1_double_click_test(){


        //TC #1: Double Click Test
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");


        BrowserUtils.sleep(2);
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("accept-choices"));
        acceptCookiesButton.click();
        /*
       #####---- BURAYI BEN EKLEDIM ----- ####
         bu yukari da yeni bir alert ile ilgilendik bu bizim icin öneli
        hani goggle hep karsimiza cikiyordu yaa ooo iste
        artik selenium kendisi ilgilencek
         */


        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");
        //---->BU switch ' i acmasaydik hata veriyordu, cünkü;  iframe var


        //3. Double click on the text “Double-click me to change my text color.”

        DoubleClickPage doubleClickPage = new DoubleClickPage();
        // doubleClickPage.textToDoubleClick.click();
        // burada bu yöntem isi yaramiyor, cünkü; double click yapmamiz icin --> action() lazim
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(doubleClickPage.textToDoubleClick).perform();


        //4. Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        System.out.println("doubleClickPage.textToDoubleClick.getAttribute(\"style\") = "
                + doubleClickPage.textToDoubleClick.getAttribute("style"));

        String actualStyleAttributeValue = doubleClickPage.textToDoubleClick.getAttribute("style");
        String expectedStyleAttributeValue = "red";

        Assert.assertTrue(actualStyleAttributeValue.contains(expectedStyleAttributeValue));



        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }
}
