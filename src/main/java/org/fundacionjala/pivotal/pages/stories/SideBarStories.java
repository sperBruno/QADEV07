package org.fundacionjala.pivotal.pages.stories;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
            Thread.sleep(10000);
            driver.findElement(By.cssSelector(".button.add_story")).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Story();
    }
}