package org.fundacionjala.pivotal.cucumber.hooks;


import cucumber.api.java.After;
import org.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.api.RequestManager;

import static org.fundacionjala.pivotal.framework.util.Constants.DELETE_STATUS_CODE;
import static org.fundacionjala.pivotal.framework.util.Constants.SUCCESS_STATUS_CODE;

public class StoryHooks {

    private ApiResourcesSteps api;

    public StoryHooks(ApiResourcesSteps api) {
        this.api = api;
    }

    @After("@story")
    public void afterStoryScenario() {
        if (SUCCESS_STATUS_CODE == api.getResponse().statusCode() || DELETE_STATUS_CODE == api.getResponse().statusCode()) {
            RequestManager.deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));
        }
    }

}
