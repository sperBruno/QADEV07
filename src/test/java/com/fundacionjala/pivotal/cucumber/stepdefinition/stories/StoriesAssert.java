package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.ToolBar;
import com.fundacionjala.pivotal.pages.stories.StoriesSteps;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 7/13/2016.
 */
public class StoriesAssert {

    private Response response;

    private StoriesStepsDef storiesStepsDef;
    
    private Dashboard dashboard;
    
    private ToolBar toolBar;

    public StoriesAssert(StoriesStepsDef storiesStepsDef) {
        this.storiesStepsDef = storiesStepsDef;
    }

    @Then("^I expect that (.*) be equals to (.*)")
    public void iExpectThatBeEqualsTo(StoriesSteps parameter, String value) {
        assertEquals(value, storiesStepsDef.getStory().getNameStory());
    }

    @Then("^I validate fields$")
    public void iValidateFields(final Map<StoriesSteps, Object> values) {
        dashboard = toolBar.clickOnDashboardLink();
    }
    
    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {

    }
}

