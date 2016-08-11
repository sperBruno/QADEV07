package org.fundacionjala.pivotal.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import org.fundacionjala.pivotal.framework.util.PropertiesInfo;


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
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                .build();
        requestSpecification.baseUri(PropertiesInfo.getInstance().getUrlApi());
        if (PropertiesInfo.getInstance().getProxy() != null) {
            requestSpecification.proxy(PropertiesInfo.getInstance().getProxy());
        }
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
