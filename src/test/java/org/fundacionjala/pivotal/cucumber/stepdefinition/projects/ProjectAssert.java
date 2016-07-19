package org.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;

import org.fundacionjala.pivotal.api.Mapper;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to validate all the scenarios related to a Project.
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectAssert.class.getName());

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    /**
     * This class receives ProjectStepDef and ProjectSettingsStepDef as parameters.
     *
     * @param projectsStepDef
     * @param projectSettingsStepDef
     */
    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    /**
     * This class is used to validate whether the project description is equals as an expected
     * project description.
     *
     * @param expectedValue is the expected description of the project
     */
    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {
        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());
    }

    @Then("^I expect a message say (.*)$")
    public void iExpectAMessageChangeSaved(String messageSay) {
        assertEquals(messageSay, projectSettingsStepDef.getGeneralSettingForm().getMessageTest());
    }

    @Then("^I expect a message Delete say (.*)$")
    public void iExpectAMessageDeleteSayProject1Name(String message) {
        final String expectMessage = Mapper.getPropertiesProject(message);
        assertEquals(expectMessage, projectSettingsStepDef.getDashboard().getMessageTextDelete());
    }

    /**
     * This class is used to validate whether the project name is equals as expected project name.
     *
     * @param expectedValue is the expected project name or title.
     */
    @Then("^The project title should be equals (.*)$")
    public void theProjectTitleShouldBeEqualsProjectSeleniumTest(String expectedValue) {
        LOGGER.info("title project " + projectsStepDef.getProject().getTitle());
        Assert.assertEquals(expectedValue, projectsStepDef.getProject().getTitle());
    }

    @And("^Validate all setting projects$")
    public void validateAllSettingProjects() {
        projectSettingsStepDef.getValuesMap().keySet().stream().forEach((step) -> {
            System.out.println(String.valueOf(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step)));
            System.out.println(projectSettingsStepDef.getValuesMap().get(step));
            assertEquals(String.valueOf(projectSettingsStepDef.getGeneralSettingForm().getAssertionMap().get(step)), projectSettingsStepDef.getValuesMap().get(step));
        });
        projectSettingsStepDef.getSetting().getToolBar().clickReturnDashboardLink();
    }
}
