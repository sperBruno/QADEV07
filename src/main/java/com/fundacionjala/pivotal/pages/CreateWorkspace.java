package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Daniel
 */
public class CreateWorkspace extends BasePage {

    @FindBy(className = "tc_form_input")
    private WebElement workspaceNameTextField;

    @FindBy(css = ".tc_button.tc_button_submit")
    private WebElement createWorkspaceLink;

    @FindBy(css = ".tc_button.tc_button_cancel")
    private WebElement cancelCreateWorkspaceLink;

    /**
     * @param workspaceName
     */
    public void setUserNameTestField(String workspaceName) {
        workspaceNameTextField.clear();
        workspaceNameTextField.sendKeys(workspaceName);
    }

    /**
     * @return Workspace
     */
    public Workspace clickCreateWorkspaceLink() {
        createWorkspaceLink.click();
        return new Workspace();
    }

    public void clickCancelCreateWorkspaceLink() {
        cancelCreateWorkspaceLink.click();
    }

}
