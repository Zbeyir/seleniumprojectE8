package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) throws InterruptedException {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");


        //3- Verify header text is as expected:
        WebElement headerText = driver.findElement(By.tagName("h2"));

        //  Expected: Registration form
        String expectedHeaderText = "Registration form"; //will return "Registration form" as String

        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification PASSED!");
        }else {
            System.out.println("Header text verification FAILED!!!");
        }


        //4- Locate “First name” input box
        // we are locating the web element using "name" locator
        // name attribute has "firstname" value
        //WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement firstNameInput = driver.findElement(By.className("form-control"));
        //yukaridakinin yerine bunu da yazabiliriz sonuc degismeyecek


        //5- Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder text verification PASSED!");
        }else {
            System.out.println("Placeholder text verification FAILED!!!");
        }

        Thread.sleep(3000);
        driver.close();



    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
 */