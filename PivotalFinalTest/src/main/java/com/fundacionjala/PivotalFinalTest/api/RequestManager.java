package com.fundacionjala.PivotalFinalTest.api;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class RequestManager {

    private static RequestSpecification REQUEST = Authentication.getInstance().getRequestSpecification();

    private RequestManager() {
    }

    public static Response getRequest(String endpoint) {
        return given().spec(REQUEST)
                .when().get(endpoint)
                .then().contentType(ContentType.JSON)
                .extract().response();

    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().post(endpoint)
                .then().contentType(ContentType.JSON)
                .extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().put(endpoint)
                .then().contentType(ContentType.JSON)
                .extract().response();
    }

    public static Response deleteRequest(String endpoint) {
        return given().spec(REQUEST).when().delete(endpoint);
    }
}

