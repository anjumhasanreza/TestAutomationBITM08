package com.Locators;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementLocator extends TestBase
{
    public static void main(String[] args)
    {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
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

    public static void Tc_loginTest()
    {
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("anjumhasanreza88@gmail.com");

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("01678045810");

        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
    }
}
