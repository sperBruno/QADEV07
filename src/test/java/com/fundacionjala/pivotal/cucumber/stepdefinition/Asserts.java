package com.fundacionjala.pivotal.cucumber.stepdefinition;

import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;

import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;

public class Asserts {

    private ApiResourcesSteps api;

    public Asserts(ApiResourcesSteps api) {
        this.api = api;
    }

    @And("^The (?:project|story) name should be equals? to (.*)$")
    public void theProjectShouldBeUpdated(String expectedName) {
        assertEquals(expectedName, api.getResponse().path("name"));
    }
}
