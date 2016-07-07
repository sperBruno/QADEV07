package com.fundacionjala.pivotal.pages;



import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.fundacionjala.pivotal.framework.selenium.DriverManager.*;

public abstract class BasePage {

    private Logger LOGGER = Logger.getLogger(BasePage.class.getSimpleName());
    protected WebDriver driver;

    protected Actions action;

    protected WebDriverWait wait;

    public BasePage() {
        driver = getInstance().getDriver();
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, WAIT_TIME);
    }

    public boolean webElementExists(WebElement webElement) {
        boolean exists;
        try {
            webElement.isEnabled();
            exists = true;
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("The element has already deleted" + e);
            exists = false;
        }
        return exists;
    }
}
