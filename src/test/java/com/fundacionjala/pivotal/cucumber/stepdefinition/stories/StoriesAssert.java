package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import com.jayway.restassured.response.Response;
import com.fundacionjala.pivotal.cucumber.hooks.ProjectHooks;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import com.fundacionjala.pivotal.pages.dashboard.Dashboard;
import com.fundacionjala.pivotal.pages.dashboard.ToolBar;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 7/13/2016.
 */
public class StoriesAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());
    private static final int SUCCESS_STATUS_CODE = 200;

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String PROJECT_ID = "id";
    private Response response;

    private StoriesStepsDef storiesStepsDef;

    private Dashboard dashboard;

    private ToolBar toolBar;

    private ApiResourcesSteps api;

    public StoriesAssert(StoriesStepsDef storiesStepsDef, ApiResourcesSteps api) {
        this.storiesStepsDef = storiesStepsDef;
        this.api = api;
        toolBar = new ToolBar();
    }

    @Then("^I validate fields$")
    public void iValidateFields() {
        storiesStepsDef.getStoriesValues().keySet().stream().forEach((step) -> {
            assertEquals(storiesStepsDef.getStory().getAssertionMap().get(step), storiesStepsDef.getStoriesValues().get(step));
        });
        dashboard = toolBar.clickReturnDashboardLink();
    }

    @After("@projectStory")
    public void afterProjectScenario() {
        LOGGER.info("status" + api.getResponse().statusCode());
        LOGGER.info("response" + api.getResponse().prettyPrint());
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }

    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {
        assertEquals(message, storiesStepsDef.getStory().getStoryDeletedMessage());
        dashboard = toolBar.clickReturnDashboardLink();
    }
}
