package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropDown extends TestBase
{
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/dropdown");
        selectOptionByIndex();

        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/dropdown");
        selectOptionByValue();

        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/dropdown");
        selectOptionByVisibleText();
    }

    public static void selectOptionByIndex() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown);
        obj.selectByIndex(1);
        Thread.sleep(3000);
        obj.selectByIndex(2);
    }

    public static void selectOptionByValue() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown);
        obj.selectByValue("1");
        Thread.sleep(3000);
        obj.selectByValue("2");
    }

    public static void selectOptionByVisibleText() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown);
        obj.selectByVisibleText("Option 1");
        Thread.sleep(3000);
        obj.selectByVisibleText("Option 2");
    }
}
