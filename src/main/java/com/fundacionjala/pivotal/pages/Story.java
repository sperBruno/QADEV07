package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Charito on 7/12/2016.
 */
public class Story extends BasePage {

    /**
     * Web elements to add story
     */
    @FindBy(name = "story[name]")
    private WebElement storyNameTextarea;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveStoryButton;

    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    private WebElement cancelCreateStoryButton;

    /**
     * Web elements to set story
     */
    @FindBy(className = "story_name")
    private WebElement storyNameText;

    @FindBy(xpath = "//button[contains(.,'Close')]")
    private WebElement closeButton;

    /**
     * Web elements to delete story
     */
    @FindBy(xpath = "//a[@class='expander undraggable']")
    private WebElement storyExpander;

    @FindBy(xpath = "//button[@title='Delete this story']")
    private WebElement deleteStoryButton;

    @FindBy(xpath = "//button[@data-aid='DeleteButton']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//li[contains(.,'1 story deleted')]")
    private WebElement storyDeletedMessage;

    @FindBy(xpath = "//button[@data-aid='CancelButton']")
    private WebElement cancelDeleteButton;

    public void setStoryNameTextarea(String storyName) {
        storyNameTextarea.clear();
        storyNameTextarea.sendKeys(storyName);
    }

    public Story clickOnSaveStoryButton() {
        saveStoryButton.click();
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

    public String getStoryDeletedMessage(){
        return storyDeletedMessage.getText();
    }

    public String getNameStory() {
        return storyNameText.getText();
    }
}
