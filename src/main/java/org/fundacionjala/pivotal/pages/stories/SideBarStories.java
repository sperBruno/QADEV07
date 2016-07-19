package org.fundacionjala.pivotal.pages.stories;

import java.util.concurrent.TimeUnit;

import org.fundacionjala.pivotal.pages.login.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 * This class contains the web elements from side bar
 * @author RosarioGarcia
 */
public class SideBarStories extends BasePage {

    @FindBy(css = ".button.add_story")
    private WebElement addStoryButton;

    /**
     * Method to do click on the botton "Add Story"
     * @return a Story object
     */
    public Story clickOnAddStoryButton() {
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            addStoryButton.click();
        } catch (NoSuchElementException e) {
        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return new Story();
    }
}
