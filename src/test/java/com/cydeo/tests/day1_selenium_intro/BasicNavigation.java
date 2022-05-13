package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        // 1- set up the browser driver
        WebDriverManager.chromedriver().setup();

        // 2- create instance of the selenium web driver
        // 3- this is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // bu noktada birakirsak 3. adimi yazmaz isek empty page aliriz

        // 3- go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        // get the title of the page  ==> bu kismi sonradan kendimiz eklledik
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle); // bunu buraya yazmaz isen sadece en sondakinin title si ni getirecek

        // get the current URL using selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate back
        driver.navigate().back();

        // stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        // stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        // stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to;
        driver.navigate().to("https://www.google.com");

        // get the current title after getting the Google page
        currentTitle = driver.getTitle();

        // get the title of the page
     //   System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("currentTitle = " + currentTitle);

        // get the current URL using selenium
        currentTitle = driver.getCurrentUrl();

        System.out.println("currentURL = " + currentURL);

        // this line will maximize the browser size
        driver.manage().window().maximize();
        // ve bunu yukari 3. adimdan sonra hemen yazmak lazim full screeen herseyi görebilmek icin gözden birsey kacmamamsi icin

       // driver.manage().window().fullscreen(); // bu bazen mac de calismiyor-- yaada calistigini pek anlayamiyoruz

        // this will close the currently opened window
        driver.close();

        // this will close all of the opened window
        driver.quit(); // ve bunu [driver.close();] bundan önce yazamayiz, hata aliriz



    }
}
