package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriverException;

/**
 * @author Henrry Salinas.
 *
 * This class handle the logic related to what kind of browser will be used in the test
 */
public final class FactoryDriver {

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return new Firefox();
            case SAUCELABS:
                return new SauceLabs();
            case BROWSERSTACK:
                return new BrowserStack();
            default:
                throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
