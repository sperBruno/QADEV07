package com.fundacionjala.PivotalFinalTest.api;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.path.json.JsonPath.from;

public class Mapper {
    private Mapper() {
    }

    public static String getField(Response response, String parameter) {
        return from(response.asString()).get(parameter).toString();
    }

    public static String mapEndpoint(String endPoint, Map<String, Response> listResponses) {
        Matcher matches = Pattern.compile("(?<=\\[)(.*?)(?=\\])").matcher(endPoint);
        StringBuffer newEndPoint = new StringBuffer();
        String replaceParameter = "";
        while (matches.find()) {
            String[] parametersParts = matches.group().split("\\.", 2);
            String parameter = parametersParts[0];
            String field = parametersParts[1];
            replaceParameter = Mapper.getField(listResponses.get(parameter), field);
            matches.appendReplacement(newEndPoint, replaceParameter);
        }
        matches.appendTail(newEndPoint);
        return newEndPoint.toString().replaceAll("[\\[\\]]", "");
    }

    public static String mapUrlToDeleteProject(String endPoint) {
        String projectUrlPart = "";
        Matcher matches = Pattern.compile("^(\\/.*?\\/.*?\\/)").matcher(endPoint);
        while (matches.find()) {
            projectUrlPart = matches.group();
        }
        return projectUrlPart;
    }
}
