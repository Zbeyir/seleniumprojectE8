package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class task03HardImportetForMe {

    public static void main(String[] args) {

        //Task 3:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
        driver.get("https://www.demoblaze.com/index.html");


        //    • Customer navigation through product categories: Phones, Laptops and Monitors
        //    Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars

       // WebElement laptop = driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"));
       // laptop.click();
        driver.findElement(By.partialLinkText("Laptops")).click();

        HandleWait.staticWait(1);
        /*
        normalde bende assagi da ki gibi yaziyordum ama girmiyordu hata veriyordu
        HandleWait.staticWait(1);
        bunu yazarak sorunu cözdük
        bu önemli aklinda bulunsun
         */


        driver.findElement(By.partialLinkText("Sony vaio i5")).click();



        int expectedPrice = 790;

        HandleWait.staticWait(3);

        String priceText = driver.findElement(By.tagName("h3")).getText();

        System.out.println("priceText = " + priceText);  // ==>  $790 *includes tax

        int actualPrice = Integer.parseInt(priceText.split(" ")[0].substring(1));
        /*
        burada array a cevirdik bu sonucu ($790 *includes tax) " " bosluklardan bölerek
        sonra 0 sectik , sonra substring yapip 1 den baslattik
        assagidaki ni de bir arkadas yapti oscar beyendi
         */

       // int actualPrice = Integer.parseInt(priceText.substring(1,4));

        System.out.println("actualPrice = " + actualPrice);

        if (expectedPrice == actualPrice){
            System.out.println("passed");
        }else {
            System.exit(-1);
        }


        HandleWait.staticWait(3);
        driver.close();




    }
}
/*
Task 3:
You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars
 */