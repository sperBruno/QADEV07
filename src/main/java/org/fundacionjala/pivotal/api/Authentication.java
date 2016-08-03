package org.fundacionjala.pivotal.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import org.fundacionjala.pivotal.framework.util.PropertiesInfo;

import static com.jayway.restassured.RestAssured.baseURI;

/**
 *
 */
public class Authentication {

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private static final String TOKEN_HEADER = "X-TrackerToken";

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
        if (PropertiesInfo.getInstance().getProxy() != null) {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .setProxy(PropertiesInfo.getInstance().getProxy())
                    .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                    .build();
        } else {
            requestSpecification = new RequestSpecBuilder()
                    .setRelaxedHTTPSValidation()
                    .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                    .build();
        }
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
