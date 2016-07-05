package com.fundacionjala.PivotalFinalTest.driver;

import org.openqa.selenium.WebDriverException;

public final class FactoryDriver {

    public static final String CHROME = "chrome";

    public static final String FIREFOX = "firefox";
    public static final String REMOTE = "remote";

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        if (CHROME.equals(browser)) {
            return new Chrome();
        } else if (FIREFOX.equals(browser)) {
            return new Firefox();
        } else if(REMOTE.equals(browser)){
            return new RemoteBrowser();
        }else {
            throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
