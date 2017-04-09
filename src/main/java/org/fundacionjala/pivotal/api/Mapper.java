package org.fundacionjala.pivotal.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.response.Response;

import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_BRACKETS;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_INSIDE_BRACKETS;

/**
 * This class will be used to map endpoint request.
 */
public final class Mapper {

    private static final String REGEX_KEY = "\\[(.*?)\\.";

    private static final String REGEX_VALUE = "\\.(.*?)\\]";

    private static final String REGEX_REPLACE = "\\[(.*?)\\]";

    private static final String REGEX_HALF_BRACKET = "[";

    private static final int INDEX_1 = 1;

    private static final int INDEX_2 = 2;

    private static final String REGEX_BLACK_SPACE = " ";

    private static final Map<String, Response> RESPONSE_VALUES = new HashMap<>();

    /**
     * This is a private constructor.
     */
    private Mapper() {
    }

    /**
     * Method to format the endpoint with the ids specified.
     *
     * @param endPoint endpoint with Key and Value to replace.
     * @return the new endpoint with ids.
     */
    public static String mapEndpoint(String endPoint) {
        String result = endPoint;
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            Pattern keyEndpoint = Pattern.compile(REGEX_KEY);
            Matcher mKey = keyEndpoint.matcher(result);
            Pattern valueEndpoint = Pattern.compile(REGEX_VALUE);
            Matcher mValue = valueEndpoint.matcher(result);
            while (mKey.find() && mValue.find()) {
                final int groupRegex = 1;
                String key = mKey.group(groupRegex);
                String value = mValue.group(groupRegex);
                result = result.replaceFirst(REGEX_REPLACE, RESPONSE_VALUES.get(key).jsonPath().get(value).toString());
            }
        }
        return result;
    }

    /**
     * This class will be used to add an api Response.
     * @param key  of the response.
     * @param response value.
     */
    public static void addResponse(String key, Response response) {
        RESPONSE_VALUES.put(key, response);
    }

    /**
     * This method will get all project properties.
     * @param endPoint to make the request.
     * @return the current property.
     */
    public static String getPropertiesProject(String endPoint) {
        String result = endPoint;
        if (result.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : result.split(REGEX_BLACK_SPACE)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    value.append(RESPONSE_VALUES.get(mapString[INDEX_1]).jsonPath().get(mapString[INDEX_2]).toString());
                    result = result.replace(endPointSplit, value);
                }
            }
        }
        return result;
    }

    /**
     * Method to get the property specified from response saved.
     *
     * @param property property to get.
     * @return property.
     */
    public static String mapResponse(String property) {
        String result = property;
        if (result.contains(REGEX_HALF_BRACKET)) {
            Pattern keyEndpoint = Pattern.compile(REGEX_KEY);
            Matcher mKey = keyEndpoint.matcher(result);
            Pattern valueEndpoint = Pattern.compile(REGEX_VALUE);
            Matcher mValue = valueEndpoint.matcher(result);
            while (mKey.find() && mValue.find()) {
                final int groupRegex = 1;
                String key = mKey.group(groupRegex);
                String value = mValue.group(groupRegex);
                result = RESPONSE_VALUES.get(key).jsonPath().get(value).toString();
            }
        }
        return result;
    }
}
