package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.fundacionjala.pivotal.framework.util.Constants.DRIVER_PATH;
import static org.fundacionjala.pivotal.framework.util.Constants.WEBDRIVER_CHROME_DRIVER;

/**
 * @author Henrry Salinas.
 *
 * This class initialize the Chrome Selenium Web Driver
 */
public class Chrome implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver () {
        System.setProperty (WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver ();
    }
}
