package com.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel
 */

public class WorkspaceAssert {

    private WorkspaceStepDef workspaceStepDef;

    public WorkspaceAssert (WorkspaceStepDef workspaceStepDef) {
        this.workspaceStepDef = workspaceStepDef;
    }

    @Then("^I expect a Create Workspace form$")
    public void iExpectACreateWorkspaceForm () {
        assertNotNull (workspaceStepDef.getCreateWorkspace ());
        workspaceStepDef.getCreateWorkspace ().clickCancelCreateWorkspaceLink ();
    }

    @And("^the display name equals to (.*)$")
    public void theDisplayNameEqualsTo (String workspaceName) {
        assertEquals (workspaceName, workspaceStepDef.getWorkspace ().getWorkspaceNameText ());
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }

    @Then("^I expect a workspace with the project selected$")
    public void iExpectAWorkspaceWithTheProjectSelected () {
    }
}
