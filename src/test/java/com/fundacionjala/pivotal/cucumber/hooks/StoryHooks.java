package com.fundacionjala.pivotal.cucumber.hooks;


import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import cucumber.api.java.After;

import static com.fundacionjala.pivotal.api.Mapper.mapUrlToDeleteProject;
import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;

public class StoryHooks {

    private static final int SUCCESS_STATUS_CODE = 200;

    private static final int DELETE_STATUS_CODE = 204;

    private ApiResourcesSteps api;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
    }

    @After("@story")
    public void afterStoryScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE || api.getResponse().statusCode() == DELETE_STATUS_CODE) {
            deleteRequest(mapUrlToDeleteProject(api.getEndPoint()));
        }
    }

}
