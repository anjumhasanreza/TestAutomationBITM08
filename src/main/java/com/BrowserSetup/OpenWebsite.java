package com.BrowserSetup;

import com.Base.TestBase;

public class OpenWebsite extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("file:///Folder Name/");
        openUrl("https://demo.opencart.com/");
    }

//    public static void openUrl()
//    {
//        driver.get("https://google.com/");
//    }
}
