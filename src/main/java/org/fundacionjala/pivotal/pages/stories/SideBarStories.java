package org.fundacionjala.pivotal.pages.stories;

import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * This class contains the web elements from side bar
 *
 * @author Rosario Garcia
 */
public class SideBarStories extends BasePage {

    private static final String ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG = "Add Story Button was not found";

    @FindBy(css = ".button.add_story")
    private WebElement addStoryButton;

    /**
     * Method to do click on the button "Add Story"
     *
     * @return a Story object
     */
    public Story clickOnAddStoryButton() {
        try {
            Thread.sleep(10000);
            driver.findElement(By.cssSelector(".button.add_story"));
            addStoryButton.click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }

        return new Story();
    }
}