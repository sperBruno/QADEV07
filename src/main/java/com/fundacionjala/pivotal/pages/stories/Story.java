package com.fundacionjala.pivotal.pages.stories;

import java.util.HashMap;
import java.util.Map;

import com.fundacionjala.pivotal.pages.BasePage;
import com.fundacionjala.pivotal.pages.IAutomationStep;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.pages.stories.StoriesSteps.*;

/**
 * This class is for test the creation, set and delete
 * of a story in a project of pivotal tracker.
 *
 * @author RosarioGarcia
 */
public class Story extends BasePage {

    /**
     * Web elements to add story
     */
    @FindBy(name = "story[name]")
    private WebElement storyTitleTextArea;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveStoryButton;

    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    private WebElement cancelCreateStoryButton;

    @FindBy(css = ".rendered_description.tracker_markup")
    private WebElement descriptionText;

    @FindBy(name = "story[pending_description]")
    private WebElement storyDescriptionTextField;

    @FindBy(xpath = "//button[contains(.,'Done')]")
    private WebElement doneDescriptionButton;

    @FindBy(name = "label[name]")
    private WebElement label;

    @FindBy(name = "task[description]")
    private WebElement taskTextField;

    @FindBy(css = ".autosaves.std.add")
    private WebElement addTaskButton;

    @FindBy(name = "comment[text]")
    private WebElement comment;

    @FindBy(xpath = "//button[@data-aid='comment-submit']")
    private WebElement addCommentButton;

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

    /**
     * This method is for set the story title text field
     * wich contains the name of a story.
     *
     * @param storyTitle; it is the name for a story
     */
    public void setStoryTitleTextArea(String storyTitle) {
        storyTitleTextArea.clear();
        storyTitleTextArea.sendKeys(storyTitle);
    }

    /**
     * This method is for set the description text field
     * wich contains the description of a story.
     *
     * @param storyDescription; it is the description for a story
     */
    public void setDescriptionTextarea(String storyDescription) {
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
        storyExpander.click();
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
        return label.getText();
    }

    public void setLabel(String storyLabel) {
        label.clear();
        label.sendKeys(storyLabel);
    }

    public String getTask() {
        return taskTextField.getText();
    }

    public void setTask(String storyTask) {
        taskTextField.clear();
        taskTextField.sendKeys(storyTask);
        addTaskButton.click();
    }

    public String getComment() {
        return comment.getText();
    }

    public void setComment(String storyComment) {
        comment.clear();
        comment.sendKeys(storyComment);
        addCommentButton.click();
    }

    public void executeSteps(final Map<StoriesSteps, Object> values) {
        Map<StoriesSteps, IAutomationStep> strategyMap = new HashMap<>();
        strategyMap.put(STORY_TITLE, () -> setStoryTitleTextArea(values.get(STORY_TITLE).toString()));
        strategyMap.put(DESCRIPTION, () -> setDescriptionTextarea(values.get(DESCRIPTION).toString()));
        strategyMap.put(LABELS, () -> setLabel(values.get(LABELS).toString()));
        strategyMap.put(TASKS, () -> setTask(values.get(TASKS).toString()));
        strategyMap.put(COMMENT, () -> setComment(values.get(COMMENT).toString()));
        for (StoriesSteps step : values.keySet()) {
            strategyMap.get(step).executeStep();
        }
    }

    public Map<StoriesSteps, Object> getAssertionMap() {
        Map<StoriesSteps, Object> assertionMap = new HashMap<>();
        assertionMap.put(STORY_TITLE, getStoryTitle());
        assertionMap.put(DESCRIPTION, getDescriptionText());
        assertionMap.put(LABELS, getLabel());
        assertionMap.put(TASKS, getTask());
        assertionMap.put(COMMENT, getComment());
        return assertionMap;
    }
}
