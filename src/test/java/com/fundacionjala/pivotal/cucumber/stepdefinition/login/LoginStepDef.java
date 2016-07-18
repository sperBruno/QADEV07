package com.fundacionjala.pivotal.cucumber.stepdefinition.login;

import com.fundacionjala.pivotal.pages.dashboard.Dashboard;
import cucumber.api.java.en.When;

import static com.fundacionjala.pivotal.pages.login.Login.loginAsPrimaryUser;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class LoginStepDef {

    private Dashboard dashboard;

    @When("^I login with credentials valid$")
    public void iLoginWithCredentialsValid() {
        dashboard = loginAsPrimaryUser();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
