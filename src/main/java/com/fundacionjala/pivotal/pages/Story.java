package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Charito on 7/12/2016.
 */
public class Story {

    @FindBy(xpath = "//a[@class='addButton___3-z3g3BH']")
    protected WebElement addStoryButton;

    @FindBy(xpath = "//textarea[@name='story[name]']")
    protected WebElement storyNameTextarea;

    @FindBy(xpath = "//button[@class='autosaves button std save']")
    protected WebElement saveStoryButton;

    public Story clickOnAddStoryButton(){
        addStoryButton.click();
        return this;
    }

    public void setStoryNameTextarea(String storyName){
        storyNameTextarea.clear();
        storyNameTextarea.sendKeys(storyName);
    }

    public Story clickOnSaveStoryButton(){
        saveStoryButton.click();
        return new Story();
    }
    
    @FindBy(xpath = "//textarea[@name='story[name]']")
    private WebElement storyNameText;
    
}
