package org.fundacionjala.pivotal.cucumber.hooks;


import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.*;

public class StoryHooks {

    public static final Logger LOGGER = Logger.getLogger(StoryHooks.class.getName());
    public static final String PROJECT_ID_STORY = "project_id";
    private ApiResourcesSteps api;

    private ToolBar toolBar;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
        toolBar = new ToolBar();
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
        DriverManager.getInstance().getDriver().get(DASHBOARD_URL);
    }
}
