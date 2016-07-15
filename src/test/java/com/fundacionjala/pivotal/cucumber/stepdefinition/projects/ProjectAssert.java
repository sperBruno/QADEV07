package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectAssert.class.getName());

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {
        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }

    @Then("^The project title should be equals (.*)$")
    public void theProjectTitleShouldBeEqualsProjectSeleniumTest(String expectedValue) {
        LOGGER.info("title project " + projectsStepDef.getProject().getTitle());
        assertEquals(expectedValue, projectsStepDef.getProject().getTitle());
    }

}
