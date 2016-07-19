package org.fundacionjala.pivotal.pages.workspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

/**
 * Created by danielgonzales
 */
public class SettingWorkspace extends BasePage {

    private ToolBar toolBar;

    @FindBy(id = "workspace_name")
    private WebElement workspaceNameText;

    @FindBy(id = "delete_link")
    private WebElement deleteWorkspaceLink;

    @FindBy(className = "save_bar__submit")
    private WebElement saveChangesWorkspaceLink;

    @FindBy(className = "save_bar__cancel")
    private WebElement cancelChangesWorkspaceLink;

    @FindBy(className = "message")
    private WebElement messageChangesWorkspace;


    public SettingWorkspace () {
        toolBar = new ToolBar ();
    }

    public void setNameWorkspaceTestField (String workspaceName) {
        workspaceNameText.clear ();
        workspaceNameText.sendKeys (workspaceName);
    }

    public DeleteWorkspace clickDeleteWorkspaceLink () {
        deleteWorkspaceLink.click ();
        return new DeleteWorkspace ();
    }

    public void clickSaveChangesWorkspaceLink () {
        saveChangesWorkspaceLink.click ();
    }

    public void cancelChangesWorkspaceLink () {
        cancelChangesWorkspaceLink.click ();
    }

    public String getMessageChangesWorkspace () {
        return messageChangesWorkspace.getText ();
    }

    public ToolBar getToolBar () {
        return toolBar;
    }
}
