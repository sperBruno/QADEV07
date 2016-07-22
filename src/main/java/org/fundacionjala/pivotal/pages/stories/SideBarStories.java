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

    private final By addStoryButton = By.cssSelector(".button.add_story");

    @FindBy(css = ".sidebar_content.scrollable")
    private WebElement sidebarContainer;

    /**
     * Method to do click on the button "Add Story"
     *
     * @return a Story object
     */
    public Story clickOnAddStoryButton() {
        try {
            wait.withTimeout(45, SECONDS);
            wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".sidebar_content.scrollable")));
            wait.until(ExpectedConditions.presenceOfElementLocated( addStoryButton));
        //    sidebarContainer.findElement(addStoryButton).click();
            CommonMethods.clickWebElement(sidebarContainer.findElement(addStoryButton));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG);
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new Story();
    }
}