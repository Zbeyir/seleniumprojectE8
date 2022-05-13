package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {

    public static void main(String[] args) {


       // TC #2: Back and forth navigation
       // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


       // 2- Go to: https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");


       // 3- Click to A/B Testing from top of the list.
       // driver.findElement(By.linkText("A/B Testing")).click(); // eger burayi eksik yzarsak (mesela "A/ Testing")  sayfaya gidecek ve sonuc 1 cikacak yani hata verecek ve nerede hata oldugunu söyleyecek
        // ===> bunun da önüne  WebElement abTestLink = driver.partialFindElement(By.linkTex(("Testing") ile gectim
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing")); // burada findElement sec (findElements) i secme sonuclari farli
        abTestLink.click();


       // 4- Verify title is:
       // Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!!");
        }


       // 5- Go back to home page by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
       // Expected: Practice
        String expectedTitle2 = "Practice";
        String actualTitle2 = driver.getTitle();

        if (expectedTitle2.equals(actualTitle2)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!!");
        }

        driver.close();


    }
}
/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
  Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
  Expected: Practice
 */