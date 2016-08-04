package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.pages.stories.IceBox;

import cucumber.api.java.en.Then;

import static org.fundacionjala.pivotal.api.Mapper.mapResponse;
import static org.junit.Assert.assertEquals;

/**
 * This class contains the assertions of Story test
 *
 * @author RosarioGarcia
 */
public class StoriesAssert {

    private StoriesStepsDef storiesStepsDef;

    /**
     * Constructor class
     *
     * @param storiesStepsDef: steps before do assertion
     * @param api:             Object with elements from Api
     */
    public StoriesAssert(StoriesStepsDef storiesStepsDef, ApiResourcesSteps api) {
        this.storiesStepsDef = storiesStepsDef;
    }

    /**
     * Method to validate the fields created
     */
    @Then("^I validate fields$")
    public void iValidateFields() {
        storiesStepsDef.getStory().clickOnExpanderStory();
        storiesStepsDef.getStoriesValues().keySet().stream().forEach(step -> assertEquals(storiesStepsDef.getStory().getAssertionMap().get(step), storiesStepsDef.getStoriesValues().get(step)));
    }

    @Then("^I expect the message (.*)$")
    public void iExpectTheMessageStoryDeleted(String message) {
        assertEquals(message, storiesStepsDef.getStory().getStoryDeletedMessage());
    }

    @Then("^I expect the alert (.*)$")
    public void iExpectTheAlertMessage(String message) {

        assertEquals(message, storiesStepsDef.getStory().getAddStoryTitleAlert());
    }

    @Then("^I expect the (.*) is show$")
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
