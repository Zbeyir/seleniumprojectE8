package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTask {

    /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */


    @Test
    public void alertTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.demoblaze.com/index.html");

        //Navigate to "Laptop" : call the utility method
        ReviewUtils.getLink(driver, "Laptops");
        ReviewUtils.staticWait(2);

        ReviewUtils.getLink(driver, "Sony vaio i5");
        ReviewUtils.staticWait(2);

        ReviewUtils.getLink(driver, "Add to cart");
        ReviewUtils.staticWait(2);

        // After this step should see the ALERT

        //bu alltaki 2 ksimi koymadan önce hata veriyordu, ve alert i ilgilendik
        Alert alert = driver.switchTo().alert(); // How did you use Polymorphism your framework?
        alert.accept();  // dismiss will also work

/*
        burada java script alert ile ilgilendik
        bunlar ok buttonu na basamiyoruz
        inspect yaptigimizda göremiyoruz
        onun icin ALERT HANDLE YAPTIK
 */

        driver.close();
    }


}
