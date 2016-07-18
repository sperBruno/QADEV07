package com.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Henrry Salinas.
 *
 * This class initialize the Chrome Selenium Web Driver
 */
public class Chrome implements IDriver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String DRIVER_PATH = "lib/chromedriver.exe";

    public static final String WEBDRIVER_CHROME_PROPERTY = "webdriver.chrome.driver";

    /**
     * {@inheritDoc}
     */
    public WebDriver initDriver () {
        System.setProperty (WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver ();
    }
}
