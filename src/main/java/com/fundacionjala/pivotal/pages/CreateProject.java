package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class CreateProject extends BasePage {
    @FindBy(className = "tc_form_input")
    WebElement newProjectName;

    @FindBy(className = "tc_form_select")
    WebElement accountDropDown;

    @FindBy(css = "button[class='tc_button tc_button_submit']")
    WebElement createNewProjectBtn;

    @FindBy(css = "input[type='checkbox']")
    WebElement projectVisibleCheckbox;

    @FindBy(css = ".tc_form_label.tc_form_checkbox>input")
    WebElement projectSampleData;

    public CreateProject setProjectName(String projectName) {
        newProjectName.sendKeys(projectName);
        return this;
    }

    public CreateProject setAccountDropDown(String accountName) {
        accountDropDown.click();
        driver.findElement(By.xpath("//span[text()='" + accountName + "']")).click();
        return this;
    }

    public void checkProjectVisible() {
        projectVisibleCheckbox.click();
    }

    public Project clickCreateProject() {
        createNewProjectBtn.click();

        return new Project();
    }

    public boolean createProjectFormIsdisplayed() {
        return newProjectName.isDisplayed() && accountDropDown.isDisplayed() && createNewProjectBtn.isDisplayed();
    }
}
