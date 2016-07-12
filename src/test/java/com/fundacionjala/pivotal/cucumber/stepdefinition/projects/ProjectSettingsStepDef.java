package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.Map;

import com.fundacionjala.pivotal.api.Mapper;
import com.fundacionjala.pivotal.cucumber.stepdefinition.apisteps.ApiResourcesSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class ProjectSettingsStepDef {

    private ApiResourcesSteps apiResourcesSteps;

    public ProjectSettingsStepDef(ApiResourcesSteps apiResourcesSteps) {
        this.apiResourcesSteps = apiResourcesSteps;
    }

    @When("^I click (.*) settings$")
    public void iClickProjectIdSettings(String projectName) {
        String project = Mapper.mapEndpoint(projectName,apiResourcesSteps.getListResponses());

    }

    @And("^I update general setting for (.*)$")
    public void iUpdateGeneralSettingForProject(String projectsName,  Map<String, Object> values) {
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
    }
}
