package com.fundacionjala.pivotal.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import com.fundacionjala.pivotal.framework.util.PropertiesInfo;

import static com.fundacionjala.pivotal.framework.util.Constants.TOKEN_HEADER;
import static com.jayway.restassured.RestAssured.baseURI;

/**
 *
 */
public class Authentication {

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
        baseURI = PropertiesInfo.getInstance().getUrlApi();
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setProxy(PropertiesInfo.getInstance().getProxy())
                .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
