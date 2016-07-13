package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.pages.Settings;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {
    Response response;
    private ProjectsStepDef projectsStepDef;

    private Logger LOGGER = Logger.getLogger(ProjectAssert.class.getSimpleName());

    public ProjectAssert(ProjectsStepDef projectsStepDef) {
        this.projectsStepDef = projectsStepDef;
    }

    @Then("^A project page with set title (.*) must appear$")
    public void aProjectPageWithSetTitleProjectSeleniumTestMustAppear(String expectedTitle) {
        String title = projectsStepDef.getProject().getTitle();
        LOGGER.info("atual title "+title);
        assertEquals(expectedTitle, title);
    }

    @After
    public void tearDown(){
            Settings setting = projectsStepDef.getProject().clickSettingTab();
        String id="projects/"+setting.getProjectId();
        LOGGER.info("project id "+id );
        response = RequestManager.deleteRequest(id);
        LOGGER.info("status code "+response.getStatusCode());
    }

}
