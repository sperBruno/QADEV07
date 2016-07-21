package org.fundacionjala.pivotal.pages.workspace;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.pivotal.framework.util.Constants.ELEMENT_COULD_NOT_BE_FOUND;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Created by DanielGonzales
 */
public class ToolBarWorkspace extends BasePage {

    private static Logger LOGGER = Logger.getLogger(Workspace.class.getSimpleName());

    private static final String ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG = "Add Story Button was not found";

    @FindBy(css = "._2PRWz__projectNavTab._3Sgdh__projectNavTab--clickable")
    private WebElement settingsWorkspaceLink;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(css = ".tc_page_header.tc_page_header_version-ia.tc_page_header-ia.tc_page_header-expanded")
    private WebElement toolBarContainer;



    public SettingWorkspace clickSettingsWorkspaceLink(){
        settingsWorkspaceLink.click();
        return new SettingWorkspace();
    }

    public String getWorkspaceNameText() {
        String workspaceName = "";
        try {
            wait.until(ExpectedConditions.visibilityOf(toolBarContainer));
            workspaceName = workspaceNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn(ELEMENT_COULD_NOT_BE_FOUND + e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return workspaceName;
    }
}