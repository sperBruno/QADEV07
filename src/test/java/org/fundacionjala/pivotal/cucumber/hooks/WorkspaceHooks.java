package org.fundacionjala.pivotal.cucumber.hooks;

import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.stepdefinition.workspace.WorkspaceStepDef;
import org.fundacionjala.pivotal.pages.workspace.Workspace;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.deleteAllProjects;
import static org.fundacionjala.pivotal.framework.util.CommonMethods.deleteAllWorkspaces;

/**
 * Created by DanielGonzales
 */
public class WorkspaceHooks {

    private static final String WORKSPACES_ENDPOINT = "/my/workspaces/";

    private WorkspaceStepDef workspaceStepDef;

    public WorkspaceHooks(WorkspaceStepDef workspaceStepDef) {
        this.workspaceStepDef = workspaceStepDef;
    }

    @After("@DeleteWorkspace")
    public void DeleteWorkspace() {
        Workspace workspace = workspaceStepDef.getWorkspace();
        String endPointDeleteWorkspace = WORKSPACES_ENDPOINT.concat (workspace.getIdWorkspace());
        Response response = RequestManager.deleteRequest(endPointDeleteWorkspace);
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }

    @Before("@CleanEnviroment")
    public void DeleteAllWorkspaces() {
        deleteAllProjects ();
        deleteAllWorkspaces();
    }

    @After("@ReturnDashboard")
    public void ReturnDashboard() {
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }
}
