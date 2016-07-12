package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import static com.fundacionjala.pivotal.pages.Login.loginAsPrimaryUser;

import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.Icebox;
import com.fundacionjala.pivotal.pages.Login;
import com.fundacionjala.pivotal.pages.Story;
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
    
    private Dashboard dashboard;
    private Icebox icebox;
    private Story story;
    
    public StoriesStepsDef() {
        icebox = new Icebox();
    }
    
    @Given("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
    }


    @Given("^I stay in the main page of project$")
    public void iStayInTheMainPageOfProject() {
        
    }

    @Then("^I press on newStory button$")
    public void iPressOnNewStoryButton() throws Throwable {
        icebox.clickOnAddStoryButton();
    }

    @And("^I fill the story name text with$")
    public void iFillTheStoryNameTextWith(Map<String, Object> parameters) {
        icebox.setStoryNameTextarea(parameters.get("name").toString());
    }

    @Then("^I expect a new Story$")
    public void iExpectANewStory() {
        story = icebox.clickOnSaveStoryButton();
    }
}
