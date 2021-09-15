package com.Base;

import com.OpenCart.Registration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class TestBase
{

    public static WebDriver driver;

//    public static void main(String[] args) {
//        chrome_launch();
//    }

    public static void chrome_launch()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void chrome_close()
    {
        driver.close();
    }

    public static void firefox_launch()
    {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public static void firefox_close()
    {
        driver.close();
    }

    public static void edge_launch()
    {
        System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    public static void edge_close()
    {
        driver.close();
    }

    public static void openUrl(String URL)
    {
        driver.get(URL);
    }

    public static String RandomEmail() throws IOException {

        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();
        prop.store(fis, null);


        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }
        String saltstr = salt.toString().concat("@gmail.com");
        prop.setProperty("RandomEmail",saltstr);
        prop.store(fis, null);
        return saltstr;
    }

    public static String RandomPassword() throws IOException {

        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }
        String saltstr = salt.toString();
        prop.setProperty("Password",saltstr);
        prop.store(fis, null);
        return saltstr;
    }

    public static String RandomNameStatic() throws IOException
    {
        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }
        String saltstr = salt.toString();
        return saltstr;
    }

//********************ScreenShot***********************

    public static void generateScreenshot(String name) throws IOException {
        //Capture
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save to
        FileUtils.copyFile(srcFile,new File("./src/main/Screenshots/"+name+".png"),true);
        System.out.println("Image Capture and save");
    }
}
