package org.fundacionjala.pivotal.pages.workspace;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * Created by Daniel
 */
public class Workspace extends BasePage {

    private static Logger LOGGER = Logger.getLogger (Workspace.class.getSimpleName ());

    private SideBarWorkspace sideBarWorkspace;

    private ToolBarWorkspace toolBarWorkspace;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    @FindBy(className = "tn-PanelHeader__heading___3FPBiGiZ")
    private WebElement projectIntoWorkspaceNameText;

    public Workspace () {

        sideBarWorkspace = new SideBarWorkspace ();
        toolBarWorkspace = new ToolBarWorkspace ();
    }

    public Dashboard clickReturnDashboardLink () {
        returnDashboardLink.click ();
        return new Dashboard ();
    }

    public String getProjectIntoWorkspaceNameText () {
        String projectIntoWorkspaceName = "";
        try {
            driver.manage ().timeouts ().implicitlyWait (IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            projectIntoWorkspaceName = projectIntoWorkspaceNameText.getText ();
        } catch (NoSuchElementException e) {
            LOGGER.warn ("The element could not be found" + e);
        } finally {
            driver.manage ().timeouts ().implicitlyWait (IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return projectIntoWorkspaceName;
    }

    public String getIdWorkspace () {
        String url = driver.getCurrentUrl ();
        String idWorkspace = "";
        Pattern p = Pattern.compile ("[\\D]");
        Matcher m = p.matcher (url);
        if (m.find ()) {
            idWorkspace = m.replaceAll ("");
        }
        return idWorkspace;
    }

    public SideBarWorkspace getSideWorkspace () {
        return sideBarWorkspace;
    }

    public ToolBarWorkspace getToolBarWorkspace () {
        return toolBarWorkspace;
    }
}