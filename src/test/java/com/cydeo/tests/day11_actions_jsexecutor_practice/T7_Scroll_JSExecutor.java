package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    @Test
    public void task7_scroll_test() {

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large ");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //Down-casting our driver type to JavascriptExecutor,
        // so we are able to use the methods coming from that interface
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(3);

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

        BrowserUtils.sleep(3);

        //4- Scroll up to “Home” link
       // js.executeScript("arguments[0].scrollIntoView(true)", homeLink);
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        // yukarida 2 tane yöntem var,  ikisi de calisiyor

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)

        BrowserUtils.sleep(3);

        Driver.closeDriver();


    }
}

/*
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only

JavaScript method to use : arguments[0].scrollIntoView(true)

Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method



 */