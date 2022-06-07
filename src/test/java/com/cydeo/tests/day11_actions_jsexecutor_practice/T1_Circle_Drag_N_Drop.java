package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    @Test
    public void drag_and_drop_test() {

        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        BrowserUtils.sleep(3);

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
        /*
        bu yukari da yeni bir alert ile ilgilendik bu bizim icin öneli
        hani goggle hep karsimiza cikiyordu yaa ooo iste
        artik selenium kendisi ilgilencek
         */


        BrowserUtils.sleep(3);

        //Locate small and big circles to be able to drag them around
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle, bigCircle).perform(); //another way
        actions.clickAndHold(smallCircle)
                .pause(3)
                .moveToElement(bigCircle)
                .pause(3)
                .release().perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualBigCircleText = "You did great!";
        String expectedBigCircleText = bigCircle.getText();

        Assert.assertEquals(expectedBigCircleText, actualBigCircleText);


        Driver.closeDriver();
    }
}

/*
TC #: Drag and drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */