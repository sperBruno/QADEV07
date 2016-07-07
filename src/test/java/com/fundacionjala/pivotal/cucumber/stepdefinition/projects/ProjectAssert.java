package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectAssert {

    private ProjectsStepDef projectsStepDef;

    public ProjectAssert(ProjectsStepDef projectsStepDef){
        this.projectsStepDef=projectsStepDef;
    }

    @Then("^A project page with set title (.*) must appear$")
    public void aProjectPageWithSetTitleProjectSeleniumTestMustAppear(String expectedTitle) {
        assertEquals(expectedTitle,projectsStepDef.getProject().existsElement());
    }
}
