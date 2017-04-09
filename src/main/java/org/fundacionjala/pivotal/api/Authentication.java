package org.fundacionjala.pivotal.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.fundacionjala.pivotal.framework.util.PropertiesInfo;

/**
 *
 */
public final class Authentication {

    private static Authentication instance;

    private RequestSpecification requestSpecification;

    private static final String TOKEN_HEADER = "X-TrackerToken";

    /**
     * This class will be used to have api authentication.
     */
    private Authentication() {
        initApi();
    }

    /**
     * This method will be used to get authentication instance.
     *
     * @return authentication intance.
     */
    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    /**
     * This method will initialise the init Api.
     */
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

    /**
     * This method will be used to a request specification.
     *
     * @return the request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
