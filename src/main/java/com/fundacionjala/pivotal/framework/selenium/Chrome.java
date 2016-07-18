package com.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.fundacionjala.pivotal.framework.util.Constants.DRIVER_PATH;
import static com.fundacionjala.pivotal.framework.util.Constants.WEBDRIVER_CHROME_DRIVER;

public class Chrome implements IDriver {

    public WebDriver initDriver () {
        System.setProperty (WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver ();
    }
}
