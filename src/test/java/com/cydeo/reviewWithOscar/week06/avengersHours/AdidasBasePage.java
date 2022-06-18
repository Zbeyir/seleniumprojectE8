package com.cydeo.reviewWithOscar.week06.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AdidasBasePage {

    public AdidasBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * // ###--Singlton_1
     *     // 5. hafta yaptik oscar ile son dakikalar
     *     // bu yukari da kinin singlton ile yapilmisi
     *     // Yani Driver cagirdik buraya ayri bir utilities class , ve onu Gürhan ile yapmistik hatirla haci
     *  buraya da az bir degisiklile kopyaladik
     *  AMAN DIKKAT STATIC METHOD DA IKEN KULLANAMDIM.....
     */
    public void getLink(String link) {  // we need instance methods
        Driver.getDriver().findElement(By.partialLinkText(link)).click();
        ReviewUtils.staticWait(1);

    }

    public WebElement getLinkElement(String str){
        return Driver.getDriver().findElement(By.linkText(str));
    }


    /**
     * bu assagidaki o sayfa di tüm product 'lar i bulacak
     */
    @FindBy(xpath = "//a[@class='hrefch']")
    public List<WebElement> products;









}
