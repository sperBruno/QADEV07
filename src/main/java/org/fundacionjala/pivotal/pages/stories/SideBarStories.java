package org.fundacionjala.pivotal.pages.stories;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addStoryButton));
        addStoryButton.click();
        return new Story();
    }
}
