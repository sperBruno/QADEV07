package org.fundacionjala.pivotal.pages.workspace;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     *
     * @return Workspaces
     */
    public Workspace clickCreateWorkspaceLink() {
        createWorkspaceLink.click();
        return new Workspace();
    }

    public void clickCancelCreateWorkspaceLink() {
        cancelCreateWorkspaceLink.click();
    }

    public CreateWorkspace setWorkspaceName(String workspaceName) {
            workspaceNameTextField.sendKeys(workspaceName);
        return this;
    }

    public Map<WorkspaceSteps, IAutomationStep> getStrategyStepMap(Map<WorkspaceSteps, Object> values) {
        final Map<WorkspaceSteps, IAutomationStep> strategyMap = new HashMap<WorkspaceSteps, IAutomationStep> ();
        strategyMap.put(WorkspaceSteps.WORKSPACE_NAME, () -> setWorkspaceName(String.valueOf(values.get(WorkspaceSteps.WORKSPACE_NAME))));
        return strategyMap;
    }

    public String getMessageWorkspaceNameEmpty() {
        return messageWorkspaceNameEmpty.getText();
    }
}
