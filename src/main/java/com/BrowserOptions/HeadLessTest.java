package com.BrowserOptions;

import com.Base.TestBase;
import com.Browsers.TitleAndURLVerification;
import com.OpenCart.Login;
import com.OpenCart.Logout;
import com.OpenCart.Registration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.io.IOException;

public class HeadLessTest extends TestBase
{
    public static void main(String[] args) throws IOException {
        ChromeHeadLess();
//        chrome_close();
//        FirefoxHeadLess();
//        firefox_close();

    }
    public static void ChromeHeadLess() throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeObj = new ChromeOptions();
        chromeObj.setHeadless(true);
        driver = new ChromeDriver(chromeObj);
//        chrome_launch();
        String HomePage = "https://demo.opencart.com/";
        openUrl(HomePage);
        TitleAndURLVerification.home_Page_Title_Verification();
        TitleAndURLVerification.home_Page_Url_Verification();

        Registration.OpenRegistrationPage();
        TitleAndURLVerification.registration_Page_Title_Verification();
        TitleAndURLVerification.register_Page_Url_Verification();

        Registration.Tc_Valid_Registration();
        TitleAndURLVerification.register_Pass_Page_Title_Verification();
        TitleAndURLVerification.register_Pass_Page_Url_Verification();

        Logout.logOut();
        TitleAndURLVerification.logout_Page_Title_Verification();
        TitleAndURLVerification.logOut_Page_Url_Verification();

        openUrl(HomePage);
        TitleAndURLVerification.home_Page_Title_Verification();
        TitleAndURLVerification.home_Page_Url_Verification();

        Login.OpenLoginPage();
        TitleAndURLVerification.login_Page_Title_Verification();
        TitleAndURLVerification.login_Page_Url_Verification();

        Login.Tc_loginTest();
        TitleAndURLVerification.login_Pass_Page_Title_Verification();
        TitleAndURLVerification.login_Pass_Page_Url_Verification();

        Logout.logOut();
        TitleAndURLVerification.logout_Page_Title_Verification();
        TitleAndURLVerification.logOut_Page_Url_Verification();

        openUrl(HomePage);
        chrome_close();
        System.out.println("Login Success");
    }

    public static void FirefoxHeadLess() throws IOException {
//        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
//        FirefoxOptions frxObj = new FirefoxOptions();
//        frxObj.setHeadless(true);
//        driver = new FirefoxDriver(frxObj);
        firefox_launch();
        Login.openUrl("https:/demo.opencart.com/");
        Registration.OpenRegistrationPage();
        TitleAndURLVerification.registration_Page_Title_Verification();
        TitleAndURLVerification.register_Page_Url_Verification();

        Registration.Tc_Valid_Registration();
        TitleAndURLVerification.register_Pass_Page_Title_Verification();
        TitleAndURLVerification.register_Pass_Page_Url_Verification();

        Logout.logOut();
        TitleAndURLVerification.logout_Page_Title_Verification();
        TitleAndURLVerification.logOut_Page_Url_Verification();

        Login.OpenLoginPage();
        TitleAndURLVerification.login_Page_Title_Verification();
        TitleAndURLVerification.login_Page_Url_Verification();

        Login.Tc_loginTest();
        TitleAndURLVerification.login_Pass_Page_Title_Verification();
        TitleAndURLVerification.login_Pass_Page_Url_Verification();

        System.out.println("Login Success");
    }
}
