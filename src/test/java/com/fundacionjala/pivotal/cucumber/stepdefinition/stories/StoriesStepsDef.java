package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.HashMap;
import java.util.Map;

import static com.fundacionjala.pivotal.pages.Login.loginAsPrimaryUser;
import static com.fundacionjala.pivotal.pages.StoriesSteps.STORY_TITLE;

import com.fundacionjala.pivotal.cucumber.stepdefinition.apisteps.ApiResourcesSteps;
import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.ObjectFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Ma;

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
}
