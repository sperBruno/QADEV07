package com.fundacionjala.pivotal.pages.stories;

import com.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by RosarioGarcia on 7/9/2016.
 */
public class SideBarStories extends BasePage {

    @FindBy(xpath = "//span[contains(.,'Add Story')]")
    private WebElement addStoryButton;

    public Story clickOnAddStoryButton() {
        addStoryButton.click();
        return new Story();
    }
}
