package org.fundacionjala.pivotal.pages.project;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.Constants.FORTY_FIVE;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_PROJECT_WAIT;

/**
 * Created by Bruno on 7/7/2016.
 */
public class Project extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());

    @FindBy(className = "tc_context_name")
    private WebElement projectName;

    @FindBy(css = "[data-aid='navTab-settings']")
    private WebElement settings;

    /**
     * This method will select setting tab.
     * @return Setting.
     */
    public Setting clickSettingTab() {
        try {
            wait.withTimeout(FORTY_FIVE, TimeUnit.SECONDS);
            clickWebElement(settings);
        } catch (NoSuchElementException e) {
            LOGGER.warn("The click tab Setting Element could not be found", e);
            throw new NoSuchElementException("Setting was not found", e);
        } catch (NullPointerException e) {
            LOGGER.error("Setting was not found", e);
            throw new NullPointerException();
        } finally {
            wait.withTimeout(WAIT_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        }
        return new Setting();
    }

    /**
     * This method will verify if project title is displayed.
     * @return true if so and false if not.
     */
    public boolean isProjectTitleDisplayed() {
        boolean projectTitleDisplayed = false;
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_PROJECT_WAIT, TimeUnit.SECONDS);

            projectTitleDisplayed = projectName.isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Element could not be found", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);

        }
        return projectTitleDisplayed;
    }

    /**
     * This method will get project title.
     * @return project title.
     */
    public String getTitle() {
        String projectTitle = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_PROJECT_WAIT, TimeUnit.SECONDS);
            projectTitle = projectName.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The element could not be found", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        }
        return projectTitle;
    }
}
