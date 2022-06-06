package com.cydeo.utilities;

// bu sinifi Oscar ile actik Gürhan ile degil 2. hafta.
// 4. hafta da adini degistirdik gürhan nin kilerle karismasin diye

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewUtils {

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

           }


        }


        /*
PIQ: Which exception you get the most?
        - No Such Element exception:
            * Your locator is wrong
            * webPage loading time is slower than your Selenium/JAVA code

            #######---java  hizli ama internet sayfasi yavas bu o zaman yardimci olacak bize


            // Bunu
            Thread.sleep(1000);
            yazinca hata veriyordu sign v.s. seyler yapmak gerekiyordu onunla ugrasmamak icin yaptik

 */



    // will be used in demoblaze application, to navigate to different links at the page
    // will click on different elements/links at the page
    public static void getLink(WebDriver driver , String link){
        driver.findElement(By.partialLinkText(link)).click();
        staticWait(1); // bu nu da yukaridaki method dan cagirik

    }



    // Bunu Oscar ile 5. hafta yaptik
    public static double addProduct(WebDriver driver, String category, String product){
        getLink(driver, category); // click on category
        getLink(driver, product);  // click on category


        // Let's get product's price
        String priceText = driver.findElement(By.tagName("h3")).getText(); // $790
        double price = Double.parseDouble(priceText.substring(1,4));   // 790

        /*
        bu yukarida sonucu bie==> $790 böyle veriyor ama biz
        790 böyle istiyoruz $ isareti olmasin
        onun icin bu yukaridaki yöntemi kullandik
         */

        getLink(driver, "Add to cart");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        return price;
    }
    /*
    BU yukaridaki 4. hafta yaotigimiz AlertTask 'in kopyasi
    yani onun kisa yolu utilities 'ini yapiyoruz
    Bu method u da 5. hafta TestCaseAdidas ' da denemesini yaptik git bak
     */


    // Bunu Oscar ile 5. hafta yaptik
    public static void fillForm(WebDriver driver){

        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.id("month")).sendKeys(""+faker.number().numberBetween(1,12));
        driver.findElement(By.id("year")).sendKeys(""+faker.number().numberBetween(2022,2032));
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
        staticWait(3);

    }
/*
https://www.demoblaze.com/cart.html
bu sayfa da place order tikladik tan sonra satin alam islemi icin fake bilgilerin utilities 'i
####---!!!!.....  --->>""+faker.number().numberBetween(1,12));
""+ ==> bu isaret cok önemli , bunu kotymadan önce hata veriyordu
cünkü string  ve int karsi karsiya
yani concatenation yaptik, String 'ten hatirla haci
 */








    }

