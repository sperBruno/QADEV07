package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.stories.SideBarStories;
import org.fundacionjala.pivotal.pages.stories.StoriesSteps;
import org.fundacionjala.pivotal.pages.stories.Story;

import static org.fundacionjala.pivotal.api.Mapper.mapProject;

/**
 * @author RosarioGarcia
 */
public class StoriesStepsDef {

    private static Project project;
    private Logger LOGGER = Logger.getLogger(BasePage.class.getSimpleName());
    private LoginStepDef loginStepDef;
    private Story story;
    private Map<StoriesSteps, Object> storiesValues;

    public StoriesStepsDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
        story = new Story();
    }

    public static Project getProject() {
        return project;
    }

    @Given("^I enter to (.*)$")
    public void iEnterTo(String projectProperty) {
        String name = mapProject(projectProperty);
        project = loginStepDef.getDashboard().clickOnProject(name);
    }

    @And("^I create a new story$")
    public void iCreateANewStory(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        SideBarStories sideBarStories = new SideBarStories();
        story = sideBarStories.clickOnAddStoryButton();
        story.executeSteps(values);
        story.clickOnSaveStoryButton();
    }

    @When("^I delete the story created$")
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
}
