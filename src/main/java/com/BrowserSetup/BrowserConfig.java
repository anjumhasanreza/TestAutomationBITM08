package com.BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args)
    {
        chrome_launch();
        firefox_launch();
        edge_launch();
    }

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
}
