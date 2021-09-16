package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_LoginTest
{
    WebDriver driver;
    @BeforeClass
    public void initSetup()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @AfterClass//(enabled = false)
    public void tearDown()
    {
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object [][] data()
    {
        Object [][] data = new Object [3][2];

        //set1
        data [0][0] ="user101@gmail.com";
        data [0][1] ="12345";

        //set2
        data [1][0] ="user202@gmail.com";
        data [1][1] ="123";

        //set3
        data [2][0] ="user303@gmail.com";
        data [2][1] ="1";

        return data;
    }


    @Test(dataProvider = "LoginData")
    public void TC_Invalid(String DP_Email,String DP_Pass) throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Email);

        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Pass);

        Thread.sleep(2000);

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        System.out.println("Invalid Test Execute");
    }
}
