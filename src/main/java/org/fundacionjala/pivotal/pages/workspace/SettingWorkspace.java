package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales
 */
public class SettingWorkspace extends BasePage {

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

}
