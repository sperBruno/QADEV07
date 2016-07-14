package com.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.CreateWorkspace;
import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.Workspace;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Daniel on 07/07/2016.
 */
public class WorkspaceStepDef {

    private static final String DASHBOARD = "Dashboard";

    private CreateWorkspace createWorkspace;

    private Workspace workspace;

    private Dashboard dashboard;

    private LoginStepDef loginStepDef;

    public WorkspaceStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @Given("^I am on Pivotal Dashboard page$")
    public void iAmOnPivotalDashboardPage() {
        dashboard = loginStepDef.getDashboard();
    }

    @When("^click on the Create Workspace button of the (Dashboard|Form)$")
    public void iClickOnTheCreateWorkspaceButton(String page) {

        if (DASHBOARD.equalsIgnoreCase(page)) {
            createWorkspace = dashboard.clickCreateWorkspaceLink();
        } else {
            workspace = createWorkspace.clickCreateWorkspaceLink();
        }
    }

    @Given("^I am on Pivotal Create Workspace form$")
    public void iAmOnPivotalCreateWorkspaceForm() {
        createWorkspace = dashboard.clickCreateWorkspaceLink();
    }

    @When("^I fill with (.*) the name Workspace field$")
    public void iSendAPOSTRequestToMyWorkspacesWithAsNameWorkspace(String nameWorkspace) {
        createWorkspace.setUserNameTestField(nameWorkspace);
    }

    public CreateWorkspace getCreateWorkspace() {
        return createWorkspace;
    }

    public Workspace getWorkspace() {
        return workspace;
    }
}
