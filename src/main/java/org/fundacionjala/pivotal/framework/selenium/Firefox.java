package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class initialize the Firefox Selenium Web Driver
 *
 * @author Henrry Salinas.
 */
public class Firefox implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
