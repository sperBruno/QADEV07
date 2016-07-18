package com.fundacionjala.pivotal.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

/**
 * @author Henrry Salinas && Mijhail Villarroel
 *
 * The purpose of this class is to provide methods that handle a string as end point
 */
public final class Mapper {

    private static final String REGEX_INSIDE_BRACKETS = "[\\[]+[\\w.]+[^\\(]+\\]";

    private static final String REGEX_HALF_BRACKET = "[";

    private static final String REGEX_BRACKETS = "^\\[|\\]|\\.";

    private static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";

    private static final String EMPTY_STRING = "";

    private static final String REGEX_SLASH = "/";

    private static Map<String, Response> responseValues = new HashMap<>();;

    private Mapper() {
    }

    /**
     * Given a string with a pattern like /endpoint/[key.value] this method should return that string as a valid endpoint
     * @param endPoint
     * @return a string as endpoint
     */
    public static String mapEndpoint(String endPoint) {
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : endPoint.split(REGEX_SLASH)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    String toAdd = responseValues.get(mapString[1]).jsonPath().get(mapString[2]);
                    value.append(toAdd);
                    endPoint = endPoint.replace(endPointSplit, value);
                }
            }
        }
        return endPoint;
    }

    public static String mapUrlToDeleteProject(String endPoint) {
        Matcher matches = Pattern.compile(REGEX_UNTIL_PROJECT).matcher(endPoint);
        return matches.find() ? matches.group() : EMPTY_STRING;
    }

    public static void addResponse(String key, Response response) {
        responseValues.put(key, response);
    }
}
