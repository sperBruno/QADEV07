package com.fundacionjala.pivotal.stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class ResponseStepdefs {

    private RequestStepdefs projectsStepdefs;

    public ResponseStepdefs(RequestStepdefs projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }

    @Then("^It is expected that the display name equals (.*)$")
    public void itIsExpectedThatTheDisplayNameEqualsWALTER_MERCADO_JALA(String nameUser) {
        assertEquals(nameUser, projectsStepdefs.getDashboard().getUserNameText());
    }
}
