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

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.*;
import static org.testng.AssertJUnit.assertEquals;


/**
 * Created by bruno on 4/8/2017.
 */
public class StoryTest {
    Dashboard dashboard;
    Project project;
    Story story;
    SideBarStories sideBarStories;

    @BeforeSuite
    public void beforeSuite() {
        Login.loginAsPrimaryUser();
    }

    @Test
    public void enterToAProject() {
        final String projectNameLink = "template";
        dashboard = new Dashboard();
        project = dashboard.clickOnProject(projectNameLink);
        Assert.assertTrue(project.isProjectTitleDisplayed());
        Assert.assertEquals(WordUtils.capitalize(projectNameLink), project.getTitle());
    }

    @Test
    public void createStoryInProject() {
        Map<StoriesSteps, Object> storyValues = new HashMap<>();
        storyValues.put(STORY_TITLE, "storyTest");
        storyValues.put(STORY_TYPE, "bug");
        storyValues.put(DESCRIPTION, "descriptionTest");
        storyValues.put(LABELS, "labeltest");
        storyValues.put(COMMENT, "commentTest");
        sideBarStories = new SideBarStories();
        story = sideBarStories.clickOnAddStoryButton();
        story.strategyStepMap(storyValues);

        story.clickOnExpanderStory();
        storyValues.keySet().stream().forEach((step) -> {
            assertEquals(story.getAssertionMap().get(step), storyValues.get(step));
        });
    }

    @AfterSuite
    public void logoutPivotal() {
        CommonMethods.quitProgram("Closing the app");
    }
}