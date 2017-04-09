package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by danielgonzales.
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

    /**
     * This method will be used to set workspace name.
     *
     * @param workspaceName to use.
     */
    public void setNameWorkspaceTestField(String workspaceName) {
        workspaceNameText.clear();
        workspaceNameText.sendKeys(workspaceName);
    }

    /**
     * This method will be used to delete a workspace.
     *
     * @return DeleteWorkspace.
     */
    public DeleteWorkspace clickDeleteWorkspaceLink() {
        deleteWorkspaceLink.click();
        return new DeleteWorkspace();
    }

    /**
     * This method will click on save changes.
     */
    public void clickSaveChangesWorkspaceLink() {
        saveChangesWorkspaceLink.click();
    }

    /**
     * This method will on cancel.
     */
    public void cancelChangesWorkspaceLink() {
        cancelChangesWorkspaceLink.click();
    }

    /**
     * This method will get workspace message.
     *
     * @return workspace message.
     */
    public String getMessageChangesWorkspace() {
        return messageChangesWorkspace.getText();
    }

}
