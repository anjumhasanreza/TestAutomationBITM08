package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser_LoginTest
{
    WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName)
    {
        if (browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("Edge"))
        {
            System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else
        {
            System.out.println("No Browser Found");
        }

        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @AfterClass//(enabled = false)
    public void tearDown()
    {
        driver.quit();
    }

    @Test(priority = 1,description = "Email & Password are Valid")
    public void TC_Valid_001() throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("123456");

        Thread.sleep(2000);

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Login")).click();

        System.out.println("TC_Valid_001");
    }

    @Test(priority = 2,description = "Email Valid & Password Invalid")
    public void TC_Invalid_002() throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("");

        Thread.sleep(2000);

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        System.out.println("TC_Invalid_002");
    }

    @Test(priority = 3,description = "Email Invalid & Password Invalid")
    public void TC_Invalid_003() throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("ser202@gmail");

        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("12");

        Thread.sleep(2000);

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        System.out.println("TC_Invalid_003");
    }
}
