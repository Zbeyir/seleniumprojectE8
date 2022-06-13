package com.cydeo.reviewWithOscar.week06.webstaurantTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends HomePage{

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> resultList;

    @FindBy(xpath = "//input[@data-testid='itemAddCart']")
    public List<WebElement> inStockItems;
    // biz bakarken 58 tane ürünün add cart ' i vardi

    @FindBy(xpath = "//button[@class='close p-2 mr-2 top-1']")
    public WebElement closeAlert;

    /*
    Helpful Note: If you have an element that disappears and you need to locate it:
    1. Click on Sources at the inspect page
    2. hover over your webelement
    3. click F-8 to stop debugger of browser, pauses the execution of the script
    fotosu var ben de türkce yazdim
    2.55 ler de anlatiyor
     */

    @FindBy(xpath = "(//span[.='Cart'])[2]")
    public WebElement cart;

    /*
   ==> //span[.='Cart'] ==> bundan 2 tane oldugu icin
  ==> (//span[.='Cart'])[2] ==> böyle yazdik

     */

    @FindBy(id = "cartItemCountSpan")
    public WebElement countOfItems;

    @FindBy(xpath = "//button[.='Empty Cart']")
    public WebElement emptyCard;

    @FindBy(xpath = "(//button[.='Empty Cart'])[2]")
    public WebElement emptyCardAgain;

    @FindBy(xpath = "//p[@class='header-1']")
    public WebElement emptyMessage;



}
