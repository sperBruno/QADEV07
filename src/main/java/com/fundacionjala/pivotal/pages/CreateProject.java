package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mijhailvillarroel on 7/6/2016.
 */
public class CreateProject extends BasePage {
    @FindBy(css = "input[class='tc_form_input']")
    WebElement newProjectName;

    @FindBy(css = "div[class='tc_form_select']")
    WebElement account;

    @FindBy(css = "button[class='tc_button tc_button_submit']")
    WebElement createNewProjectBtn;

    @FindBy(css = "input[type='checkbox']")
    WebElement projectVisibleCheckbox;

    @FindBy(css = ".tc_form_label.tc_form_checkbox>input")
    WebElement projectSampleData;

    public void setProjectName(String projectName) {
        newProjectName.sendKeys(projectName);
    }

    public void setAccount() {
        account.click();
        driver.findElement(By.xpath("//span[@class='tc_select_account_name']")).click();
    }

    public void checkProjectVisible() {
        projectVisibleCheckbox.click();
    }

    public Project clickCreateProject() {
        createNewProjectBtn.click();
        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new Project();
    }

    public boolean createProjectFormIsdisplayed() {
        return newProjectName.isDisplayed() && account.isDisplayed() && createNewProjectBtn.isDisplayed();
    }

}
