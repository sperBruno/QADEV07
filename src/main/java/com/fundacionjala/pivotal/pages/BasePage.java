package com.fundacionjala.pivotal.pages;

import com.fundacionjala.pivotal.framework.selenium.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * @author Henrry Salinas
 *
 * This abstract class initialize the Selenium Web Driver
 * and Web Elements from the pages that extends this abstract class
 */
public abstract class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions action;

    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, WAIT_TIME);
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
