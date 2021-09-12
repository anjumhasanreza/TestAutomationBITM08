package com.Navigation;

import com.Base.TestBase;

public class NavigationTest extends TestBase
{
    public static void main(String[] args)
    {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        navigationTo();
        navigationBack();
        navigationForward();
        navigationRefresh();
    }
    public static void navigationTo()
    {
        driver.navigate().to("https://google.com/");
    }
    public static void navigationBack()
    {
        driver.navigate().back();
    }
    public static void navigationForward()
    {
        driver.navigate().forward();
    }
    public static void navigationRefresh()
    {
        driver.navigate().refresh();
    }
}
