package com.fundacionjala.pivotal.cucumber.hooks;


import cucumber.api.java.After;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;

import static com.fundacionjala.pivotal.api.Mapper.mapUrlToDeleteProject;
import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.fundacionjala.pivotal.framework.util.Constants.*;
import static com.jayway.restassured.path.json.JsonPath.from;

public class StoryHooks {

    private ApiResourcesSteps api;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
    }

    @After("@story")
    public void afterStoryScenario() {
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode() || DELETE_STATUS_CODE == api.getResponse().statusCode()) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get("project_id").toString());
           // deleteRequest(mapUrlToDeleteProject(api.getEndPoint()));
        }
    }



}
