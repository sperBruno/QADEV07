package com.fundacionjala.pivotal.cucumber.steps;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.pivotal.api.RequestManager;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.fundacionjala.pivotal.api.Mapper.mapEndpoint;
import static com.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.junit.Assert.assertEquals;

public class ApiResources {

    private Response response;

    private Map<String, Object> parameters;

    private Map<String, Response> listResponses;

    private String endPoint;

    public ApiResources() {
        listResponses = new HashMap<String, Response>();
    }

    @And("^I have the (.*) endpoint$")
    public void iHaveTheEndpoint(String endPoint) {
        this.endPoint = mapEndpoint(endPoint, listResponses);
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I sen(?:d|t) a POST request$")
    public void iSendAPOSTRequest() {
        response = RequestManager.postRequest(endPoint, parameters);
    }

    @When("^I send a DELETE request$")
    public void iSendADELETERequest() {
        response = RequestManager.deleteRequest(endPoint);
    }

    @When("^I send a PUT request$")
    public void iSendAPUTRequest() {
        response = RequestManager.putRequest(endPoint, parameters);
    }

    @And("^stored as (.*)")
    public void storedAsProject(String key) {
        listResponses.put(key, response);
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, response.statusCode());
    }

    @Given("^I have the next parameters:$")
    public void iHaveTheNextParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Response getResponse() {
        return response;
    }


    public String getEndPoint() {
        return endPoint;
    }

}
