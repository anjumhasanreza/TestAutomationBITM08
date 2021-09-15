package com.Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase
{
    public static void main(String[] args)
    {
        chrome_launch();
        openUrl("https://the-internet.herokuapp.com/iframe");
        singleFrame();
    }

    public static void singleFrame()
    {
        driver.switchTo().frame("mce_0_ifr");
        WebElement iFrameBoy = driver.findElement(By.id("tinymce"));
        iFrameBoy.clear();
        iFrameBoy.sendKeys("Automation Tested By Anjum Hasan Reza.");
    }
}
