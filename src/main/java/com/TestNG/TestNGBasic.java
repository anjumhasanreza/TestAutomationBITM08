package com.TestNG;

import org.testng.annotations.Test;

public class TestNGBasic
{
    @Test(enabled = false)
    public static void testMethod1()
    {
        System.out.println("Test Automation");
    }

    @Test(priority = -2)
    public static void testMethod2()
    {
        System.out.println("TestNG");
    }

    @Test(priority = 1)
    public static void testMethod3()
    {
        System.out.println("Test Automation");
    }

    @Test(description = "Test Description")
    public static void testMethod4()
    {
        System.out.println("Test Automation");
    }
}
