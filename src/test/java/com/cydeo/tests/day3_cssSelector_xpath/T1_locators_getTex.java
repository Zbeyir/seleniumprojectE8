package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getTex {

    public static void main(String[] args) throws InterruptedException {


        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser

        // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        /*
        bunu bugün actigimiz utilities class tan  cagirdik
         */

        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");


        //3- Enter incorrect username: “incorrect”
        WebElement userName  = driver.findElement(By.className("login-inp"));
        userName.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement userPassword  = driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("incorrect");

        Thread.sleep(2000);

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessageText = driver.findElement(By.className("errortext"));

        String expectedErrorMessageText = "Incorrect login or password";
        String actualErrorMessageText = errorMessageText.getText();

        if (actualErrorMessageText.equals(expectedErrorMessageText)){
            System.out.println("Error message verification PASSED! ");
        }else {
            System.out.println("Error message verification FAILED!!! ");
        }


        Thread.sleep(4000);
        driver.close();


    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
 */