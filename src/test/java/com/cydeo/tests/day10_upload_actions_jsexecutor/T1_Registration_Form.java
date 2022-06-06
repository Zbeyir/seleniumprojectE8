package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test() {

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        //Driver.getDriver() ---> driver
        // Driver.getDriver().get("registration.form.url"); //==> bu yanlis cünkü bize --> ConfigurationReader lazim
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        // bunu configuratio.properties olusturduk ve ordan kopyaladik --> bunun fotosu var git bak

        //Create JavaFaker object
        Faker faker = new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        // inputUserName.sendKeys(faker.name().username().replaceAll(".",""));
        // burada . nokta isareti kullaniyor onu kabul etmiyor doldurdugumuz liste, onun icin onu replace yaptik
        //another way
        //inputUserName.sendKeys(faker.bothify("helpdesk###"));
        // bu durumda da helpdesk ile baslayacak sonra 3 tane her defasinda farkli bir numara girecek-->helpdesk078 gibi
        String user = faker.bothify("helpdesk###"); // bu durumda bunu istedigin zaman kullanabilirsin
        inputUserName.sendKeys(user);


        //6. Enter email address
        WebElement inputEmailAddress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        // inputEmailAddress.sendKeys(faker.internet().emailAddress());
        inputEmailAddress.sendKeys(user + "@email.com"); // mesela burada yukarida actugimiz strin i kullaniyoruz


        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        //inputPassword.sendKeys(faker.internet().password());
        // another way
        inputPassword.sendKeys(faker.numerify("########"));// buraya 8 tane # bundan girdik cünkü password en az 8 karakter kabul ediyor

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        //  inputPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        // another way
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####")); // bu sekil girdik cünkü öyle tanimlanmis


        //9. Select a gender from radio buttons
        WebElement selectGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        selectGender.click();


        //10. Enter date of birth
        WebElement inputBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        // faker.number().numberBetween(2004, 1966); bunun gibi araliklar vere biliriz (1, 12) ... gibi
        inputBirth.sendKeys("03/08/2000");


        //11. Select Department/Office
        //Select departmentDropdown = new Select() //===> normal de böyle biz icini doldiuruyouruz
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));
        // buraya(1,9) arasi dedik cünkü orada 9 tane var index num 0 dan basliyor ama bu durumu da en basta ki ni select yapamiyacak


        //12. Select Job Title
        //13. Select programming language from checkboxes
        //14. Click to sign up button
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.


    }


}


/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */

