package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.testng.annotations.Test;

public class TestMe extends TestBase {

    @Test
    public void crm_login_test(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");


        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);


        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver, "Portal");  // bu method u gürhan ile utilities class ta olusturduk ve oni cgirdik
        BrowserUtils.sleep(2);

    }

}

/*
buraya 7. gün de ki test 3 ü kopyaladim
cünkü bugün olusturmus oldugumuz abstract class olan TestBase i denemek icin
ve bu sinifa inheritance yaptim
artik after() ve before() method her sinif sa yazmama gerek yok
 */