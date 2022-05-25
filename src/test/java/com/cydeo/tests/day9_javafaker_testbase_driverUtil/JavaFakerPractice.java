package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //Creating Faker object to reach methods
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        //her run ettigimizde bize fake veriler sagliyacak

        //numerify() method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"123-###-####\") = " + faker.numerify("312-###-####"));
        // bu yukarida ki durumda en basi(312) hic degismeyecek, geri kalani her run yaptigimzda degisecek

        //letteriyfy() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));
        System.out.println("faker.letterify(\"??x??x??x?\") = " + faker.letterify("??x??x??x?"));

        System.out.println("faker.bothify(\"##?#-##?#-'#?#?#-##??\") = " + faker.bothify("##?#-##?#-#?#?#-##??"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        //System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replace("-",""));

        //bir yukaridaki ni kapattim cünkü hata veriyor ikisi ayni anda calisinca
        //bu altta kin de java da ögrendigimiz farkli method lari kullanabilcegimizi göstermek istedim (--replace()--) method gibi

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replace("Chuck Norris","Muhtar"));


    }

}
