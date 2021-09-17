package com.DataDriven;

import com.Utils.Xls_Reader;
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

public class DD_LoginTestAdvance
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

    }

    @AfterClass//(enabled = false)
    public void tearDown()
    {
        driver.quit();
    }

    @Test(description = "Email & Password are Invalid")
    public void TC_Valid_001() throws InterruptedException
    {
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation

        Xls_Reader reader = new Xls_Reader("./src/main/TestData/LoginData2.xlsx");
        String sheetName = "LoginTestDataSheet";

        int rowCount = reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount; rowNum++)
        {
            //Email
            String email = reader.getCellData(sheetName, "Email", rowNum);
            //Password
            String pass = reader.getCellData(sheetName, "Password", rowNum);

            //Login

            WebElement Email = driver.findElement(By.name("email"));
            Email.clear();
            Email.sendKeys(email);

            Thread.sleep(2000);

            WebElement Password = driver.findElement(By.name("password"));
            Password.clear();
            Password.sendKeys(pass);

            Thread.sleep(2000);

            WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            LoginBtn.click();

            //Logic for pass/fail

            String Expected_Title = "Account Login";
            String Actual_Title = driver.getTitle();

            if(Expected_Title.equals(Actual_Title))
            {
                //Write on Excecl
                reader.setCellData(sheetName,"Actual Test Output",rowNum,"Login Un success");
                reader.setCellData(sheetName,"Test Status",rowNum,"Passed");
            }
            else
            {
                //Write on Excecl
                //reader.setCellData(sheetName,"Actual Test Output",rowNum,"Fail");

                reader.setCellData(sheetName,"Actual Test Output",rowNum,"Login Success");
                reader.setCellData(sheetName,"Test Status",rowNum,"Fail");
            }
        }
    }
}
