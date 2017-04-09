package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * Abstract base page class.
 */
public abstract class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions action;

    /**
     * This is base page constructor.
     */
    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * This method will be used to refresh the page.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
