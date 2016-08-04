package org.fundacionjala.pivotal.cucumber.stepdefinition.login;

import org.fundacionjala.pivotal.api.RequestManager;
import org.junit.Assert;

import cucumber.api.java.en.Then;

/**
 * @author mijhailvillarroel
 */
public class LoginAssert {

    private LoginStepDef projectsStepdefs;

    public LoginAssert(LoginStepDef projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }


    @Then("^I expect the userName is displayed$")
    public void itIsExpectedThatTheDisplayUserName() {
        final String endPointProfile = "/me";
        final String fieldUsername = "username";
        final String expectUserName = RequestManager.getRequest(endPointProfile).jsonPath().get(fieldUsername);
        Assert.assertEquals(expectUserName.toUpperCase(), projectsStepdefs.getDashboard().getUserNameText());
    }
}
