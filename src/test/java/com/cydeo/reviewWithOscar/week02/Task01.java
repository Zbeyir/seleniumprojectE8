package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {

    public static void main(String[] args) {

        //open chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //        go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");


        //        then click on "forgot_password" link
        HandleWait.staticWait(1);//==> bunu osacrla beraber actik utilities package te
        // we are using Thread.sleep in more cleaner syntax

        WebElement forgotPasswordLink  = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();


        //        enter any email
        HandleWait.staticWait(1);

        WebElement emailBox = driver.findElement(By.name("email"));

        String expectedEmail = "haci.huseeen@garbage.com";

        emailBox.sendKeys(expectedEmail);

        // verify that is displayed in the input box

       // String actualEmail = emailBox.getText(); // let's see if it works?
        //not in the text of the element, it is at the 'value' attribute of the webElement

        String actualEmail = emailBox.getAttribute("value"); // let's see if it works?


        System.out.println("actualEmail = " + actualEmail);

        //        verify that email is displayed in the input box
        // verify test
        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification");
        }else {
            System.out.println("FAILED email verification");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }



        //        click on Retrieve password
        // use id
        //driver.findElement(By.id("form_submit")).click();

        // use CSS
        //driver.findElement(By.cssSelector("#form_submit")).click();

        // using tagName locator, since it is the only one: //button
       // driver.findElement(By.tagName("button")).click();

        // use Retrieve word to locate with XPATH : //i[contains(text(), 'Retrieve')]
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();

        //        verify that confirmation message says 'Your e-mail's been sent!'
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();

        HandleWait.staticWait(3);


        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASSED message Test!");
        }else {
            System.out.println("FAILED message Test!");
        }


        driver.close();








    }
}

/*
Task 1:
 Verify confirmation message
        open chrome browser
        go to https://practice.cydeo.com/
        then click on "forgot_password" link
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
 */
