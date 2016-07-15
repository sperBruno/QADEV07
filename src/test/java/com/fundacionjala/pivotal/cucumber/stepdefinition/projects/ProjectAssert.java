package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectSettingsStepDef projectSettingsStepDef) {

        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @And("^Validate all setting projects$")
    public void validateAllSettingProjects() {
        projectSettingsStepDef.getValuesMap().keySet().stream().forEach((step) -> {
            assertEquals(String.valueOf(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step)),projectSettingsStepDef.getValuesMap().get(step));
        });
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }

    @Then("^I expect a message Delete say (.*)$")
    public void iExpectAMessageDeleteSayProject1Name(String message) {
        String expectMessage = message.replace("project1.name",projectSettingsStepDef.getResponse().jsonPath().get("name"));
        assertEquals(expectMessage, projectSettingsStepDef.getDashboard().getMessageTextDelete());
    }
}
