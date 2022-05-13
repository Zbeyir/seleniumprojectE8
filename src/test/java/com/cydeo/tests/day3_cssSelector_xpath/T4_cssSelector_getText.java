package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {

        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");


        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        //locating reset password button using class attribute and its value
        WebElement resetPassword = driver.findElement(By.cssSelector("button[class=login-btn]"));

        String expectedResetPasswordText = "Reset password";
        //String actualResetPasswordText = resetPassword.getAttribute("value");
        String actualResetPasswordText = resetPassword.getText();
        //bu sefer ikisi de mümkün yani yukaridakide

        if (expectedResetPasswordText.equals(actualResetPasswordText)){
            System.out.println("PASSED!");
        }else {
            System.out.println("FAILED!!!");
        }

        driver.close();



    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
 */