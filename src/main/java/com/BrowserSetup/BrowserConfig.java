package com.BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
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
}
