package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02MeSolution {

    public static void main(String[] args) {

        //Task 2:
        //Basic login authentication
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //- Verify title equals: String expectedTitle = "Web Orders Login"
        //- Enter username: Tester
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        //- Enter password: test
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        //- Click “Sign In” button
        WebElement signInButton = driver.findElement(By.name("ctl00$MainContent$login_button"));
        signInButton.click();

        //- Verify title equals: String expectedHomePageTitle = "Web Orders"
        String expectedTitle = "Web Orders";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passe");
        }else {
            System.out.println("Failed");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }


        //Possible Verification Methods:
        //- Title
        //- URL
        //- logged user name

        HandleWait.staticWait(3);
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
