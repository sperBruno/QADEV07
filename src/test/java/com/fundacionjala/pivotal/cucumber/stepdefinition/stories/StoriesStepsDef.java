package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.fundacionjala.pivotal.cucumber.stepdefinition.apisteps.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.IAutomationStep;
import com.fundacionjala.pivotal.pages.Project;
import com.fundacionjala.pivotal.pages.SideBarStories;
import com.fundacionjala.pivotal.pages.StoriesSteps;
import com.fundacionjala.pivotal.pages.Story;

import static com.fundacionjala.pivotal.pages.StoriesSteps.STORY_TITLE;

/**
 * Created by Charito on 7/9/2016.
 */
public class StoriesStepsDef {

    private ApiResourcesSteps apiResourcesSteps;

    private LoginStepDef loginStepDef;
    private Story story;
    private Project project;


    public StoriesStepsDef(ApiResourcesSteps apiResourcesSteps, LoginStepDef loginStepDef) {
        this.apiResourcesSteps = apiResourcesSteps;
        this.loginStepDef = loginStepDef;
    }

    @Given("^I enter to (.*)$")
    public void iEnterTo(String projectName) throws Throwable {
        project = loginStepDef.getDashboard().clickOnProject(projectName);
    }

    @And("^I create a new story$")
    public void iCreateANewStory(Map<StoriesSteps, Object> parameters) {
        SideBarStories sideBarStories = new SideBarStories();
        story = sideBarStories.clickOnAddStoryButton();
        executeSteps(parameters, story);
        story.clickOnSaveStoryButton();
    }

    private void executeSteps(final Map<StoriesSteps, Object> values, Story story) {
        Map<StoriesSteps, IAutomationStep> strategyMap = new HashMap<StoriesSteps, IAutomationStep>();
        strategyMap.put(STORY_TITLE, () -> story.setStoryNameTextarea(values.get(STORY_TITLE).toString()));

        for (StoriesSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

    @Then("^I expect a new Story$")
    public void iExpectANewStory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
