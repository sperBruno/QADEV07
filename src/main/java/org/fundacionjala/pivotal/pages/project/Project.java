package org.fundacionjala.pivotal.pages.project;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_PROJECT_WAIT;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * Created by Bruno on 7/7/2016.
 */
public class Project extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());

    @FindBy(className = "tc_context_name")
    private WebElement projectName;

    @FindBy(css = "[data-aid='navTab-settings']")
    private WebElement settings;

    public Setting clickSettingTab() {
        try {
            //driver.manage().timeouts().implicitlyWait(IMPLICIT_PROJECT_WAIT, TimeUnit.SECONDS);
            wait.withTimeout(45, TimeUnit.SECONDS);
            clickWebElement(settings);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Setting was not found");
        }catch (NullPointerException e){

        }finally {
            wait.withTimeout(WAIT_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
        }
        return new Setting();
    }

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
