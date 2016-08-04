package org.fundacionjala.pivotal.pages.stories;

import java.util.EnumMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.fundacionjala.pivotal.framework.util.IAutomationStep;
import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.pivotal.framework.util.Constants.*;
import static org.fundacionjala.pivotal.pages.stories.StoriesSteps.*;

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

    @FindBy(css = ".dropdown.story_type")
    private WebElement storyTypeArrow;

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

    @FindBy(css = "button[data-aid='comment-submit']")
    private WebElement addCommentButton;

    @FindBy(css = "button[data-aid='ConfirmationDialog__confirm']")
    private WebElement confirmCancelButton;
    /**
     * Web elements to add an empty story
     */
    @FindBy(className = "AlertDialog__message___873RxAXD")
    private WebElement addStoryTitleAlert;

    @FindBy(css = "button[data-aid='AlertDialog__confirm']")
    private WebElement okAlertButton;
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
    private String storyTypeName;

    public Story clickOnCancelDeleteButton() {
        cancelDeleteButton.click();
        return this;
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
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            storyExpander.click();
        } catch (NoSuchElementException e) {
            LOGGER.warn("The Web element click expander Story not was find ",e);
            throw new NoSuchElementException("The Web element not was find ", e);
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
    }

    public void clickOnDeleteStoryButton() {
        deleteStoryButton.click();
    }

    public void clickOnConfirmDeleteStoryButton() {
        confirmDeleteButton.click();
    }

    public IceBox cancelAddStory() {
        cancelCreateStoryButton.click();
        confirmCancelButton.click();
        return new IceBox();
    }

    public String getAddStoryTitleAlert() {
        String alert = addStoryTitleAlert.getText();
        okAlertButton.click();
        LOGGER.info("Name the alert "+ alert);
        return alert;
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

    public String getStoryType() {
        return driver.findElement(By.xpath("//span[contains(.,'" + storyTypeName.toLowerCase() + "')]")).getText().toLowerCase();
    }

    public void setStoryType(String storyType) {
        storyTypeName = storyType.toLowerCase();
        try {
            wait.withTimeout(45, SECONDS);
            storyTypeArrow.click();
            driver.findElement(By.xpath("//span[contains(.,'" + storyTypeName + "')]")).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Story type not found", e);
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
    }

    /**
     * This method is for set the story title text field
     * wich contains the name of a story.
     *
     * @param storyTitle it is the name for a story
     */
    public void setStoryTitleTextArea(String storyTitle) {
        CommonMethods.setWebElement(storyTitleTextArea,storyTitle);
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

    /**
     * General method to set the values of properties of a story
     *
     * @param values Map of properties to set of a story
     */
    public void strategyStepMap(final Map<StoriesSteps, Object> values) {
        EnumMap<StoriesSteps, IAutomationStep> strategyMap = new EnumMap<>(StoriesSteps.class);
        strategyMap.put(STORY_TITLE, () -> setStoryTitleTextArea(String.valueOf(values.get(STORY_TITLE))));
        strategyMap.put(STORY_TYPE, () -> setStoryType(String.valueOf(values.get(STORY_TYPE))));
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
        EnumMap<StoriesSteps, Object> assertionMap = new EnumMap<>(StoriesSteps.class);
        assertionMap.put(STORY_TITLE, getStoryTitle());
        assertionMap.put(STORY_TYPE, getStoryType());
        assertionMap.put(DESCRIPTION, getDescriptionText());
        assertionMap.put(LABELS, getLabel());
        assertionMap.put(COMMENT, getComment());
        return assertionMap;
    }
}
