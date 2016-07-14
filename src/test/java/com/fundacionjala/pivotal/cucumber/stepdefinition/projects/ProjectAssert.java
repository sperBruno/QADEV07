package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.pages.Setting;
import com.jayway.restassured.response.Response;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectAssert.class.getSimpleName());

    private Response response;

    private ProjectsStepDef projectsStepDef;

    private ProjectSettingsStepDef projectSettingsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef, ProjectSettingsStepDef projectSettingsStepDef) {
        this.projectsStepDef = projectsStepDef;
        this.projectSettingsStepDef = projectSettingsStepDef;
    }

    @Then("^A project page with set title (.*) must appear$")
    public void aProjectPageWithSetTitleProjectSeleniumTestMustAppear(String expectedTitle) {
        assertEquals(expectedTitle, projectsStepDef.getProject().getTitle());
    }

    @And("^The description projects should be equals (.*)$")
    public void theDescriptionProjectsShouldBeEqualsA(String expectedValue) {
        assertEquals(expectedValue, projectSettingsStepDef.getGeneralSettingForm().getDescriptionText());
    }

    @After
    public void tearDown() {
        Setting setting = projectsStepDef.getProject().clickSettingTab();
        String id = "projects/" + setting.getSideBar().clickGeneralSetting().getProjectId();
        LOGGER.info("project id " + id);
        response = RequestManager.deleteRequest(id);
        LOGGER.info("status code " + response.getStatusCode());
    }


}
