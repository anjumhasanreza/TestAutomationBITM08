package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowHandle extends TestBase
{
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https:/opensource-demo.orangehrmlive.com/");
        driver.findElement(By.cssSelector("#social-icons > a:nth-child(3) > img")).click();

        Set<String> handles = driver.getWindowHandles();

        Iterator <String> it = handles.iterator();
        String parentWindowID = it.next();
        System.out.println("Parent Window ID : "+parentWindowID);

        String childWindowID = it.next();
        System.out.println("Child Window ID : "+childWindowID);

        //Switching

        driver.switchTo().window(childWindowID);
        System.out.println("Child Window URL: "+driver.getCurrentUrl());
        //driver.close();

        driver.switchTo().window(parentWindowID);
        System.out.println("Parent Window URL: "+driver.getCurrentUrl());
        driver.navigate().to("https://google.com");
        System.out.println("New Page Title: "+driver.getTitle());
        Thread.sleep(5000);
        //driver.close();

        //For All Tab Close

        driver.quit();
    }

}
