package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrdersTests {

    WebDriver driver; // declare your veriable


    @BeforeMethod
    public void loginWebOrders(){  // the name is up to you---> polymorphic way
        System.out.println("Login steps for application");
       // WebDriver driver = WebDriverFactory.getDriver("chrome");==> localvariable for this method,
        //,and CAN NOT be used at the following afterMethod, or Test Methods

        driver = WebDriverFactory.getDriver("chrome"); // instantiate or initiate or create

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

        //benim hatam "kesme isareti icine  "#" bunu yazmam, bunu yazmiyoruz
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
//without locating submit button we directly click enter



    }
    @AfterMethod
    public void closeBrowser(){
        System.out.println("Closing the browser for following test cases");
        driver.close();
    }
    @Test
    public void checkBoxTest(){
        System.out.println("Implementing step 3 and 4 Test Case 1");
        /*
        I need to locate checkAll button then click
    I need to locate all checkBoxes and verify each of them
    one by one if they are selected (isSelected())
locate all checkBoxes: I need to find a locator which will show(point) all the checkboxes,
after this step I can use findElements() method for multiple WebElements
         */
        //to locate checkAll button then click
        driver.findElement(By.linkText("Check All")).click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); /// buraya mesaj olarak olumsuzu nu yaziyoruz cünkü burasi false olura görükecek bu mesaj

        for (WebElement eachCheckBox : checkBoxes) {

            // test NG comes with Assertion methods
            Assert.assertTrue(eachCheckBox.isSelected(),"CheckBox IS NOT checked");
            // eachCheckBox.isSelected(); // return type boolean
        }

        // click on Uncheck button
        driver.findElement(By.linkText("Uncheck All")).click();

        // we need to reLocate the elements again, otherwise we get Stale Element Reference Exception
        //yani haci altakini tekrar yaz yoksa yukari da ki dedigi gibi hata alacan -- yani located fresh degil
        checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // verify all checkboxes not selected
        for (WebElement eachCheckBox : checkBoxes) {

            // eachCheckBox.isSelected(); // my boolean exception this time is false
            Assert.assertFalse(eachCheckBox.isSelected(),"The CheckBox IS still selected, we could not unSelect all"); // buraya mesaj olarak olumsuzu nu yaziyoruz cünkü burasi false olura görükecek bu mesaj
        }
    }


    @Test
    public void deletePersonTest(){
        System.out.println("Implementing step 3 and 4 Test Case 2");
    }


}


/*
Test Case 1 :  Verify CheckBox, CheckAll and UncheckAll Buttons
	1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
	2.    Login with-----Username: Tester, password: test

	3.    Click on check all button verify all the checkboxes are checked
	4.    Click on uncheck all button verify that all the checkboxes are unchecked

	Test Case 2
	1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
	2.    Login with-----Username: Tester, password: test
	3.    Select one of the checkbox and delete one person
	4.    Then verify that deleted item is no longer exists

 */