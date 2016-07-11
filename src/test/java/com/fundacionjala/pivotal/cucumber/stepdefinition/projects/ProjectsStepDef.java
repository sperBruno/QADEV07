package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.CreateProject;
import com.fundacionjala.pivotal.pages.Project;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

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

    @When("^I click on create project$")
    public void iClickOnCreateProject() {
        createProject = loginStepDef.getDashboard().clickCreateProjectLink();
    }

    @And("^I fill the project title text box with (.*)$")
    public void iFillTheProjectTitleTextBoxWithProjectSeleniumTest(String titleProject) {
        createProject.setProjectName(titleProject);
    }

    @And("^I choose an account by default$")
    public void iChooseAnAccountByDefault() {
        createProject.setAccount();
    }

    @And("^I click on create Project button$")
    public void iClickOnCreateProjectButton() {
        createProject.clickCreateProject();
    }

    public Project getProject() {
        return project;
    }


}
