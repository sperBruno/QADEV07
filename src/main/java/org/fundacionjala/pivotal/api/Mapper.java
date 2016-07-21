package org.fundacionjala.pivotal.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;
import org.fundacionjala.pivotal.pages.setting.SettingSteps;

import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_BRACKETS;
import static org.fundacionjala.pivotal.framework.util.Constants.REGEX_INSIDE_BRACKETS;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.DATE_NAME;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.PROJECT_START_DATE;
import static org.fundacionjala.pivotal.pages.setting.SettingSteps.START_ITERATIONS_ON;

public final class Mapper {

    public static final String REGEX_KEY = "\\[(.*?)\\.";

    public static final String REGEX_VALUE = "\\.(.*?)\\]";

    public static final String REGEX_REPLACE = "\\[(.*?)\\]";

    private static final String REGEX_HALF_BRACKET = "[";

    private static final String REGEX_UNTIL_PROJECT = "^(\\/.*?\\/.*?\\/)";

    private static final String EMPTY_STRING = "";

    private static final int INDEX_1 = 1;

    private static final int INDEX_2 = 2;

    private static final String REGEX_BLACK_SPACE = " ";

    private static final Map<String, Response> RESPONSE_VALUES = new HashMap<>();

    private Mapper() {
    }

    /**
     * Method to format the enpoint with the ids specified
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

    public static String mapUrlToDeleteProject(String endPoint) {
        Matcher matches = Pattern.compile(REGEX_UNTIL_PROJECT).matcher(endPoint);
        return matches.find() ? matches.group() : EMPTY_STRING;
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

    public static String getMassage(String endPoint, Map<SettingSteps, Object> values) {
        String nameDay = dayName(String.valueOf(values.get(PROJECT_START_DATE)));
        Map<SettingSteps, Object> copy = new HashMap<SettingSteps, Object>(values);
        copy.put(DATE_NAME, nameDay);
        final String point="s.";
        if (endPoint.contains(REGEX_HALF_BRACKET)) {
            for (String endPointSplit : endPoint.split(REGEX_BLACK_SPACE)) {
                if (endPointSplit.matches(REGEX_INSIDE_BRACKETS)) {
                    String[] mapString = endPointSplit.split(REGEX_BRACKETS);
                    StringBuilder value = new StringBuilder();
                    value.append(copy.get(SettingSteps.valueOf(mapString[INDEX_1])));
                    endPoint = endPoint.replace(endPointSplit, value);
                }
            }
        }
        return endPoint.concat(point);
    }

    public static void main(String args[]){
        Map<SettingSteps, Object> v= new HashMap<>();
        v.put(START_ITERATIONS_ON,"Saturday");
        v.put(PROJECT_START_DATE,"7/24/2016 ");
        System.out.println( getMassage("[PROJECT_START_DATE.Value] is a [DATE_NAME.nameDay] and Iterations in this project start on [START_ITERATIONS_ON.value]",v));

    }

    public static String dayName(String inputDate){
        String a=inputDate;
        Date date = null;
        final String format = "YYYY/MM/DD";
        try {
            date = new SimpleDateFormat(format).parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
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
