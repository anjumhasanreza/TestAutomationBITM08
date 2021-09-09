package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Registration extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenRegistrationPage();
        Tc_Valid_Registration();
        Logout.logOut();
        Login.OpenLoginPage();
        Login.Tc_loginTest();
        Logout.logOut();
    }

    public static void OpenRegistrationPage() {
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();
    }

    protected static String RandomName() {
        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }
        String saltstr = salt.toString();
        return saltstr;
    }

    protected static String RandomMobile() {
        String RandMobile = "0123456789";
        StringBuilder mobile = new StringBuilder();
        Random rnd = new Random();

        while (mobile.length() < 9) {
            int index = (int) (rnd.nextFloat() * RandMobile.length());
            mobile.append(RandMobile.charAt(index));

        }
        String mobileNumber = mobile.toString();
        return mobileNumber;
    }

    public static String Email = RandomName().concat("@gmail.com");
    public static String FirstName = RandomName();
    public static String LastName = RandomName().concat("a");
    public static String Pass = RandomName();
    public static String telephone = ("016".concat(RandomMobile()));

    public static void Tc_Valid_Registration() {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(FirstName);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(LastName);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(Email);

        WebElement Telephone = driver.findElement(By.name("telephone"));
        Telephone.sendKeys(telephone);

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys(Pass);

        WebElement ConfirmPassword = driver.findElement(By.name("confirm"));
        ConfirmPassword.sendKeys(Pass);

        WebElement Subscribe = driver.findElement(By.name("newsletter"));
        Subscribe.click();

        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        PrivacyPolicy.click();

        WebElement SubmitBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        SubmitBtn.click();
    }
}
