package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Charito on 7/12/2016.
 */
public class Story {
    @FindBy(xpath = "//textarea[@name='story[name]']")
    private WebElement storyNameText;
    
    
}
