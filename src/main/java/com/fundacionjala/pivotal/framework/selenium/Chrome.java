package com.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    private static final String DRIVER_PATH = "lib/chromedriver.exe";

    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        return new ChromeDriver();
    }
}
