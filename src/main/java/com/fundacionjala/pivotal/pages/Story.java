package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Charito on 7/12/2016.
 */
public class Story extends BasePage {

    @FindBy(className = "addButton___3-z3g3BH")
    private WebElement addStoryButton;

    @FindBy(name = "story[name]")
    private WebElement storyNameTextarea;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveStoryButton;

    @FindBy(xpath = "//span[@class='story_name']")
    private WebElement nameStory;

    @FindBy(xpath = "//a[@class='selector undraggable']")
    private WebElement selectorBox;

    @FindBy(xpath = "//button[@title='Delete selected stories']")
    private WebElement deleteStoryButton;

    @FindBy(xpath = "//button[@data-aid='DeleteButton']")
    private WebElement confirmDeleteButton;

    public Story clickOnAddStoryIcon() {
        addStoryButton.click();
        return this;
    }

    public void setStoryNameTextarea(String storyName) {
        storyNameTextarea.clear();
        storyNameTextarea.sendKeys(storyName);
    }

    public Story clickOnSaveStoryButton() {
        saveStoryButton.click();
        return this;
    }

    public String getNameStory() {
        return nameStory.getText();
    }
}
