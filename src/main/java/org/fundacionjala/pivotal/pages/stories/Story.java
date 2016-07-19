package org.fundacionjala.pivotal.pages.stories;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.STORY_TITLE;
import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.DESCRIPTION;
import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.LABELS;
import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.COMMENT;

/**
 * This class is for test the creation, set and delete
 * of a story in a project of pivotal tracker.
 *
 * @author RosarioGarcia
 */
public class Story extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Story.class.getName());

    /**
     * Web elements to add story
     */
    @FindBy(name = "story[name]")
    private WebElement storyTitleTextArea;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveStoryButton;

    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    private WebElement cancelCreateStoryButton;

    @FindBy(xpath = "//button[contains(.,'(edit)')]")
    private WebElement editDescriptionButton;

    @FindBy(css = ".rendered_description.tracker_markup")
    private WebElement descriptionText;

    @FindBy(name = "story[pending_description]")
    private WebElement storyDescriptionTextField;

    @FindBy(xpath = "//button[contains(.,'Done')]")
    private WebElement doneDescriptionButton;

    @FindBy(name = "label[name]")
    private WebElement label;

    @FindBy(css = ".autosaves.label.name")
    private WebElement labelName;

    @FindBy(name = "comment[text]")
    private WebElement comment;

    @FindBy(xpath = "//button[@data-aid='comment-submit']")
    private WebElement addCommentButton;

    @FindBy(xpath = "//div[data-aid='message']")
    private WebElement comentMessage;

    /**
     * Web elements to set story
     */
    @FindBy(xpath = "//button[contains(.,'Close')]")
    private WebElement closeButton;

    /**
     * Web elements to delete story
     */
    @FindBy(css = ".expander.undraggable")
    private WebElement storyExpander;

    @FindBy(xpath = "//button[@title='Delete this story']")
    private WebElement deleteStoryButton;

    @FindBy(xpath = "//button[@data-aid='DeleteButton']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//li[contains(.,'1 story deleted')]")
    private WebElement storyDeletedMessage;

    @FindBy(xpath = "//button[@data-aid='CancelButton']")
    private WebElement cancelDeleteButton;

    private String commentMesage;

    /**
     * This method is for set the story title text field
     * wich contains the name of a story.
     *
     * @param storyTitle it is the name for a story
     */
    public void setStoryTitleTextArea(String storyTitle) {
        storyTitleTextArea.clear();
        storyTitleTextArea.sendKeys(storyTitle);
    }

    /**
     * This method is for set the description text field
     * wich contains the description of a story.
     *
     * @param storyDescription it is the description for a story
     */
    public void setDescriptionTextarea(String storyDescription) {
        editDescriptionButton.click();
        storyDescriptionTextField.clear();
        storyDescriptionTextField.sendKeys(storyDescription);
        doneDescriptionButton.click();
    }

    public Story clickOnSaveStoryButton() {
        saveStoryButton.click();
        return this;
    }

    public Story clickOnCloseStoryButton() {
        closeButton.click();
        return this;
    }

    public void clickOnExpanderStory() {
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            storyExpander.click();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Web element not was find ", e.getCause());
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
    }

    public void clickOnDeleteStoryButton() {
        deleteStoryButton.click();
    }

    public void clickOnConfirmDeleteStoryButton() {
        confirmDeleteButton.click();
    }

    public String getStoryDeletedMessage() {
        return storyDeletedMessage.getText();
    }

    public String getStoryTitle() {
        return storyTitleTextArea.getText();
    }

    public String getDescriptionText() {
        return descriptionText.getText();
    }

    public String getLabel() {
        return labelName.getText();
    }

    public void setLabel(String storyLabel) {
        label.clear();
        label.sendKeys(storyLabel, Keys.ENTER);
    }

    public String getComment() {
        return driver.findElement(By.xpath("//p[contains(.,'" + commentMesage + "')]")).getText();
    }

    public void setComment(String storyComment) {
        commentMesage = storyComment;
        comment.clear();
        comment.sendKeys(storyComment);
        addCommentButton.click();
    }

    /**
     * General method to set the values of properties of a story
     *
     * @param values Map of properties to set of a story
     */
    public void executeSteps(final Map<StoriesSteps, Object> values) {
        Map<StoriesSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(STORY_TITLE, () -> setStoryTitleTextArea(String.valueOf(values.get(STORY_TITLE))));
        strategyMap.put(DESCRIPTION, () -> setDescriptionTextarea(String.valueOf(values.get(DESCRIPTION))));
        strategyMap.put(LABELS, () -> setLabel(String.valueOf(values.get(LABELS))));
        strategyMap.put(COMMENT, () -> setComment(String.valueOf(values.get(COMMENT))));
        for (StoriesSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

    /**
     * General method to compare the values of properties of a story
     *
     * @return map with the current values
     */
    public Map<StoriesSteps, Object> getAssertionMap() {
        Map<StoriesSteps, Object> assertionMap = new HashMap<>();
        assertionMap.put(STORY_TITLE, getStoryTitle());
        assertionMap.put(DESCRIPTION, getDescriptionText());
        assertionMap.put(LABELS, getLabel());
        assertionMap.put(COMMENT, getComment());
        return assertionMap;
    }
}
