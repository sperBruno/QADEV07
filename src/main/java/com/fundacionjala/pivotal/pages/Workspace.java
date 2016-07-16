package com.fundacionjala.pivotal.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Created by Daniel
 */
public class Workspace extends BasePage {

    private static Logger LOGGER = Logger.getLogger(Workspace.class.getSimpleName());

    private SideBarWorkspace sideBarWorkspace;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    public Workspace() {
        sideBarWorkspace = new SideBarWorkspace();
    }


    public Dashboard clickReturnDashboardLink() {
        returnDashboardLink.click();
        return new Dashboard();
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

    public SideBarWorkspace getSideWorkspace() {
        return sideBarWorkspace;
    }
}
