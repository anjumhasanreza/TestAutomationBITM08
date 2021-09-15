package com.Alert;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase
{
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        Thread.sleep(3000);
//        chrome_close();

//        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        confirmAlertYes();
        Thread.sleep(3000);
//        chrome_close();

//        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        confirmAlertNo();
        Thread.sleep(3000);
//        chrome_close();

//        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        promptAlertYes();
        Thread.sleep(3000);
//        chrome_close();

//        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        promptAlertNo();
        Thread.sleep(3000);
        chrome_close();
    }
    public static void normalAlert() throws InterruptedException {
        WebElement alertBtn = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
        alertBtn.click();
        //Thread.sleep(3000);
        driver.switchTo().alert().accept(); // Click on ok
        System.out.println("Normal Alert: Clink on OK");
    }

    public static void confirmAlertYes() throws InterruptedException {
        WebElement confirmAlertBtn = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
        confirmAlertBtn.click();
        //Thread.sleep(3000);
        driver.switchTo().alert().accept(); // Click on ok
        System.out.println("Confirm Alert: Clink on OK");
    }

    public static void confirmAlertNo() throws InterruptedException {
        WebElement confirmAlertBtn = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
        confirmAlertBtn.click();
        //Thread.sleep(3000);
        driver.switchTo().alert().dismiss(); // Click on cancel
        System.out.println("Confirm Alert: Clink on cancel");
    }

    public static void promptAlertYes() throws InterruptedException {
        WebElement confirmAlertBtn = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
        confirmAlertBtn.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Test Automation By Anjum Hasan Reza");
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // Click on ok
        Thread.sleep(3000);

        System.out.println("Prompt Alert: Clink on ok and Write message.");
    }

    public static void promptAlertNo() throws InterruptedException {
        WebElement confirmAlertBtn = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
        confirmAlertBtn.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Test Automation By Anjum Hasan Reza");
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss(); // Click on ok
        Thread.sleep(3000);

        System.out.println("Prompt Alert: Clink on cancel and Write no message.");
    }

}
