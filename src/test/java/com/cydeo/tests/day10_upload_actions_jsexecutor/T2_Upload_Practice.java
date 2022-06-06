package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {
    @Test
    public void upload_test() {


        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/admin/Desktop/SDET EU_8/HTML Class/cybertruck.jpg";
        // bu yukaridaki ni resmin üstüne gidip option (alt) tusunu basip kopyalayip buraya yapistirdik


        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(3);
        //fileUpload.click();  // burada bu yöntemi kullanamiyoruz
        fileUpload.sendKeys(path);
        // cünkü burada ayri bir sayfa cikiyor bilgisayar ile alakali web sayfasi ile alakali degil
        // ve bu sayfa yi sadece selenium ile halledemiyoruz onun icin bu yukarida ki yöntemi kullaniyoruz


        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));

        //4. Assert:
        //-File uploaded text is displayed on the page
        Assert.assertTrue(fileUploadedHeader.isDisplayed());

    }
}



/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page

 */