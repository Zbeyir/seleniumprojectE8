package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ViewProduct extends TestBaseForAvengers {

    @Test
    public void Test(){


        // find how many products
        List<WebElement> productsElements = Driver.getDriver().findElements(By.xpath("//a[.='View Product']"));

        int numberOfProducts = productsElements.size();
        System.out.println("numberOfProducts = " + numberOfProducts);

        Random random = new Random();
        int randomProductNumber = random.nextInt(numberOfProducts);

        Driver.getDriver().findElement(By.xpath("(//a[.='View Product'])["+randomProductNumber+"]")).click();


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/product_details"));

        WebElement quantityBox = Driver.getDriver().findElement(By.id("quantity"));
        ReviewUtils.staticWait(3);

        quantityBox.clear();
        ReviewUtils.staticWait(3);

        quantityBox.sendKeys("4");
        ReviewUtils.staticWait(3);

        int expectedValue = 4;
        int actualValue = Integer.parseInt(quantityBox.getAttribute("value"));
        Assert.assertEquals(actualValue, expectedValue);

    }
}


/*
Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
 */