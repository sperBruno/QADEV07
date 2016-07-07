package com.fundacionjala.pivotal.stepdefinition;

import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.Login;
import com.fundacionjala.pivotal.pages.PivotalHome;
import cucumber.api.java.en.When;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class RequestStepdefs {
    PivotalHome pivotalHome;
    private Login login;
    private Dashboard dashboard;

    @When("^I login with credentials valid$")
    public void iLoginWithCredentialsValid () {
        dashboard = Login.loginAsPrimaryUser ();
    }
    public Dashboard getDashboard() {
        return dashboard;
    }
}
