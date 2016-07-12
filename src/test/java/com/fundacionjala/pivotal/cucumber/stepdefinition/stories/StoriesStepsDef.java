package com.fundacionjala.pivotal.cucumber.stepdefinition.stories;

import java.util.Map;

import static com.fundacionjala.pivotal.pages.Login.loginAsPrimaryUser;

import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.Login;
import cucumber.api.PendingException;
import cucumber.api.java.ObjectFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by Charito on 7/9/2016.
 */
public class StoriesStepsDef {
    
    private Dashboard dashboard;
    
    @Given("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
    }

    @And("^I have a project with:$")
    public void iHaveAProjectWith(Map<String, Object> parameters) {
        
    }
    
}
