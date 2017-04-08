package org.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import java.util.Map;

import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.pages.workspace.DeleteWorkspace;
import org.fundacionjala.pivotal.pages.workspace.SettingWorkspace;
import org.fundacionjala.pivotal.pages.workspace.SideBarWorkspace;
import org.fundacionjala.pivotal.pages.workspace.Workspace;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Daniel Gonzales
 */
public class WorkspaceStepDef {

    private CreateWorkspace createWorkspace;

    private Workspace workspace;

    private Dashboard dashboard;

    private SideBarWorkspace sideBarWorkspace;

    private LoginStepDef loginStepDef;

    private SettingWorkspace settingWorkspace;

    private Map<WorkspaceSteps, Object> valuesMap;

    public WorkspaceStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @When("^click on the Create Workspace button$")
    public void iClickOnTheCreateWorkspaceButton() {
        workspace = createWorkspace.clickCreateWorkspaceLink();
        sideBarWorkspace = workspace.getSideWorkspace();
    }

    @Given("^I create a new Workspace$")
    public void iAmOnPivotalCreateWorkspaceForm(Map<WorkspaceSteps, Object> values) {
        dashboard = loginStepDef.getDashboard();
        this.valuesMap = values;
        createWorkspace = dashboard.clickCreateWorkspaceLink();
        valuesMap.keySet().stream().forEach(step -> createWorkspace.getStrategyStepMap(valuesMap).get(step).executeStep());
    }

    @When("^I click on Add Projects button$")
    public void iClickOnAddProjectsButton() {
        sideBarWorkspace.clickAddProjectLink();
    }

    @And("^I select the (.*) project created previously$")
    public void iSelectTheProjectCreatedPreviously(String nameProject) {
        String finalNameProject = Mapper.getPropertiesProject(nameProject);
        sideBarWorkspace.clickListProjectLink();
        sideBarWorkspace.clickProjectNameLink(finalNameProject);
    }

    @And("^I click on Save Workspace button$")
    public void iClickOnSaveWorkspaceButton() {
        workspace = sideBarWorkspace.clickSaveWorkspaceLink();
    }

    @Given("^I click on (.*) created$")
    public void iClickOnWorkspace(String nameWorkspace) {
        dashboard = loginStepDef.getDashboard();
        String finalNameWorkspace = Mapper.getPropertiesProject(nameWorkspace);
        workspace = loginStepDef.getDashboard().clickNameWorkspaceLink(finalNameWorkspace);
    }

    @When("^I click on Settings of SideBar$")
    public void iClickOnSettingsOfSideBar() {
        settingWorkspace = workspace.getToolBarWorkspace().clickSettingsWorkspaceLink();
    }

    @And("^I click on Delete link and confirm$")
    public void iClickOnDeleteLink() {
        DeleteWorkspace deleteWorkspace = settingWorkspace.clickDeleteWorkspaceLink();
        dashboard = deleteWorkspace.clickConfirmDeleteLink();
    }

    @When("^I edit the name with: (.*)$")
    public void iEditTheNameWithWorkspace(String newName) {
        settingWorkspace.setNameWorkspaceTestField(newName);
    }

    @And("^I click on Save button$")
    public void iClickOnSaveButton() {
        settingWorkspace.clickSaveChangesWorkspaceLink();
    }

    public CreateWorkspace getCreateWorkspace() {
        return createWorkspace;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public SettingWorkspace getSettingWorkspace() {
        return settingWorkspace;
    }

    public Map<WorkspaceSteps, Object> getValuesMap() {
        return valuesMap;
    }
}
