package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_RadioButton_cont{

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate name='sports' radio buttons and store them in a list of Web Element
        clickAndVerifyRadioButton(driver, "sport", "hockey");

        clickAndVerifyRadioButton(driver, "sport", "football");

        clickAndVerifyRadioButton(driver, "color", "yellow");
        /*
        bu method isimizi kolaylastirdi anladin mi mübarek
         durmadan istedigimiz kadar test yapabiliyoruz
         istedigimiz button i selected yapabiliyoruz
         */





        /*
        //Locate name='sports' radio buttons and store them in a list of Web Element
        List<WebElement> sportRadioButtons = driver.findElements(By.name("sport"));

        //Loop through the List of WebElement and select matching result "hockey"
        for (WebElement each : sportRadioButtons) {

            String eachId = each.getAttribute("id");

            System.out.println("eachId = " + eachId);

            //3. Click to “Hockey” radio button
            if (eachId.equals("hockey")){
                each.click();
                //4. Verify “Hockey” radio button is selected after clicking.
                System.out.println("Hockey is selected : " + each.isSelected());
                break;
            }
        }


         */
        //bu yukarida kini assagiya tasidik buna gerek yok

/*
break; koyduk cünkü hockey sellected yaptik tan sonra loop tan ciksin diye
ve sonrakileri yazdirmasin diye,
break; kaldir bak dedimi anliyacan canimmmm  :)))
 */



        driver.close();

    }


    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue){
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        //Loop through the List of WebElement and select matching result "hockey"
        for (WebElement each : radioButtons) {

            String eachId = each.getAttribute("id");


            //3. Click to “Hockey” radio button
            if (eachId.equals(idValue)){
                each.click();
                //4. Verify “Hockey” radio button is selected after clicking.
                System.out.println( eachId + " is selected : " + each.isSelected() );
                break;
            }
        }
    }
}

/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #3: Utility method task for (continuation of Task2)
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)

Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true


 */
