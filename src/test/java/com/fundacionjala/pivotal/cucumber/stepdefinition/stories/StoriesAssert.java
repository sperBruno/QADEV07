package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import com.fundacionjala.pivotal.cucumber.hooks.ProjectHooks;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.ToolBar;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECT_ID;
import static com.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 7/13/2016.
 */
public class StoriesAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());

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
        storiesStepsDef.getStory().clickOnExpanderStory();
        storiesStepsDef.getStoriesValues().keySet().stream().forEach((step) -> {
            assertEquals(storiesStepsDef.getStory().getAssertionMap().get(step), storiesStepsDef.getStoriesValues().get(step));
        });
        dashboard = toolBar.clickReturnDashboardLink();
    }

    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {
        assertEquals(message, storiesStepsDef.getStory().getStoryDeletedMessage());
        dashboard = toolBar.clickReturnDashboardLink();
    }
    @After("@stories")
    public void afterProjectScenario() {
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }


}
