package org.fundacionjala.pivotal.api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_BRACKETS;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_INSIDE_BRACKETS;

public final class Mapper {

    private static final String REGEX_KEY = "\\[(.*?)\\.";

    private static final String REGEX_VALUE = "\\.(.*?)\\]";

    private static final String REGEX_REPLACE = "\\[(.*?)\\]";

    private static final String REGEX_HALF_BRACKET = "[";

    private static final int INDEX_1 = 1;

    private static final int INDEX_2 = 2;

    private static final String REGEX_BLACK_SPACE = " ";

    private static final Map<String, Response> RESPONSE_VALUES = new HashMap<>();

    private Mapper() {
    }

    /**
     * Method to format the endpoint with the ids specified
     *
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
                endPoint = endPoint.replaceFirst(REGEX_REPLACE, RESPONSE_VALUES.get(key).jsonPath().get(value).toString());
            }
        }
        return endPoint;
    }

    public static void addResponse(String key, Response response) {
        RESPONSE_VALUES.put(key, response);
    }

    public static String getPropertiesProject(String endPoint) {
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : endPoint.split(REGEX_BLACK_SPACE)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    value.append(RESPONSE_VALUES.get(mapString[INDEX_1]).jsonPath().get(mapString[INDEX_2]).toString());
                    endPoint = endPoint.replace(endPointSplit, value);
                }
            }
        }
        return endPoint;
    }

    /**
     * Method to get the property specified from response saved
     *
     * @param property property to get
     * @return property
     */
    public static String mapResponse(String property) {
        if (property.contains(REGEX_HALF_BRACKET)) {
            Pattern keyEndpoint = Pattern.compile(REGEX_KEY);
            Matcher mKey = keyEndpoint.matcher(property);
            Pattern valueEndpoint = Pattern.compile(REGEX_VALUE);
            Matcher mValue = valueEndpoint.matcher(property);
            while (mKey.find() && mValue.find()) {
                final int groupRegex = 1;
                String key = mKey.group(groupRegex);
                String value = mValue.group(groupRegex);
                property = RESPONSE_VALUES.get(key).jsonPath().get(value).toString();
            }
        }
        return property;
    }
}
