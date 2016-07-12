package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by RosarioGarcia on 7/9/2016.
 */
public class SideBarStories extends BasePage {
    
    @FindBy(xpath = "//span[contains(.,'Add Story')]")
    private WebElement addStoryButton;

    public Icebox clickOnAddStoryButton(){
        addStoryButton.click();
        return new Icebox();
    }
}
