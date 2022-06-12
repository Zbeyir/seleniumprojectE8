package com.cydeo.reviewWithOscar.week06.pomForReview;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {

    @Test
    public void Task06() {


        //Task 6 :
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Click on 'Contact Us' button

        //create object so that you can use elements and methods
        ContactUsPage contactUsPage = new ContactUsPage();

        //contactUsPage.contactUs.click(); //another way
        contactUsPage.getElement("Contact us").click();

        //        -- Extra step move the view to Submit Button
        //for scrolling test cases
        // create actions object
        //first way
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReviewUtils.staticWait(3);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        ReviewUtils.staticWait(3);

        //second way
        actions.moveToElement(contactUsPage.submit).perform();

        //third way
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0, 750)");
        ReviewUtils.staticWait(3);
        jse.executeScript("window.scrollBy(0, -750)");
        ReviewUtils.staticWait(3);

        //last way
        jse.executeScript("arguments[0].scrollIntoView(true)", contactUsPage.submit);
        ReviewUtils.staticWait(3);


        //4. Enter name, email, subject and message
        Faker faker = new Faker();

        contactUsPage.name.sendKeys(faker.name().fullName());
        contactUsPage.email.sendKeys(faker.internet().emailAddress());
        contactUsPage.subject.sendKeys(faker.chuckNorris().fact());
        contactUsPage.message.sendKeys(faker.howIMetYourMother().catchPhrase());

        //5. Upload file
        String path = "/Users/admin/Desktop/SDET EU_8/OscarWith liveReview /Selenium/week6/üfürük";

        // TO UPLOAD FILE UsED SEND KEYS METHOD AND provide of the file as parameter

        contactUsPage.uploadFile.sendKeys(path);


        //6. Click 'Submit' button
        contactUsPage.submit.click();

        //7. Click OK button

        // we get JS Alert // nereden java alert oldugunu anladik , cünkü; inspect yapamiyoruz
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


        //8. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String expectedValue = "Success! Your details have been submitted successfully.";
        String actualValue = contactUsPage.success.getText();

        Assert.assertEquals(actualValue, expectedValue, "Message Test Failed!");

        //9. Click 'Home' button and verify that landed to home page successfully

        Driver.closeDriver();


    }


}

/*
Task 6 :
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Contact Us' button
        -- Extra step move the view to Submit Button
4. Enter name, email, subject and message
5. Upload file
6. Click 'Submit' button
7. Click OK button
8. Verify success message 'Success! Your details have been submitted successfully.' is visible
9. Click 'Home' button and verify that landed to home page successfully

 */