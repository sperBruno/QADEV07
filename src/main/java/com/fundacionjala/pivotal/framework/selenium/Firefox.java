package com.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {

    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
