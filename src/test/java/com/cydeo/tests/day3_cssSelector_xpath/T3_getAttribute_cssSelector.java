package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Verify “Log in” button text is as expected:
        //Expected: Log In

        //WebElement logInButton = driver.findElement(By.className("login-btn"));
        // bu olabilir assagida yaotiklarimiz da farkli bir yolu

        // located using class attribute
        // tagName[attribute = 'value']
        // input [class ='login-btn']
       // WebElement logInButton = driver.findElement(By.cssSelector("input[class='login-btn']"));
        // located using type attribute
      //  WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        // located using value attribute
        WebElement logInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
// aman dikkat bunlari yazarken kafana göre bosluk birakma yoksa calismiyor(cssSelector)



        String expectedLogInButtonText = "Log In";
        // String actualLogInButton = logInButton.getText(); //==> ben bunu yaptmistim olmadi cunku attribute value
     // cünkü text bu sefer opening tag ve closing tag icinde degil  ("" böyle iki kesme isaretinin icinde")
        //gettin the value of attribute "value"
        String actualLogInButtonText = logInButton.getAttribute("value");


        if (expectedLogInButtonText.equals(actualLogInButtonText)){
            System.out.println("Log In button text verification PASSED!");
        }else {
            System.out.println("actualLogInButtonText = " + actualLogInButtonText);
            System.out.println("expectedLogInButtonText = " + expectedLogInButtonText);
            System.out.println("Log In button text verification FAILED!!!");
        }

        driver.close();


    }
}
/*
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
 */