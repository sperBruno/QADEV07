package com.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriverException;

public final class FactoryDriver {

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        if (Browser.CHROME.getBrowser().equalsIgnoreCase(browser)) {
            return new Chrome();
        } else if (Browser.FIREFOX.getBrowser().equalsIgnoreCase(browser)) {
            return new Firefox();
        } else if(Browser.REMOTE.getBrowser().equalsIgnoreCase(browser)){
            return new RemoteBrowser();
        }else {
            throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
