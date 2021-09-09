package com.BrowserSetup;

import com.Base.TestBase;
import org.openqa.selenium.Dimension;

public class WindowSize extends TestBase
{
    public static void main(String[] args)
    {
        chrome_launch();
        getWindowSize();
        setWindowSize(1200,500);
        //chrome_close();
    }
    public static void getWindowSize()
    {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("Full Windows Height: "+height);
        System.out.println("Full Windows Width: "+width);

    }
    public static void setWindowSize(int Width, int Height)
    {
        driver.manage().window().setSize(new Dimension(Width, Height));
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("New Windows Height: "+height);
        System.out.println("New Windows Width: "+width);
    }

}
