package org.fundacionjala.pivotal.pages.setting;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class SideBarSetting extends BasePage {

    @FindBy(xpath = "//a[text()='General Settings']")
    private WebElement linkGeneralSettings;

    @FindBy(xpath = "//a[text()='Project Profile']")
    private WebElement linkProjectProfile;

    @FindBy(xpath = "//a[text()='Integrations']")
    private WebElement linkIntegrations;

    @FindBy(xpath = "//a[text()='Import CSV']")
    private WebElement linkImportCSV;

    @FindBy(xpath = "//a[text()='Export CSV']")
    private WebElement linkExportCSV;

    /**
     * This method will click on general setting link.
     *
     * @return general setting form.
     */
    public GeneralSettingForm clickGeneralSetting() {
        clickWebElement(linkGeneralSettings);
        return new GeneralSettingForm();
    }
}
