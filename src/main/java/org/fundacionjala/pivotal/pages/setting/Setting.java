package org.fundacionjala.pivotal.pages.setting;

import org.fundacionjala.pivotal.pages.dashboard.ToolBar;

/**
 * @author  Mijhail Villarroel.
 */
public class Setting {
    SideBarSetting sideBar;
    ToolBar toolBar;

    public Setting() {
        sideBar = new SideBarSetting();
        toolBar = new ToolBar();
    }

    public SideBarSetting getSideBar() {
        return sideBar;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}
