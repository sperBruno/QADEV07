package org.fundacionjala.pivotal.pages.stories;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the web elements from side bar
 * @author RosarioGarcia
 */
public class SideBarStories extends BasePage {

    @FindBy(css = ".button.add_story")
    private WebElement addStoryButton;

    /**
     * Method to do click on the booton "Add Story"
     * @return a Story object
     */
    public Story clickOnAddStoryButton() {
        addStoryButton.click();
        return new Story();
    }
}
