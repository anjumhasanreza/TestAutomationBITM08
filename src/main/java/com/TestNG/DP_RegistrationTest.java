package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DP_RegistrationTest
{
    WebDriver driver;
    @BeforeMethod
    public void initSetup()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @DataProvider(name = "RegistrationData")
    public Object [][] data()
    {
        Object [][] data = new Object [3][6];

        //set1
        data [0][0] ="Anjum";
        data [0][1] ="Hasan";
        data [0][2] ="anjumhasan@gmail.com";
        data [0][3] ="01234567890";
        data [0][4] ="123456";
        data [0][5] ="123456";

        //set2
        data [1][0] ="Hasan";
        data [1][1] ="Reza";
        data [1][2] ="hasanreza@gmail.com";
        data [1][3] ="09876543210";
        data [1][4] ="1234";
        data [1][5] ="1234";

        //set1
        data [2][0] ="Reza";
        data [2][1] ="Anjum";
        data [2][2] ="rezaanjum@gmail.com";
        data [2][3] ="01928376450";
        data [2][4] ="12";
        data [2][5] ="12";

        return data;
    }


        @Test(dataProvider = "RegistrationData")
        public void TC_valid_Registration (String DP_FirstName,String DP_LastName,String DP_Email,String DP_Telephone,String DP_Password,String DP_ConfirmPassword) throws InterruptedException {
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.clear();
        FirstName.sendKeys(DP_FirstName);

        WebElement LastName = driver.findElement(By.name("lastname"));
        LastName.clear();
        LastName.sendKeys(DP_LastName);

        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Email);

        Thread.sleep(2000);

        WebElement Telephone = driver.findElement(By.name("telephone"));
        Telephone.clear();
        Telephone.sendKeys(DP_Telephone);

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys(DP_Password);

        WebElement ConfirmPassword = driver.findElement(By.name("confirm"));
        ConfirmPassword.sendKeys(DP_ConfirmPassword);

        WebElement Subscribe = driver.findElement(By.name("newsletter"));
        Subscribe.click();

        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        PrivacyPolicy.click();

        Thread.sleep(2000);

        WebElement SubmitBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        SubmitBtn.click();


        System.out.println("Registration Valid Test Execute");
    }
}
