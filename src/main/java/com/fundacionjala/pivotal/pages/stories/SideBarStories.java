package com.fundacionjala.pivotal.pages.stories;

import com.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author RosarioGarcia
 */
public class SideBarStories extends BasePage {

    @FindBy(xpath = "html/body/div[1]/div[2]/section[1]/aside/div/section/section/ul/li[2]/a/span/span")
    private WebElement addStoryButton;

    public Story clickOnAddStoryButton() {
        addStoryButton.click();
        return new Story();
    }
}
