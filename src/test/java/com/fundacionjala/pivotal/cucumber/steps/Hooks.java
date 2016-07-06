package com.fundacionjala.pivotal.cucumber.steps;


import com.fundacionjala.pivotal.api.Mapper;

import cucumber.api.java.After;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.jayway.restassured.path.json.JsonPath.from;

public class Hooks {

    private static final int SUCCESS_STATUS_CODE = 200;

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String PROJECT_ID = "id";

    private static final int DELETE_STATUS_CODE = 204;

    ApiResources api;

    public Hooks(ApiResources api) {
        this.api = api;
    }

    @After("@project")
    public void afterProjectScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE) {
            deleteRequest(PROJECTS_ENDPOINT + from(api.getResponse().asString()).get(PROJECT_ID).toString());
        }
    }

    @After("@story")
    public void afterStoryScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE || api.getResponse().statusCode() == DELETE_STATUS_CODE) {
            deleteRequest(Mapper.mapUrlToDeleteProject(api.getEndPoint()));
        }
    }


}
