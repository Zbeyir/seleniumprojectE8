package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // title verification before log-in
        String expectedTitleBeforeLogin =  "Web Orders Login";
        if (expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("success");
        }else {
            System.exit(-1);
        }

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        /*
        hatirlatma html find da id and name basina # koyup name or id
        value yazdigimzda html incelede karsimiza geliyor
         */

        username.sendKeys("Tester");
        password.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle = "Web Orders";
        if (expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }



        ReviewUtils.staticWait(2);
        driver.close();

    }
}
/*
Task 2:
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
Possible Verification Methods:
- Title
- URL
- logged user name
 */