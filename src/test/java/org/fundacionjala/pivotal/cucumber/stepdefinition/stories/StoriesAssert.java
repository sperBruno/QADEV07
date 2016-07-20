package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import com.jayway.restassured.response.Response;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.hooks.ProjectHooks;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.fundacionjala.pivotal.pages.stories.IceBox;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;

import static org.fundacionjala.pivotal.api.Mapper.mapResponse;
import static org.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * This class contains the assertions of Story test
 *
 * @author RosarioGarcia
 */
public class StoriesAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());

    private static final String PROJECTS_ENDPOINT = "/project/";

    private static final String PROJECT_ID = "id";

    private Response response;

    private StoriesStepsDef storiesStepsDef;

    private ApiResourcesSteps api;

    /**
     * Constructor class
     *
     * @param storiesStepsDef: steps before do assertion
     * @param api:             Object with elements from Api
     */
    public StoriesAssert(StoriesStepsDef storiesStepsDef, ApiResourcesSteps api) {
        this.storiesStepsDef = storiesStepsDef;
        this.api = api;
    }

    /**
     * Method to validate the fields created
     */
    @Then("^I validate fields$")
    public void iValidateFields() {
        storiesStepsDef.getStory().clickOnExpanderStory();
        storiesStepsDef.getStoriesValues().keySet().stream().forEach((step) -> {
            assertEquals(storiesStepsDef.getStory().getAssertionMap().get(step), storiesStepsDef.getStoriesValues().get(step));
        });
    }

    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {
        assertEquals(message, storiesStepsDef.getStory().getStoryDeletedMessage());
    }

    /**
     * Method to validate the message from delete test story
     */
    @After("@stories")
    public void afterProjectScenario() {
        ToolBar toolBar = new ToolBar();
        toolBar.clickReturnDashboardLink();
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode()) {
            //  RequestManager.deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }

    @Then("^I expect the alert (.*)$")
    public void iExpectTheAlertMessage(String message) {

        assertEquals(message, storiesStepsDef.getStory().getAddStoryTitleAlert());
    }

    @Then("^I expect the (.*) is displayed$")
    public void iExpectTheStoryNameIsDisplayed(String property) {
        String storyName = mapResponse(property);
        assertEquals(storyName, storiesStepsDef.getStory().getStoryTitle());

    }

    @Then("^I expect none story added$")
    public void iExpectNoneStoryAdded() {
        IceBox iceBox = new IceBox();
        assertEquals("(0, 0)", iceBox.getIceboxSection());
    }
}
