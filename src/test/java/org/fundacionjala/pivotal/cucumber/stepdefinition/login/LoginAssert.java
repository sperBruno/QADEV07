package org.fundacionjala.pivotal.cucumber.stepdefinition.login;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.api.RequestManager;
import org.junit.Assert;

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
        final String expectUserName = RequestManager.getRequest(endPointProfile).jsonPath().get(fieldUsername);
        Assert.assertEquals(expectUserName.toUpperCase(), projectsStepdefs.getDashboard().getUserNameText());
    }
}
