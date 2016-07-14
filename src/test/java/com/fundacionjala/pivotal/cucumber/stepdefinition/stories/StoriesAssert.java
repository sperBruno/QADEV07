package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import com.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectSettingsStepDef;
import com.fundacionjala.pivotal.cucumber.stepdefinition.projects.ProjectsStepDef;
import com.fundacionjala.pivotal.pages.StoriesSteps;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 7/13/2016.
 */
public class StoriesAssert {

    private Response response;

    private StoriesStepsDef storiesStepsDef;

    public StoriesAssert(StoriesStepsDef storiesStepsDef) {
        this.storiesStepsDef = storiesStepsDef;
    }

    @Then("^I expect that (.*) be equals to (.*)")
    public void iExpectThatBeEqualsTo(StoriesSteps parameter, String value) {
        assertEquals(value, storiesStepsDef.getStory().getNameStory());
    }

    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {

    }
}

