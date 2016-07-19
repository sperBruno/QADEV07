package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.hooks.ProjectHooks;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 7/13/2016.
 */
public class StoriesAssert {

    private static final Logger LOGGER = Logger.getLogger(ProjectHooks.class.getName());

    private Response response;

    private StoriesStepsDef storiesStepsDef;

    private ApiResourcesSteps api;

    public StoriesAssert(StoriesStepsDef storiesStepsDef, ApiResourcesSteps api) {
        this.storiesStepsDef = storiesStepsDef;
        this.api = api;
    }

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
}
