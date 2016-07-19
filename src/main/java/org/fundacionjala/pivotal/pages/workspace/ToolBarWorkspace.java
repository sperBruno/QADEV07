package org.fundacionjala.pivotal.pages.workspace;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Created by DanielGonzales
 */
public class ToolBarWorkspace extends BasePage {

    private static Logger LOGGER = Logger.getLogger(Workspace.class.getSimpleName());

    @FindBy(css = "._2PRWz__projectNavTab._3Sgdh__projectNavTab--clickable")
    private WebElement settingsWorkspaceLink;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;


    public SettingWorkspace clickSettingsWorkspaceLink(){
        settingsWorkspaceLink.click();
        return new SettingWorkspace();
    }

    public String getWorkspaceNameText() {
        String workspaceName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            workspaceName = workspaceNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The element could not be found" + e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return workspaceName;
    }
}