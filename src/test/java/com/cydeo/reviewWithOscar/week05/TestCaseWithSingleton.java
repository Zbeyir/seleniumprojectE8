package com.cydeo.reviewWithOscar.week05;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseWithSingleton {

    /*
    burada week5 de yaptigimiz ReviewUtils class da ki 3 tane farkli singleton 'lari kullandik
    yani bugün ki test i , birde singleton ile yaptik
    farklar:
        paranetez icine (driver) yazmiyoruz
          cünkü ; bos ise kendisi otomatik driver i bulacak (hatirla Driver mehod 'a öyle demistik)
                 driver.findElement --> yerine
                        Driver.getDriver().findElement --> Yaziyoruz
     */

    @Test
    public void Test(){

        Driver.getDriver().get("https://www.demoblaze.com/index.html");
        double expectedPrice = 0;
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // add Sony vaio i5
        expectedPrice += ReviewUtils.addProduct( ConfigurationReader.getProperty("category1"),"Sony vaio i5");


        ReviewUtils.getLink("Home");


        // add Samsung galaxy s6
        expectedPrice += ReviewUtils.addProduct( ConfigurationReader.getProperty("category2"),
                "Samsung galaxy s6");

        // go to Cart
        ReviewUtils.getLink( "Cart");

        ReviewUtils.staticWait(3); // PUT one second waiting time

        // delete Samsung galaxy s6
        expectedPrice -= ReviewUtils.removeProduct("Samsung galaxy s6"); // burada yukaridakilerin aksine (-= minus) dikkat

        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(Driver.getDriver().findElement(By.tagName("h3")).getText());
        System.out.println("cartPrice = " + cartPrice);

        System.out.println("expectedPrice = " + expectedPrice);


        // click on Place order : //button[.='Place Order']
        Driver.getDriver().findElement(By.xpath("//button[.='Place Order']")).click();
        ReviewUtils.staticWait(3);

        ReviewUtils.fillForm();

        String confirmationText = Driver.getDriver().findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

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

        Driver.getDriver().quit();








    }
}


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

Extra Practice : create a productRemover method to utility, and this method should return removed products price, so that we can deduct from the expected price


 */