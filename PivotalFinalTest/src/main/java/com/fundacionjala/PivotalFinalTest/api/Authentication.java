package com.fundacionjala.PivotalFinalTest.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;

public class Authentication {

    private static final String TOKEN_HEADER = "X-TrackerToken";

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getBaseUrl();
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setProxy(PropertiesInfo.getInstance().getProxy())
                .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getToken())
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
