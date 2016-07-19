package org.fundacionjala.pivotal.cucumber.hooks;


import cucumber.api.java.After;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.framework.util.Constants.*;

public class StoryHooks {

    private ApiResourcesSteps api;
    private Dashboard dashboard;

    private ToolBar toolBar;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
        toolBar = new ToolBar();
    }

    public void returdashboard(){
        dashboard = toolBar.clickReturnDashboardLink();

    }

    @After("@story")
    public void afterStoryScenario() {
        returdashboard();
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode() || DELETE_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get("project_id").toString());
            //RequestManager.deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));

        }
        //dashboard.refreshPage();
    }

    @After("@stories")
    public void afterProjectScenario() {
        dashboard = toolBar.clickReturnDashboardLink();
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
        //dashboard.refreshPage();
    }
}
