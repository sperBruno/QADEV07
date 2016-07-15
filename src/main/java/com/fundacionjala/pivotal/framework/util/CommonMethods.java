package com.fundacionjala.pivotal.framework.util;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.fundacionjala.pivotal.framework.selenium.DriverManager.getInstance;

/**
 * Created by mijhailvillarroel on 7/14/2016.
 */
public final class CommonMethods {

    private CommonMethods() {
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public static void setWebElement(WebElement webElement, String text) {
        getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void clickWebElement(WebElement webElement) {
        getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void setCheckBox(WebElement webElement, boolean enable) {
        if (enable) {
            unCheckBox(webElement);
        } else {
            CheckBox(webElement);
        }
    }

    private static void unCheckBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    private static void CheckBox(WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }

    public static void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

    public static Select convertASelect(WebElement webElement) {
        return new Select(webElement);
    }

}
