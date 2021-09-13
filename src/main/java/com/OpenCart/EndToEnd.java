package com.OpenCart;

import com.Base.TestBase;
import com.Browsers.TitleAndURLVerification;

import java.io.IOException;

public class EndToEnd extends TestBase
{
    public static void main(String[] args) throws IOException {
        String HomePage = "https://demo.opencart.com/";
        chrome_launch();
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
    }
}
