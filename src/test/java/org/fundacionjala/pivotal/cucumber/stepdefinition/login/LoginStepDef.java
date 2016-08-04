package org.fundacionjala.pivotal.cucumber.stepdefinition.login;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;

import cucumber.api.java.en.When;

import static org.fundacionjala.pivotal.pages.Login.loginAsPrimaryUser;

/**
 * @author mijhailvillarroel
 */
public class LoginStepDef {

    private Dashboard dashboard;

    @When("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
