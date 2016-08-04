package org.fundacionjala.pivotal.jbehave;

import java.util.Stack;

import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.Steps;

import static org.fundacionjala.pivotal.pages.login.Login.loginAsPrimaryUser;

/**
 * Created by mijhailvillarroel on 8/2/2016.
 */
public class LoginBehaveSteps extends Steps {
    private Stack<String> stack;


    @Given("I login with valid credentials")
    public void iLoginWithValidCredentials() {
//        dashboard = loginAsPrimaryUser();
//        dashboard.refreshPage ();
    }

    @Then("the stack should have $number elements")
    public void assertElementCount(int elementCount) {
        // assertThat(stack.size(), equalTo(elementCount));
        Assert.assertEquals(stack.size(), elementCount);
    }

    @Then("I expect the userName is displayed")
    public void iExpectTheUserNameIsDisplayed(int elementCount) {
        // assertThat(stack.size(), equalTo(elementCount));
        Assert.assertEquals(stack.size(), elementCount);
    }
}
