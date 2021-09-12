package com.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties
{
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        prop.load(fis);


        System.out.println(prop.getProperty("Email"));
        System.out.println(prop.getProperty("Password"));
    }
}
