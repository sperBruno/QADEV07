package com.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel
 */

public class WorkspaceAssert {

    private WorkspaceStepDef requestWorkspaceStepDefs;

    public WorkspaceAssert (WorkspaceStepDef requestWorkspaceStepDefs) {
        this.requestWorkspaceStepDefs = requestWorkspaceStepDefs;
    }

    @Then("^I expect a Create Workspace form$")
    public void iExpectACreateWorkspaceForm () {
        assertNotNull (requestWorkspaceStepDefs.getCreateWorkspace ());
        requestWorkspaceStepDefs.getCreateWorkspace ().clickCancelCreateWorkspaceLink ();
    }

    @And("^the display name equals to (.*)$")
    public void theDisplayNameEqualsTo (String workspaceName) {
        assertEquals (workspaceName, requestWorkspaceStepDefs.getWorkspace ().getWorkspaceNameText ());
        requestWorkspaceStepDefs.getWorkspace ().clickReturnDashboardLink ();
    }
}
