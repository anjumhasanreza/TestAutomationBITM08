package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class BrowserBinary extends TestBase
{
    public static void main(String[] args)
    {
        setBinaryChrome();
        chrome_close();
        setBinaryFirefox();
        firefox_close();
    }
    public static void setBinaryChrome()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.setBinary(new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement Search = driver.findElement(By.name("q"));
        Search.sendKeys("Anjum Hasan Reza");

        WebElement SearchBtn = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
        SearchBtn.click();
        System.out.println("Chrome Binary Complete");
    }
    public static void setBinaryFirefox()
    {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions frxObj = new FirefoxOptions();
        frxObj.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement Search = driver.findElement(By.name("q"));
        Search.sendKeys("Anjum Hasan Reza");

        WebElement SearchBtn = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
        SearchBtn.click();
        System.out.println("Firefox Binary Complete");
    }
}
