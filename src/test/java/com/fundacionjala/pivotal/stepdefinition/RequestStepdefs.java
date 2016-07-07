package com.fundacionjala.pivotal.stepdefinition;

import com.fundacionjala.pivotal.pages.Dashboard;
import com.fundacionjala.pivotal.pages.Login;
import com.fundacionjala.pivotal.pages.PivotalHome;
import com.fundacionjala.pivotal.framework.util.PropertiesInfo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class RequestStepdefs {
    PivotalHome pivotalHome;
    private Login login;
    private Dashboard dashboard;

    @Given("^Load the home page pivotal$")
    public void loadTheHomePagePivotal() {
        pivotalHome = new PivotalHome();
    }

    @When("^I click on the SigIn button$")
    public void iClickOnTheSigInButton() {
        login = pivotalHome.clickSingInLink();
    }

    @And("^It show the login form$")
    public void itShowTheLoginForm() {

    }

    @And("^I click the next button$")
    public void iClickTheNextButton() {
        login.clickNextButton();
    }

    @When("^I type a password valid in input field$")
    public void iTypePSswRdInThePasswordInputField() {
        login.setPasswordTestField(PropertiesInfo.getInstance().getPassword());
    }

    @And("^I click the login button$")
    public void iClickTheLoginButton() {
        dashboard = login.clickSignInButton();
    }

    @When("^I type in the username input field$")
    public void iTypeInTheUsernameInputField() {
        login.setUserNameTestField(PropertiesInfo.getInstance().getEmail());
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
