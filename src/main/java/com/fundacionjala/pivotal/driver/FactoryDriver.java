package com.fundacionjala.pivotal.driver;

import org.openqa.selenium.WebDriverException;

public final class FactoryDriver {

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        if (Browser.CHROME.toString().equalsIgnoreCase(browser)) {
            return new Chrome();
        } else if (Browser.FIREFOX.toString().equalsIgnoreCase(browser)) {
            return new Firefox();
        } else if (Browser.REMOTE.toString().equalsIgnoreCase(browser)) {
            return new RemoteBrowser();
        } else {
            throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
