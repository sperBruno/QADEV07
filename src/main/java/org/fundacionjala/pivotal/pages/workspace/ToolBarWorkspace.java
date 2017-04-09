package org.fundacionjala.pivotal.pages.workspace;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.pivotal.framework.util.Constants.ELEMENT_COULD_NOT_BE_FOUND;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Created by DanielGonzales.
 */
public class ToolBarWorkspace extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Workspace.class.getSimpleName());

    @FindBy(css = "a[data-aid='navTab-settings']")
    private WebElement settingsWorkspaceLink;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(className = "page_header_container")
    private WebElement toolBarContainer;

    /**
     * This method will click setting link.
     *
     * @return Setting Workspace.
     */
    public SettingWorkspace clickSettingsWorkspaceLink() {
        settingsWorkspaceLink.click();
        return new SettingWorkspace();
    }

    /**
     * This method will get Workspace name.
     *
     * @return workspace name.
     */
    public String getWorkspaceNameText() {
        String workspaceName = "";
        try {
            wait.until(ExpectedConditions.visibilityOf(toolBarContainer));
            workspaceName = workspaceNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn(ELEMENT_COULD_NOT_BE_FOUND, e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return workspaceName;
    }
}
