package com.cydeo.reviewWithOscar.week05;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseAdidas extends TestBase {

    @Test
    public void Test(){
        driver.get(" https://www.demoblaze.com/index.html");
        double expectedPrice = 0;

      //  System.out.println(ReviewUtils.addProduct(driver, "Laptops", "Sony vaio i5"));
        // bu yukarida addProduct düzgün calisiyor mu diye denedik

        // ConfigurationReader.getProperty("category1") ----> returns Laptops
       // System.out.println(ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"),"Sony vaio i5"));
        // bu yukari da da confugurations.properties 'i cullandik , ama sadece category1 ' de  --yani bura yukari si ile ayni sadece frakli yöntemler var

        expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"),"Sony vaio i5");


        ReviewUtils.getLink(driver,"Home");

        /*
         burasi sayfada Home diye birsey yaziyor
          yukarida ona tikliyor ve geri gidiyor ki
           alttaki istedigimizi de ayni tescase de yapabilelilm diye
         */

        expectedPrice += ReviewUtils.addProduct(driver,ConfigurationReader.getProperty("category2"),
                "Samsung galaxy s6");

        // go to Cart
        ReviewUtils.getLink(driver, "Cart");

        ReviewUtils.staticWait(3); // PUT one second waiting time

        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(driver.findElement(By.tagName("h3")).getText());
        System.out.println("cartPrice = " + cartPrice);

        System.out.println("expectedPrice = " + expectedPrice); // bura da toplam iki ürünün fiyatini verecek bize
        // Sony vaio i5==> 790 +  Samsung galaxy s6==>360 ==> 1150


        // click on Place order : //button[.='Place Order']
        driver.findElement(By.xpath("//button[.='Place Order']")).click();
        ReviewUtils.staticWait(3);

        ReviewUtils.fillForm(driver);  // utilities class tan cagirdik bunu

        String confirmationText = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

        System.out.println("confirmationText = " + confirmationText);

        /*
        confirmationText = Id: 4129483
        Amount: 1150 USD
        Card Number: 6771-8919-9686-7988
        Name: Xiomara
        Date: 6/5/2022
         */

        String ID = confirmationText.split("\n")[0];
        double actualPrice = Double.parseDouble(confirmationText.split("\n")[1].split(" ")[1]);

        System.out.println("ID = " + ID);
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertEquals(cartPrice, expectedPrice);




    }
}


    /*
    bura da ReviewUtils calss dan alinmis olan addProduct() method un denemsini yapiyoruz
     */

/*
You have to implement the following Web automated checks over our DEMO ONLINE
    SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    • Click on "Place order".
    • Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
    • Click on "Purchase"
    • Capture and log purchase Id and Amount.
    • Assert purchase amount equals expected.
    • Click on "Ok"
 */