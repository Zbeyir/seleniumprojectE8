package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import org.testng.annotations.Test;

public class SingletonPractice {


    @Test
    public void singleton_understand_test1() {

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);

    }

    @Test
    public void singleton_understanding_test2(){

        String str4= Singleton.getWord();
        System.out.println("str4 = " + str4);

    }


}

/*
First time call. Word object is null. Assigning value to it now!
###BU YUKARIDAKINI ILKIN YAZIYOR SONRA YAZMIYOR###
str1 = something
Word already has value.
str2 = something
Word already has value.
str3 = something
Word already has value.
str4 = something


 */
