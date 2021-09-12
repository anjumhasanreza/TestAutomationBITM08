package com.Properties;

import com.Base.TestBase;
import com.OpenCart.Login;
import com.OpenCart.Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LogInWithProperties extends TestBase
{
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        prop.load(fis);

        chrome_launch();
        openUrl("https://demo.opencart.com/");
        Login.OpenLoginPage();


        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys(prop.getProperty("RandomEmail"));

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys(prop.getProperty("Password"));

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
    }

    public static void Tc_login_Valid_Dynamic() throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();
        prop.load(fis);

        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys(prop.getProperty("RandomEmail"));

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("123456");

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
    }
}
