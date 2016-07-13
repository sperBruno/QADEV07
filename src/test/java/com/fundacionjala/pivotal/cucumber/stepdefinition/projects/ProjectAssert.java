package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private ProjectsStepDef projectsStepDef;
    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @Then("^A project page with set title (.*) must appear$")
    public void aProjectPageWithSetTitleProjectSeleniumTestMustAppear(String expectedTitle) {
        assertEquals(expectedTitle, projectsStepDef.getProject().existsElement());
    }

    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {

        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());

    }
}
