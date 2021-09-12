package com.OpenCart;

import com.Base.TestBase;
import com.Properties.LogInWithProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Registration extends TestBase {
    public Registration() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenRegistrationPage();
        //Tc_Valid_Registration();
        RandomEmail();
        Tc_Valid_Registration_Properties();
        Logout.logOut();
        Login.OpenLoginPage();
        //Login.Tc_loginTest();
        LogInWithProperties.Tc_login_Valid_Dynamic();
        Logout.logOut();
    }

    public static void OpenRegistrationPage() {
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();
    }

//    public static String RandomNameStatic() throws IOException
//    {
//        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder salt = new StringBuilder();
//        Random rnd = new Random();
//
//        while (salt.length() < 7) {
//            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
//            salt.append(SALTCHAR.charAt(index));
//
//        }
//        String saltstr = salt.toString();
//        return saltstr;
//    }
    public static String RandomName() throws IOException {

        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        String SALTCHAR = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }

        String saltstr = salt.toString();
        prop.setProperty("RandomName",saltstr);
        prop.setProperty("Password",saltstr);
        prop.store(fis, null);
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

    public static String passw;

    static {
        try {
            passw = RandomName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String Email;

    static {
        try {
            Email = RandomName().concat("@gmail.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Tc_Valid_Registration() throws IOException {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(RandomName());

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(RandomName());

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(Email);

        WebElement Telephone = driver.findElement(By.name("telephone"));
        Telephone.sendKeys("016".concat(RandomMobile()));

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys(passw);

        WebElement ConfirmPassword = driver.findElement(By.name("confirm"));
        ConfirmPassword.sendKeys(passw);

        WebElement Subscribe = driver.findElement(By.name("newsletter"));
        Subscribe.click();

        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        PrivacyPolicy.click();

        WebElement SubmitBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        SubmitBtn.click();
    }

    public static void Tc_Valid_Registration_Properties() throws IOException {


        FileInputStream fis = new FileInputStream("./src/main/resources/Data.properties");
        Properties prop = new Properties();

        prop.load(fis);


        System.out.println(prop.getProperty("Email"));
        System.out.println(prop.getProperty("Password"));


        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Abcde");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Fghij");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(prop.getProperty("RandomEmail"));

        WebElement Telephone = driver.findElement(By.name("telephone"));
        Telephone.sendKeys("01674512780");

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("123456");

        WebElement ConfirmPassword = driver.findElement(By.name("confirm"));
        ConfirmPassword.sendKeys("123456");

        WebElement Subscribe = driver.findElement(By.name("newsletter"));
        Subscribe.click();

        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        PrivacyPolicy.click();

        WebElement SubmitBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        SubmitBtn.click();
    }
}
