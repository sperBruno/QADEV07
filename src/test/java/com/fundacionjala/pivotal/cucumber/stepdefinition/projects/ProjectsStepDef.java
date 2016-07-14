package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;

import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.CreateProject;
import com.fundacionjala.pivotal.pages.IAutomationStep;
import com.fundacionjala.pivotal.pages.Project;
import com.fundacionjala.pivotal.pages.ProjectSteps;

import static com.fundacionjala.pivotal.pages.ProjectSteps.PROJECT_TITLE;
import static com.fundacionjala.pivotal.pages.ProjectSteps.PROJECT_ACCOUNT;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectsStepDef {
    private LoginStepDef loginStepDef;

    private CreateProject createProject;

    private Project project;

    public ProjectsStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @Given("^I create a new project$")
    public void iCreateANewProject(Map<ProjectSteps, Object> values) {
        createProject = loginStepDef.getDashboard().clickCreateProjectLink();
        executeSteps(values, createProject);
        project = createProject.clickCreateProject();
    }

    private void executeSteps(Map<ProjectSteps, Object> values, CreateProject generalCreateProjectForm) {
        Map<ProjectSteps, IAutomationStep> strategyMap = new HashMap<ProjectSteps, IAutomationStep>();
        strategyMap.put(PROJECT_TITLE, () -> generalCreateProjectForm.setProjectName(values.get(PROJECT_TITLE).toString()));
        strategyMap.put(PROJECT_ACCOUNT, () -> generalCreateProjectForm.setAccountDropDown(values.get(PROJECT_ACCOUNT).toString()));
        for (ProjectSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

    public Project getProject() {
        return project;
    }
}
