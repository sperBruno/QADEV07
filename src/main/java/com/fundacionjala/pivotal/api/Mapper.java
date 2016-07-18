package com.fundacionjala.pivotal.api;

import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Mapper {

    public static final String REGEX_KEY = "\\[(.*?)\\.";
    public static final String REGEX_VALUE = "\\.(.*?)\\]";
    public static final String REGEX_REPLACE = "\\[(.*?)\\]";
    private static final String REGEX_HALF_BRACKET = "[";
    private static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";
    private static final String EMPTY_STRING = "";
    private static Map<String, Response> responseValues;

    private Mapper() {
    }

    /**
     * Method to format the enpoint with the ids specified
     * @param endPoint: endpoint with Key and Value to replace
     * @return: the new endpoint with ids
     */
    public static String mapEndpoint(String endPoint) {
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            Pattern keyEndpoint = Pattern.compile(REGEX_KEY);
            Matcher mKey = keyEndpoint.matcher(endPoint);
            Pattern valueEndpoint = Pattern.compile(REGEX_VALUE);
            Matcher mValue = valueEndpoint.matcher(endPoint);
            while (mKey.find() && mValue.find()) {
                final int groupRegex = 1;
                String key = mKey.group(groupRegex);
                String value = mValue.group(groupRegex);
                endPoint = endPoint.replaceFirst(REGEX_REPLACE, responseValues.get(key).jsonPath().get(value).toString());
            }
        }
        return endPoint;
    }

    public static String mapUrlToDeleteProject(String endPoint) {
        Matcher matches = Pattern.compile(REGEX_UNTIL_PROJECT).matcher(endPoint);
        return matches.find() ? matches.group() : EMPTY_STRING;
    }

    public static void addResponse(String key, Response response) {
        responseValues = new HashMap<>();
        responseValues.put(key, response);
    }
}
