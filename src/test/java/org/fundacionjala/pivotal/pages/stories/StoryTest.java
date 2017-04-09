package org.fundacionjala.pivotal.pages.stories;

import org.apache.commons.lang3.text.WordUtils;
import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.fundacionjala.pivotal.pages.Login;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * Created by bruno on 4/8/2017.
 */
public class StoryTest {
    private Dashboard dashboard;
    private Project project;

    /**
     * This before will be executed before a suite.
     */
    @BeforeSuite
    public void beforeSuite() {
        Login.loginAsPrimaryUser();
    }

    /**
     * This test will enter to a project.
     */
    @Test
    public void enterToAProject() {
        final String projectNameLink = "template";
        dashboard = new Dashboard();
        project = dashboard.clickOnProject(projectNameLink);
        Assert.assertTrue(project.isProjectTitleDisplayed());
        Assert.assertEquals(WordUtils.capitalize(projectNameLink), project.getTitle());
    }

    /**
     * This after suit will close the app.
     */
    @AfterSuite
    public void logoutPivotal() {
        CommonMethods.quitProgram("Closing the app");
    }
}
