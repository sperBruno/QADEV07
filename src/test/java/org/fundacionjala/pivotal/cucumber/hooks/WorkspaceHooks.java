package org.fundacionjala.pivotal.cucumber.hooks;

import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.stepdefinition.workspace.WorkspaceStepDef;
import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.fundacionjala.pivotal.pages.workspace.Workspace;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.deleteAllProjects;

/**
 * Created by DanielGonzales
 */
public class WorkspaceHooks {

    private static final String WORKSPACES_ENDPOINT = "/my/workspaces/";

    private WorkspaceStepDef workspaceStepDef;

    public WorkspaceHooks(WorkspaceStepDef workspaceStepDef) {
        this.workspaceStepDef = workspaceStepDef;
    }

    /**
     * This method hook is used after a workspace is created using selenium.
     */
    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
        Workspace workspace = workspaceStepDef.getWorkspace();
        String endPointDeleteWorkspace = WORKSPACES_ENDPOINT.concat(workspace.getIdWorkspace());
        RequestManager.deleteRequest(endPointDeleteWorkspace);
        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
    }

    /**
     * This method hook to perform a cleanup enviroment.
     */
    @Before("@CleanEnviroment")
    public void deleteAllWorkspaces() {
        deleteAllProjects();
        CommonMethods.deleteAllWorkspaces();
    }

    /**
     * This method hook to return to Dashboard page.
     */
    @After("@ReturnDashboard")
    public void returnDashboard() {
        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
    }
}
