package com.fundacionjala.pivotal.pages;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.selenium.DriverManager.IMPLICIT_FAIL_WAIT_TIME;

/**
 * Created by Bruno on 7/7/2016.
 */
public class Project extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());
    @FindBy(className = "raw_context_name")
    private WebElement projectName;

    @FindBy(css = "[data-aid='navTab-settings']")
    WebElement settings;



    public Settings clickSettingTab() {
        settings.click();
        return new Settings();
    }

    public boolean existsElement() {
        LOGGER.info("exist element");
        driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        return projectName.isDisplayed();
    }

    public String getTitle() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return projectName.getText();
    }
}
