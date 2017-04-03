package org.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.stories.SideBarStories;
import org.fundacionjala.pivotal.pages.stories.StoriesSteps;
import org.fundacionjala.pivotal.pages.stories.Story;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.fundacionjala.pivotal.api.Mapper.mapResponse;

/**
 * @author RosarioGarcia
 */
public class StoriesStepsDef {

    private Project project;

    private Story story;

    private Map<StoriesSteps, Object> storiesValues;

    private SideBarStories sideBarStories;

    public StoriesStepsDef() {
        story = new Story();
        sideBarStories = new SideBarStories();
    }

    public Project getProject() {
        return project;
    }

    @Given("^I enter to (.*)$")
    public void iEnterTo(String projectProperty) {
        DriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/dashboard");
        Dashboard dashboard = new Dashboard();
        String name = mapResponse(projectProperty);
        project = dashboard.clickOnProject(name);
    }

    @And("^I create a new story$")
    public void iCreateANewStory(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        story = sideBarStories.clickOnAddStoryButton();
        story.strategyStepMap(values);
        story.clickOnSaveStoryButton();
    }

    @When("^I delete the story created$")
    public void iDeleteTheStoryCreated() {
        story.clickOnExpanderStory();
        story.clickOnDeleteStoryButton();
        story.clickOnConfirmDeleteStoryButton();
    }

    @When("^I edit the next parameter$")
    public void iEditTheNextParameter(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        story.clickOnExpanderStory();
        storiesValues.keySet().stream().forEach(step -> story.strategyStepMap(storiesValues));
        story.clickOnCloseStoryButton();
    }

    @When("^I create a new story without title")
    public void iCreateANewStoryWithoutTitle() {
        story = sideBarStories.clickOnAddStoryButton();
        story.clickOnSaveStoryButton();
    }

    @When("^I cancel delete the story created$")
    public void iCancelDeleteTheStoryCreated() {
        story.clickOnExpanderStory();
        story.clickOnDeleteStoryButton();
        story.clickOnCancelDeleteButton();
    }

    public Story getStory() {
        return story;
    }

    public Map<StoriesSteps, Object> getStoriesValues() {
        return storiesValues;
    }

    @When("^I fill parameters to new story$")
    public void iFillParametersToNewStory(Map<StoriesSteps, Object> values) {
        this.storiesValues = values;
        story = sideBarStories.clickOnAddStoryButton();
        story.strategyStepMap(values);
        story.cancelAddStory();
    }

}
