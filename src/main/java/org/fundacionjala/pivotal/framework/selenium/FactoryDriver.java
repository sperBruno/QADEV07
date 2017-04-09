package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser will be used in the test.
 *
 * @author Henrry Salinas.
 */
public final class FactoryDriver {

    /**
     * Private constructor.
     */
    private FactoryDriver() {
    }

    /**
     * This method will return webdriver according to the specified browser.
     *
     * @param browser to use.
     * @return web driver.
     */
    public static IDriver getDriver(String browser) {
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return new Firefox();
            case REMOTE:
                return new RemoteBrowser();
            default:
                throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
