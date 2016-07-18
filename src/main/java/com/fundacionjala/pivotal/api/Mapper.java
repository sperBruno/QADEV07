package com.fundacionjala.pivotal.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

import static com.fundacionjala.pivotal.framework.util.Constants.EMPTY_STRING;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECT_1;
import static com.fundacionjala.pivotal.framework.util.Constants.PROJECT_ID;
import static com.fundacionjala.pivotal.framework.util.Constants.REGEX_BRACKETS;
import static com.fundacionjala.pivotal.framework.util.Constants.REGEX_HALF_BRACKET;
import static com.fundacionjala.pivotal.framework.util.Constants.REGEX_INSIDE_BRACKETS;
import static com.fundacionjala.pivotal.framework.util.Constants.REGEX_SLASH;
import static com.fundacionjala.pivotal.framework.util.Constants.REGEX_UNTIL_PROJECT;

public final class Mapper {

    private static final int INDEX_1 = 1;

    private static final int INDEX_2 = 2;

    public static final String REGEX_BLACK_SPACE = " ";

    private static Map<String, Response> responseValues = new HashMap<>();;
    ;

    private Mapper() {
    }

    public static String mapEndpoint(String endPoint) {
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : endPoint.split(REGEX_SLASH)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    String toAdd = responseValues.get(mapString[INDEX_1]).jsonPath().get(mapString[INDEX_2]);
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
        System.out.println(response.prettyPrint());
        responseValues.put(key, response);
        System.out.println(String.valueOf(responseValues.get(PROJECT_1).jsonPath().get(PROJECT_ID)));
    }
}
