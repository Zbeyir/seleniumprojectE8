package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    //bir önce ki günden kalan test ler

    @Test
    public void task_4_and_5_test() {

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get(" https://practice.cydeo.com/");


        //3- Scroll down to “Powered by CYDEO”
        //Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(3);

        //Locating cydeo link to be able to pass in the actions method
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));


        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).pause(2000).perform();

        //5- Scroll back up to “Home” link using PageUP button
        //  actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        // Gürhan bunu yapti ben assagida ki bi yaptim , ben assagidakini begendim,
        // cünkü Gürhan 'nin kin de Home yazisini göremedim
        // Keys.PAGE_UP, Keys.PAGE_UP 2 defa hatta 3 defa yazdim göremedim

        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        actions.moveToElement(homeLink).pause(2000).perform();


        BrowserUtils.sleep(3);

        Driver.closeDriver();

        /*
        bu yukari da ki methofd u kurduk cünkü;
                Driver.getDriver().close();
                     Driver.getDriver().quit();
        bu ikisin den biri ile cikis yaptigimiz da
        ve tekrar yeni test 'e giris yapmak istedigimiz 'de hata veriyordu
         */


    }
    @Test
    public void test2(){
        Driver.getDriver().get(" https://practice.cydeo.com/");

        Driver.closeDriver();
    }
}


/*

bir önce ki günden kalan test ler


TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button

 */