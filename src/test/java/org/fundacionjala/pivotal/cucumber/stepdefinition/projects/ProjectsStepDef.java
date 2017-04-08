package org.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.Map;

import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.pages.dashboard.CreateProject;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectSteps;

import cucumber.api.java.en.Given;

/**
 * This class is used to execute the step of project scenarios.
 *
 * @author Bruno Barrios.
 */
public class ProjectsStepDef {

    private LoginStepDef loginStepDef;

    private CreateProject createProject;

    private Project project;

    private Map<ProjectSteps, Object> valuesMap;

    /**
     * This class receives LoginStepDef as a parameter.
     *
     * @param loginStepDef
     */
    public ProjectsStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    /**
     * This method is used to create a project.
     *
     * @param values are the required parameters to create a Project.
     */
    @Given("^I create a new project$")
    public void iCreateANewProject(Map<ProjectSteps, Object> values) {
        this.valuesMap = values;
        createProject = loginStepDef.getDashboard().clickCreateProjectLink();
        valuesMap.keySet().stream().forEach(step -> createProject.getStrategyStepMap(valuesMap).get(step).executeStep());
        project = createProject.clickCreateProject();
    }

    public Project getProject() {
        return project;
    }

    public CreateProject getCreateProject() {
        return createProject;
    }


}
