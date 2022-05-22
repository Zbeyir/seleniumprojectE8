package com.cydeo.utilities;

// bu sinifi Oscar ile actik Gürhan ile degil 2. hafta.
// 4. hafta da adini degistirdik gürhan nin kilerle karismasin diye

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
        driver.findElement(By.linkText(link)).click();
        staticWait(1); // bu nu da yukaridaki method dan cagirik

    }



    }

