package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.avengersHours.ProductPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestAdidasPom {

    ProductPage page = new ProductPage();

    @BeforeMethod
    private void testSetUp(){
        Driver.getDriver().get("https://www.demoblaze.com/index.html#");
    }

    @AfterMethod
    public void testTearDown(){
        Driver.closeDriver();
    }


    @Test
    public void Test() {

        /*
        Navigate to home page
        click Laptops, and assert that the list of Laptops match expected
         */



        // create abject for POM locators and methods

        page.getLink("Laptops");

        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.addAll(Arrays.asList("MacBook Pro", "Sony vaio i5", "Sony vaio i7",
                "MacBook air", "Dell i7 8gb", "2017 Dell 15.6 Inch"));

        Collections.sort(expectedProducts); // bu önemli cunkü kodumuz dogru olmasina ragmen test ti miz gecmedi,
        //cünkü sort olomadigi icin faild verdi

        //bu assagi da kini sile biliriz ama silmedim
        List<WebElement> products = page.products;
        for (WebElement product : products) {
            System.out.println(product.getText());
        }

        List<String> actualProducts = ReviewUtils.getElementsText(page.products);

        Collections.sort(actualProducts);

        Assert.assertEquals(actualProducts, expectedProducts);



    }



    @Test
    public void Test2(){


    //Go to Home page
    //click on Sony Vaio i7
    //and verify the product price is 790


        page.getLink("Laptops");        //bu method u ---> AdidasBasePage ' kurduk--> sonra producktPage extedns ettik, sonra burada cagirip kullanik
        page.getLink("Sony vaio i7");  //bu method u ---> AdidasBasePage ' kurduk--> sonra producktPage extedns ettik, sonra burada cagirip kullanik

        double expectedPrice = 790.0;

        double actualPrice = page.productPrice(); // kurdugugumuz method u cagirdik

        Assert.assertEquals(expectedPrice, actualPrice);



    }


    @Test
    public void Test3(){


        //Go to Home page
        //click on MacBook air
        //and verify the product price is 700


        page.getLink("Laptops");        //bu method u ---> AdidasBasePage ' kurduk--> sonra producktPage extedns ettik, sonra burada cagirip kullanik
        page.getLink("MacBook air");  //bu method u ---> AdidasBasePage ' kurduk--> sonra producktPage extedns ettik, sonra burada cagirip kullanik

        double expectedPrice = 700.0;

        double actualPrice = page.productPrice(); // kurdugugumuz method u cagirdik

        Assert.assertEquals(expectedPrice, actualPrice);



    }


}
