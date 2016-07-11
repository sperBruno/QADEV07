package com.fundacionjala.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by BrunoBarrios on 7/11/2016.
 */
public class Members {

    @FindBy(css = "[class='member_lookup']")
    WebElement addMemberPanel;

    @FindBy(id = "members_for_lookup")
    WebElement addMemberTextBox;

    @FindBy(id = "role_id")
    WebElement roleOfMember;

    @FindBy(id = "add_member_button")
    WebElement addMemberBtn;

    @FindBy(id = "new_members_link")
    WebElement addMemberFromListLink;

    public void setNameOfNewMember(String nameOfNewMember){
        addMemberPanel.sendKeys(nameOfNewMember);
    }

    public void setRoleOfAMember(String roleOfAMember){
        Select roleDropDown=new Select(roleOfMember);
        roleDropDown.selectByVisibleText(roleOfAMember);
    }

    public void clickAddMemberBtn(){
        addMemberPanel.click();
    }

    public boolean isAddMemberPanelDiplayed(){
        return addMemberPanel.isDisplayed();
    }

}
