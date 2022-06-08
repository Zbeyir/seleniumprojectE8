package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;  // böyle yap (1)   // yani buray yazarsak

    @BeforeMethod
    public void setUp() {

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        // LibraryLoginPage libraryLoginPage = new LibraryLoginPage(); // böyle hepsinde tek tek yazmaya gerek yok

        libraryLoginPage = new LibraryLoginPage(); // böyle yap (2)
        /*
        bunu buraya degil de yukariya yazarsak  yai before method un icine yazmazsaak
          ilk test te sikinti olmayacal
          ama;
           2. teste sikinti olacak
           cünkü: close olunca program da kopmle terminate oluyor
         */


    }


    @AfterMethod
    public void close() {

        BrowserUtils.sleep(3);

        Driver.closeDriver();

    }


    @Test
    public void required_field_error_message_test() {


        //3- Do not enter any information
        //4- Click to “Sign in” button


        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN

        /*
        String expectedMessage = "This field is required.";
        String actualMessage = libraryLoginPage.fieldRequiredErrorMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

         */
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }


    @Test
    public void invalid_email_format_error_message_test() {


        //3- Enter invalid email format


        libraryLoginPage.inputUserName.sendKeys("sdfghj");

        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        //NOTE: FOLLOW POM DESIGN PATTERN

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
    }


    @Test
    public void library_negative_login_test() {


        //3- Enter incorrect username or incorrect password


        libraryLoginPage.inputUserName.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("dfghjkl");
        libraryLoginPage.signInButton.click();


        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        //NOTE: FOLLOW POM DESIGN PATTERN

        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }


}
