package com.fundacionjala.pivotal.runner;

//we need to specific which framework to use. By default junit built for cucumber is a simple way to start

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//as with most junit frameworks, we need to specify the junit runner

//this is a cucumber annotation dictating the cucumber runner
@RunWith(Cucumber.class)
//this is how we want the results formatted. The only customizable line, different formats can be added or removed. I’ve included the most common ones for convenience
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber2.json"},
        features = {"src/test/resources/com.fundacionjala.pivotal.stepdefinition.feature/"},
        glue = {"com.fundacionjala.pivotal.cucumber.stepdefinition"}
)
//this is an empty class to run with. This needs to remain empty
public class GenericTest {
    public GenericTest(){

    }
}
