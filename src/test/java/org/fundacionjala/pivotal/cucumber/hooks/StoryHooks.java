package org.fundacionjala.pivotal.cucumber.hooks;


import cucumber.api.java.After;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.*;

public class StoryHooks {

    public static final String PROJECT_ID_STORY = "project_id";
    private ApiResourcesSteps api;

    private ToolBar toolBar;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
        toolBar = new ToolBar();
    }

    @After("@story")
    public void afterStoryScenario() {
        toolBar.clickReturnDashboardLink();
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode() || DELETE_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID_STORY).toString());
        }
        toolBar.refreshPage();
    }

    @After("@stories")
    public void afterProjectScenario() {
        toolBar.clickReturnDashboardLink();
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
        toolBar.refreshPage();
    }
}
