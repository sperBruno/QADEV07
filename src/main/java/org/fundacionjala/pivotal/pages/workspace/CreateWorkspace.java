package org.fundacionjala.pivotal.pages.workspace;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Daniel Gonzales
 *
 * CreateWorkspace is the class to create a new Workspace
 */
public class CreateWorkspace extends BasePage {

    @FindBy(className = "tc_form_input")
    private WebElement workspaceNameTextField;

    @FindBy(css = ".tc_button.tc_button_submit")
    private WebElement createWorkspaceLink;

    @FindBy(css = ".tc_button.tc_button_cancel")
    private WebElement cancelCreateWorkspaceLink;

    @FindBy(className = "tc_form_error_message")
    private WebElement messageWorkspaceNameEmpty;

    @FindBy(className = "tc_modal_content")
    private WebElement getCreateWorkspaceContainer;

    /**
     * Method to do click on the button "Create Workspace" on the Form
     *
     * @return Workspaces
     */
    public Workspace clickCreateWorkspaceLink() {
        wait.until(ExpectedConditions.visibilityOf(getCreateWorkspaceContainer));
        createWorkspaceLink.click();
        return new Workspace();
    }

    /**
     * Method to do click on the button "Cancel" on the Form
     *
     */
    public void clickCancelCreateWorkspaceLink() {
        cancelCreateWorkspaceLink.click();
    }

    /**
     * Method that to insert a name into Workspace Name field
     * @param workspaceName
     * @return CreateWorkspace
     */
    public CreateWorkspace setWorkspaceName(String workspaceName) {
            workspaceNameTextField.sendKeys(workspaceName);
        return this;
    }

    /**
     * Method that to permit set values necesary to create a new Workspace
     * @param values
     * @return a Map with the values of the workspace created
     */
    public Map<WorkspaceSteps, IAutomationStep> getStrategyStepMap(Map<WorkspaceSteps, Object> values) {
        final Map<WorkspaceSteps, IAutomationStep> strategyMap = new HashMap<> ();
        strategyMap.put(WorkspaceSteps.WORKSPACE_NAME, () -> setWorkspaceName(String.valueOf(values.get(WorkspaceSteps.WORKSPACE_NAME))));
        return strategyMap;
    }

    /**
     * Method that get a mesage when a workspace try to be created with empty name
     * @return
     */
    public String getMessageWorkspaceNameEmpty() {
        return messageWorkspaceNameEmpty.getText();
    }
}
