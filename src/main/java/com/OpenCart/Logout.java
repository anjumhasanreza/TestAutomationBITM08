package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends TestBase
{
    public static void main(String[] args)
    {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenLoginPage();
        Login.Tc_loginTest();
        logOut();

    }
    public static void OpenLoginPage()
    {
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();
    }

    public static void logOut()
    {
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Logout = driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a"));
        Logout.click();
    }
}
