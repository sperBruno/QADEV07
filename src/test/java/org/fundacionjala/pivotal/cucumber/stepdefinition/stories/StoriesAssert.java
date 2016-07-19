package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.hooks.ProjectHooks;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECT_ID;
import static org.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * This class contains the assertions of Story test
 * @author RosarioGarcia
 */
public class StoriesAssert {

    private static final Logger LOGGER = Logger.getLogger(StoriesAssert.class.getName());

    private Response response;

    private StoriesStepsDef storiesStepsDef;

    private ApiResourcesSteps api;

    /**
     * Constructor class
     *
     * @param storiesStepsDef steps before do assertion
     * @param api Object with elements from Api
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
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }
}
