package com.fundacionjala.pivotal.stepdefinition;

import com.fundacionjala.pivotal.pages.CreateWorkspace;
import com.fundacionjala.pivotal.pages.Login;
import com.fundacionjala.pivotal.pages.Workspace;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Zeus on 07/07/2016.
 */
public class RequestWorkspaceStepDefs {

    private CreateWorkspace createWorkspace;
    private Workspace workspace;
    private RequestStepdefs requestStepdefs;

    public RequestWorkspaceStepDefs(RequestStepdefs requestStepDefs){
        this.requestStepdefs = requestStepDefs;
    }


    @Given("^I am on Pivotal Dashboard page$")
    public void iAmOnPivotalDashboardPage() {

    }

    @When("^click on the Create Workspace button of the (Dashboard|Form)$")
    public void iClickOnTheCreateWorkspaceButton(String page) {

        if (page.equalsIgnoreCase("Dashboard")) createWorkspace = Login.loginAsPrimaryUser ().clickCreateWorkspaceLink ();
        else workspace = createWorkspace.clickCreateWorkspaceLink();
    }

    @Given("^I am on Pivotal Create Workspace form$")
    public void iAmOnPivotalCreateWorkspaceForm() {
        createWorkspace = Login.loginAsPrimaryUser ().clickCreateWorkspaceLink ();
    }

    @When("^I fill with (.*) the name Workspace field$")
    public void iSendAPOSTRequestToMyWorkspacesWithAsNameWorkspace(String nameWorkspace){
        createWorkspace.setUserNameTestField(nameWorkspace);
    }

    public CreateWorkspace getCreateWorkspace() {
        return createWorkspace;
    }

    public Workspace getWorkspace() {
        return workspace;
    }
}
