package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by BrunoBarrios on 7/11/2016.
 */
public class FeedBackPanel {

    @FindBy(css = ".tc_form_input.tc_feedback_description")
    WebElement feedBackDescriptionTxt;

    @FindBy(css = ".feedback_role.tc_form_select")
    WebElement roleDropDown;

    public void setFeedBackDescriptionTxt(String feedBackDescription) {
        feedBackDescriptionTxt.click();
    }

    public void setRoleDropDown(String role) {
        Select selectRole = new Select(roleDropDown);
        selectRole.selectByVisibleText("role");
    }
}
