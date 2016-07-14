package com.fundacionjala.pivotal.api;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.path.json.JsonPath.from;

public final class Mapper {

    private static final String REGEX_INSIDE_BRACKETS = "[\\[]+[\\w.]+[^\\(]+\\]";

    private static final String REGEX_HALF_BRACKET= "[";

    private static final String REGEX_BRACKETS = "^\\[|\\]|\\.";

    private static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";

    private static final String EMPTY_STRING = "";

    private static final String REGEX_SLASH = "/";

    private Mapper() {
    }

    public static String getField(Response response, String parameter) {
        return from(response.asString()).get(parameter).toString();
    }

    public static String mapEndpoint(String endPoint, Map<String, Response> responseValues) {
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            for (String endPontSplit : endPoint.split(REGEX_SLASH)) {
                if (endPontSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPontSplit.split(REGEX_BRACKETS);
                    StringBuilder value =new StringBuilder();
                    value.append(responseValues.get(mapString[1]).jsonPath().get(mapString[2]).toString());
                    endPoint = endPoint.replace(endPontSplit, value);
                }
            }
        }
        return endPoint;
    }

    public static String mapUrlToDeleteProject(String endPoint) {
        Matcher matches = Pattern.compile(REGEX_UNTIL_PROJECT).matcher(endPoint);
        return matches.find() ? matches.group() : EMPTY_STRING;
    }
}
