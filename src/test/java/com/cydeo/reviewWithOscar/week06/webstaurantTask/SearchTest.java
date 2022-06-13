package com.cydeo.reviewWithOscar.week06.webstaurantTask;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {

    /*
    Interview Task from US

Go to https://www.webstaurantstore.com/
Search for "stainless work table"
check the search result and unsure that every item has "Table" in it's title
add the last found item
empty cart

Helpful Note: If you have an element that disappears and you need to locate it:
1. Click on Sources at the inspect page
2. hover over your webelement
3. click F-8 to stop debugger of browser, pauses the execution of the script
bunun türkcesini yazdim..fotosu da var
     */


    @Test
    public void test() {
        Driver.getDriver().get("https://www.webstaurantstore.com/");

        BrowserUtils.sleep(2);
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']"));
        acceptCookiesButton.click();
        /*
        #####---- BURAYI BEN EKLEDIM ----- ####
         bu yukari da yeni bir alert ile ilgilendik bu bizim icin öneli
        hani goggle hep karsimiza cikiyordu yaa ooo iste
        artik selenium kendisi ilgilencek
         */

        SearchResultPage page = new SearchResultPage();
        page.searchBox.sendKeys("stainless Work Table" + Keys.ENTER);

        List<WebElement> resultList = page.resultList;

        for (WebElement eachElement : resultList) {
            Assert.assertTrue(eachElement.getText().toLowerCase().contains("table"));
        }

        List<WebElement> inStockItems = page.inStockItems;

        inStockItems.get(inStockItems.size() - 1).click();
        // biz bakarken 58 tane ürünün add cart ' i vardi, ve istendigi son elemani  add yapiyoruz

        page.closeAlert.click();

        int actualValue = Integer.parseInt(page.countOfItems.getText());
        Assert.assertTrue(actualValue == 1);

        ReviewUtils.staticWait(3);
        page.cart.click();

        ReviewUtils.staticWait(3);
        page.emptyCard.click();

        ReviewUtils.staticWait(3);
        page.emptyCardAgain.click();

        ReviewUtils.staticWait(3);


        actualValue = Integer.parseInt(page.countOfItems.getText());
        Assert.assertTrue(actualValue == 0);

        Driver.closeDriver();


    }

}


