package com.Browsers;

import com.Base.TestBase;

public class TitleAndURLVerification extends TestBase
{
    public static void main(String[] args)
    {

    }
    public static void home_Page_Title_Verification()
    {
        String ExpectedTitle = "Your Store";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("Home Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not Home Page. Expected Title Not Found");
        }
    }

    public static void registration_Page_Title_Verification()
    {
        String ExpectedTitle = "Register Account";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("Registration Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not Registration Page. Expected Title Not Found");
        }
    }
    public static void register_Pass_Page_Title_Verification()
    {
        String ExpectedTitle = "Your Account Has Been Created!";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("Registration Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not Registration Page. Expected Title Not Found");
        }
    }

    public static void login_Page_Title_Verification()
    {
        String ExpectedTitle = "Account Login";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("LogIn Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not LogIn Page. Expected Title Not Found");
        }
    }

    public static void login_Pass_Page_Title_Verification()
    {
        String ExpectedTitle = "My Account";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("LogIn Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not LogIn Page. Expected Title Not Found");
        }
    }

    public static void logout_Page_Title_Verification()
    {
        String ExpectedTitle = "Account Logout";
        String ActualTile = driver.getTitle();

        if (ExpectedTitle.equals(ActualTile))
        {
            System.out.println("LogOut Page, Expected Title Found.");
        }
        else
        {
            System.out.println("Not LogOut Page. Expected Title Not Found");
        }
    }

    public static void home_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("Home URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not Home URL. Expected URL Not Found");
        }
    }

    public static void register_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/index.php?route=account/register";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("Registration URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not Registration URL. Expected URL Not Found");
        }
    }

    public static void register_Pass_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/index.php?route=account/success";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("Registration URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not Registration URL. Expected URL Not Found");
        }
    }

    public static void login_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/index.php?route=account/login";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("LogIn URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not LogIn URL. Expected URL Not Found");
        }
    }

    public static void login_Pass_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/index.php?route=account/account";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("LogIn URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not LogIn URL. Expected URL Not Found");
        }
    }

    public static void logOut_Page_Url_Verification()
    {
        String ExpectedUrl = "https://demo.opencart.com/index.php?route=account/logout";
        String ActualUrl = driver.getCurrentUrl();

        if (ExpectedUrl.equals(ActualUrl))
        {
            System.out.println("LogOut URL, Expected URL Found.");
        }
        else
        {
            System.out.println("Not LogOut URL. Expected URL Not Found");
        }
    }




}
