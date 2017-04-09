package org.fundacionjala.pivotal.pages.stories;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_PROJECT_WAIT;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * This class contains the web elements from side bar
 *
 * @author Rosario Garcia
 */
public class SideBarStories extends BasePage {

    private static final String ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG = "Add Story Button was not found";

    private static final Logger LOGGER = Logger.getLogger(Project.class.getName());

    @FindBy(css = ".button.add_story > span")
    private WebElement addStoryButton;

    /**
     * Method to do click on the button "Add Story"
     *
     * @return a Story object
     */
    public Story clickOnAddStoryButton() {
        try {
            Thread.sleep(30000);
            driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(55, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(addStoryButton));
            addStoryButton.click();
        } catch (NoSuchElementException e) {
            LOGGER.error("click add story button was not found", e);
            throw new NoSuchElementException(ADD_STORY_BUTTON_WAS_NOT_FOUND_MSG);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            DriverManager.getInstance().getWait().withTimeout(30, TimeUnit.SECONDS);
        }

        return new Story();
    }
}