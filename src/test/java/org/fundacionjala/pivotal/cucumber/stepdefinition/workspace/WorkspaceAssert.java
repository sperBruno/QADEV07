package org.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.cucumber.hooks.WorkspaceHooks;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel
 */

public class WorkspaceAssert {

    private WorkspaceStepDef workspaceStepDef;

    private WorkspaceHooks workspaceHooks;

    private static final String SAVED_MESSAGE = "Changes saved.";

    public WorkspaceAssert(WorkspaceStepDef workspaceStepDef, WorkspaceHooks workspaceHooks) {
        this.workspaceStepDef = workspaceStepDef;
        this.workspaceHooks = workspaceHooks;
    }

    @And("^the display name equals to workspace created$")
    public void theDisplayNameEqualsTo() {
        workspaceStepDef.getValuesMap().keySet().stream().forEach(step -> assertEquals(String.valueOf(workspaceStepDef.getWorkspace().getAssertionMap().get(step)), workspaceStepDef.getValuesMap().get(step)));
        workspaceHooks.deleteWorkspace();
    }

    @Then("^A message displayed: (.*)$")
    public void aMessageDisplayedWorkspaceNameCanTBeBlank(String message) {
        assertEquals(message, workspaceStepDef.getCreateWorkspace().getMessageWorkspaceNameEmpty());
        workspaceStepDef.getCreateWorkspace().clickCancelCreateWorkspaceLink();
        workspaceHooks.deleteWorkspace();
    }

    @Then("^I expect a workspace with the (.*) project name$")
    public void iExpectAWorkspaceWithTheProjectSelected(String nameProject) {
        String finalNameProject = Mapper.getPropertiesProject(nameProject);
        assertEquals(finalNameProject.toUpperCase(), workspaceStepDef.getWorkspace().getProjectIntoWorkspaceNameText());
        workspaceHooks.deleteWorkspace();
    }

    @Then("^I expect the next message: (.*)$")
    public void iExpectTheNextMessageWorkspaceWasSuccessfullyDeleted(String message) {
        if (SAVED_MESSAGE.equalsIgnoreCase(message)) {
            assertEquals(message, workspaceStepDef.getSettingWorkspace().getMessageChangesWorkspace());
        } else {
            String expectMessage = Mapper.getPropertiesProject(message);
            assertEquals(expectMessage, workspaceStepDef.getDashboard().getMessageDeleteWorkspace());
        }
    }
}
