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
        assertEquals(expectedTitle,projectsStepDef.getProject().getTitle());
    }

    @After
    public void tearDown(){
            Settings setting = projectsStepDef.getProject().clickSettingTab();
      response  = RequestManager.deleteRequest("propjects/" + setting.getProjectId());
    }

}
