package org.fundacionjala.pivotal.pages.setting;

import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

/**
 * @author Mijhail Villarroel.
 */
public class Setting {
    SideBarSetting sideBar;
    ToolBar toolBar;

    public Setting() {
        sideBar = new SideBarSetting();
        toolBar = new ToolBar();
    }

    /**
     * This method will get the side bar.
     *
     * @return side bar.
     */
    public SideBarSetting getSideBar() {
        return sideBar;
    }

    /**
     * This method will get tool bar.
     *
     * @return
     */
    public ToolBar getToolBar() {
        return toolBar;
    }
}
