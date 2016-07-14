package com.fundacionjala.pivotal.cucumber.stepdefinition;


import com.fundacionjala.pivotal.api.Mapper;
import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;

import com.fundacionjala.pivotal.pages.BasePage;
import cucumber.api.java.After;
import org.apache.log4j.Logger;

import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static com.jayway.restassured.path.json.JsonPath.from;

public class Hooks {

    private Logger LOGGER = Logger.getLogger(BasePage.class.getSimpleName());

    private static final int SUCCESS_STATUS_CODE = 200;

    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String PROJECT_ID = "id";

    private static final int DELETE_STATUS_CODE = 204;

    ApiResourcesSteps api;

    public Hooks(ApiResourcesSteps api) {
        this.api = api;
    }

    @After("@project")
    public void afterProjectScenario() {
        LOGGER.info("status"+api.getResponse().statusCode());
        LOGGER.info("response"+api.getResponse().prettyPrint());
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
