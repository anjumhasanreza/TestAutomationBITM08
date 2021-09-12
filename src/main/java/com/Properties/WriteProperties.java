package com.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties
{
    public static void main(String[] args) throws IOException {
        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        prop.setProperty("Email",prop.getProperty("Email"));
        prop.setProperty("Password",prop.getProperty("Password"));

        prop.store(fis, null);
    }
}
