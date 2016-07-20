package org.fundacionjala.pivotal.cucumber.stepdefinition.login;

import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;

import static org.fundacionjala.pivotal.pages.login.Login.loginAsPrimaryUser;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class LoginStepDef {

    private Dashboard dashboard;

    @When("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
        dashboard.refreshPage ();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
