package com.fundacionjala.pivotal.cucumber.stepdefinition.login;

import cucumber.api.java.en.Then;

import static com.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.junit.Assert.assertEquals;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class LoginAssert {

    private LoginStepDef projectsStepdefs;

    public LoginAssert(LoginStepDef projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }


    @Then("^It is expected that the display userName$")
    public void itIsExpectedThatTheDisplayUserName() {
        final String endPointProfile = "/me";
        final String fieldUsername = "username";
        final String expectUserName = getRequest(endPointProfile).jsonPath().get(fieldUsername);
        assertEquals(expectUserName.toUpperCase(), projectsStepdefs.getDashboard().getUserNameText());
    }
}
