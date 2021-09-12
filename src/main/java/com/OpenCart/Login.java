package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.security.util.Password;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Login extends TestBase
{
    public static void main(String[] args) throws IOException {
        String HomePage = "https://demo.opencart.com/";
        chrome_launch();
        openUrl(HomePage);
        OpenLoginPage();


        chrome_launch();
        openUrl(HomePage);
        Registration.OpenRegistrationPage();
        Registration.Tc_Valid_Registration();
        Logout.logOut();
        OpenLoginPage();
        Tc_loginTest();
    }
    public static void OpenLoginPage()
    {
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();
    }

    public static void Tc_loginTest() throws IOException
    {
        
            WebElement Email = driver.findElement(By.name("email"));
            Email.sendKeys(Registration.Email);

            WebElement Password = driver.findElement(By.name("password"));
            Password.sendKeys(Registration.passw);

            WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            LoginBtn.click();

    }

    public static void Tc_loginTest_Properties() throws IOException {

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
