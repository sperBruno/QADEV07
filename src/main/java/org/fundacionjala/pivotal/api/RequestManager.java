package org.fundacionjala.pivotal.api;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * The purpose of this class is to provide methods that manage the API REST
 * requests like GET, POST, PUT, and DELETE.
 *
 * @author Henrry Salinas.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST = Authentication.getInstance().getRequestSpecification();

    /**
     * This is Request Manager private constructor.
     */
    private RequestManager() {
    }

    /**
     * This method will be used to make get requests.
     * @param endpoint to make get request.
     * @return a request response.
     */
    public static Response getRequest(String endpoint) {
        return given().spec(REQUEST)
                .when().get(endpoint);
    }

    /**
     * This method will be used to make post requests.
     * @param endpoint to make post request.
     * @param parameters to make post request.
     * @return a request response.
     */
    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().post(endpoint);
    }

    /**
     * This method will be used to make put requests.
     * @param endpoint to make put request.
     * @param parameters to make put request.
     * @return a request response.
     */
    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().put(endpoint);
    }

    /**
     * This method will be used to make delete requests.
     * @param endpoint to make delete request.
     * @return a request response.
     */
    public static Response deleteRequest(String endpoint) {
        return given().spec(REQUEST).when().delete(endpoint);
    }
}
