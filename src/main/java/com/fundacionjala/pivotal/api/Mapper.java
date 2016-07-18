package com.fundacionjala.pivotal.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

public final class Mapper {

    private static final String REGEX_INSIDE_BRACKETS = "[\\[]+[\\w.]+[^\\(]+\\]";

    private static final String REGEX_HALF_BRACKET = "[";

    private static final String REGEX_BRACKETS = "^\\[|\\]|\\.";

    private static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";

    private static final String EMPTY_STRING = "";

    private static final String REGEX_SLASH = "/";


    public static final String REGEX_KEY = "\\[(.*?)\\.";
    public static final String REGEX_VALUE = "\\.(.*?)\\]";
    public static final String REGEX_REPLACE = "\\[(.*?)\\]";

    private static Map<String, Response> responseValues;

    private Mapper() {
    }
    
    public static String mapEndpoint(String endPoint) {
        System.out.println("mapper endpoint: " + endPoint);
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            System.out.println("response values mapper enpoint:");
            System.out.println(responseValues.get("Project1").prettyPrint());
//            for (String endPointSplit : endPoint.split(REGEX_SLASH)) {
//                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
//                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
//                    StringBuilder value = new StringBuilder();
//                    value.append(responseValues.get("Project1").jsonPath().get("id").toString());
//                    endPoint = endPoint.replace(endPointSplit, value);
//                }
//            }
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
        System.out.println("enpoint result: " + endPoint);
        return endPoint;
    }

    public static String mapUrlToDeleteProject(String endPoint) {
        Matcher matches = Pattern.compile(REGEX_UNTIL_PROJECT).matcher(endPoint);
        return matches.find() ? matches.group() : EMPTY_STRING;
    }

    public static void addResponse(String key, Response response) {
        System.out.println("response in mapper:");
        System.out.println(response.prettyPrint());
        responseValues = new HashMap<>();
        responseValues.put(key, response);
        System.out.println("response values");
        System.out.println(responseValues.get("Project1").prettyPrint());
    }
}
