package com.cydeo.utilities;

// bu sinifi Oscar ile actik Gürhan ile degil 2. hafta.

public class HandleWait {

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

           }


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