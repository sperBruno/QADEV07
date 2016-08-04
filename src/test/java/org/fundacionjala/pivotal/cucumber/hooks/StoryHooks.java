package org.fundacionjala.pivotal.cucumber.hooks;


import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;

import cucumber.api.java.After;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.DASHBOARD_URL;
import static org.fundacionjala.pivotal.framework.util.Constants.DELETE_STATUS_CODE;
import static org.fundacionjala.pivotal.framework.util.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;

public class StoryHooks {

    public static final Logger LOGGER = Logger.getLogger(StoryHooks.class.getName());
    public static final String PROJECT_ID_STORY = "project_id";
    private ApiResourcesSteps api;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
    }

    /**
     * Method to delete a project after do edit and delete test of a story
     */
    @After("@story")
    public void afterStoryScenario() {
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode() || DELETE_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID_STORY).toString());
            LOGGER.info("Response from story Hook: " + api.getResponse().prettyPrint());
        }
    }

    @After("@dashboard")
    public void goToaDashboard() {
        DriverManager.getInstance().getDriver().get(DASHBOARD_URL);
        DriverManager.getInstance().getDriver().navigate().refresh();
    }
}
