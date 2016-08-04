package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;

/**
 * @author Henrry Salinas.
 *
 * This interface define the methods related to initialize the Selenium driver
 *
 */
@FunctionalInterface
public interface IDriver {

    /**
     * This method initialize the Selenium web driver through the classes that implements this method
     *
     * @return Selenium Web Driver
     */
    WebDriver initDriver();
}
