package com.fundacionjala.pivotal.framework.selenium;


public enum Browser {
    FIREFOX ("firefox"),
    CHROME("chrome"),
    REMOTE("remote");

    private final String browser;
    Browser(String browser) {
        this.browser=browser;
    }
    public String getBrowser() {
        return browser;
    }
}
