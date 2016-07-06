package com.fundacionjala.pivotal.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.selenium.DriverManager.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.pivotal.framework.selenium.DriverManager.IMPLICIT_WAIT_TIME;

/**
 *
 */
public class Dashboard extends BasePage {

    @FindBy(className = "tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(id = "notice")
    private WebElement messageTestDelete;

    /**
     *
     * @return
     */
    public CreateProject clickCreateProjectLink() {
        createProjectLink.click();
        return new CreateProject();
    }

    /**
     *
     * @return
     */
    public String getUserNameText() {
        String userName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return userName;
    }

    /**
     *
     * @return
     */
    public String getMessageTextDelete() {
        return messageTestDelete.getText();
    }
}
