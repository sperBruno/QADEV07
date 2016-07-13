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

    @FindBy(css = "autosaves.button.std.save")
    private WebElement saveStoryButton;

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
        return new Story();
    }
}
