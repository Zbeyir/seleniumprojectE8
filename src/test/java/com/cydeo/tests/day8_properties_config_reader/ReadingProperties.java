package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {


    @Test
    public void reading_from_properties_test() throws IOException {
        //1- Create the object of Properties
        Properties properties = new Properties();

        //2- We need to open the file in java memory: FileInputStream
        FileInputStream file = new FileInputStream("configurations.properties");

        //3- Load the properties object using FileInputStream object
        properties.load(file);
        /*
        2. adim da ve 3. adim da hata veriyor yani alti kirmizi oluyor ,
        ama biz 3. adimda bu sorunla ilgilendik.
        Cünkü; 3. adimda ki sorun 2. adimda ki sorunun da parent class i
         */

        //4- Use "properties" object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
       // System.out.println("properties.getProperty(\"usernam\") = " + properties.getProperty("usernam"));
        // bunun sonucu ===> null, because herseyi tam yazmak lazim
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));


    }



}
