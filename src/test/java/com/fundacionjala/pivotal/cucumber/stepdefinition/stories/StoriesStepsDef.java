package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.BasePage;
import com.fundacionjala.pivotal.pages.Project;
import com.fundacionjala.pivotal.pages.stories.SideBarStories;
import com.fundacionjala.pivotal.pages.stories.StoriesSteps;
import com.fundacionjala.pivotal.pages.stories.Story;

/**
 * Created by Charito on 7/9/2016.
 */
public class StoriesStepsDef {

    private Logger LOGGER = Logger.getLogger(BasePage.class.getSimpleName());
    private LoginStepDef loginStepDef;
    private Story story;
    private static Project project;
    private Map<StoriesSteps, Object> storiesValues;

    public StoriesStepsDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @Given("^I enter to (.*)$")
    public void iEnterTo(String projectName) {
        project = loginStepDef.getDashboard().clickOnProject(projectName);
    }

    @And("^I create a new story$")
    public void iCreateANewStory(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        SideBarStories sideBarStories = new SideBarStories();
        story = sideBarStories.clickOnAddStoryButton();
        story.executeSteps(values);
        story.clickOnSaveStoryButton();
    }

    @When("^I delete the (.*) created$")
    public void iDeleteTheStoryCreated() {
        story.clickOnExpanderStory();
        story.clickOnDeleteStoryButton();
        story.clickOnConfirmDeleteStoryButton();
    }

    public Story getStory() {
        return story;
    }

    public Map<StoriesSteps, Object> getStoriesValues() {
        return storiesValues;
    }

    @When("^I edit the next parameter$")
    public void iEditTheNextParameter(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        story.clickOnExpanderStory();
        storiesValues.keySet().stream().forEach((step) -> {
            story.executeSteps(storiesValues);
        });
        story.clickOnCloseStoryButton();
    }

    public static Project getProject() {
        return project;
    }
}
