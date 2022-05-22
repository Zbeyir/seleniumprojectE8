package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
      //1. Create a new class called: T5_WindowsPractice
       // 2. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

    }

    @AfterMethod
    public void closeMethod() {
        driver.quit();
    }

    /*
     tek window da ---driver.close()--hepsinden cikiyordu
     ama simdi sadece en son acilan window dan cikiyor
     simdi ---driver.quit()-- hepsinden cikiyor
     aradaki fark
     */

    @Test
    public void multiple_window_test(){

        //TC #5: Window Handle practice
        //Storing the main's window handle as string is
        //good practice for future re-usable purpose
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle); // buranin sonucu her  yeni window acilisinca , her seferinde degisecek

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title before click : " + actualTitle);

        ReviewUtils.staticWait(2);

        //5. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.linkText("Click Here")); // bu By.linkText yöntemi cok hosuma gitti--direkt oradaki text i kopyaliyorsun
        clickHere.click();

        ReviewUtils.staticWait(2);

        //6. Switch to new Window.
        // burasi yeni ve ÖNEMLI

         /*
        for (String each: driver.getWindowHandles() ){

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }

                 */

        //bu yukaridaki ni kapatip assagidakini actik

        Set<String> allWindowHandles = driver.getWindowHandles();
        // window handle 1- main window
        // window handle 2 - 2nd window

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }




        //7. Assert: Title is “New Window”
        String expectedtTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedtTitleAfterClick);

        System.out.println("Title after click : " + actualTitle);

        //If we want to go back to main pafe, we can use already stored main handle
        //driver.switchTo().window(mainHandle);

    }
/*
####--6. MADDEDEN SONRA yaptigimz islem yeni window ile ilgilenmesini sagladi selenium un.
###--Cünkü 6. madden sonra
 System.out.println("Title before click : " + actualTitle);
 System.out.println("Title after click : " + actualTitle);
 bu ikisinin sonucu ayni idi AAAAMAAAAA

  for (String each: driver.getWindowHandles() ){

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }
      #####---  BUNDAN sonra degisti
        normal de bu loop icine yazabilirmis iz  if() ile (7. baslik atinda yaptigimizi) ASSERT YERINE

 */



}

/*
TC #5: Window Handle practice

1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */