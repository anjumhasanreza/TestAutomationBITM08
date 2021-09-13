package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSL extends TestBase
{
    public static void main(String[] args)
    {
        insecureCerts();
    }
    public static void insecureCerts()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeObj = new ChromeOptions();
        chromeObj.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cacert.org/");
        System.out.println(driver.getTitle());

        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions frxObj = new FirefoxOptions();
        frxObj.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://cacert.org/");
        System.out.println(driver.getTitle());
    }
}
