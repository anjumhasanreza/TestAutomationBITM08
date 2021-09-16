package com.TestNG;

import com.OpenCart.Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/*
 ******************** Using BeforeClass & AfterClass Annotation ********************
 */
public class LoginTestNG
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
