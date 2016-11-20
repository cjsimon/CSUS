package com.mycompany.a3.buttons;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;

public class SideButton extends CommandButton {
    // TODO: Create ButtonFactory design pattern
    //       to create different kinds of buttons
    public SideButton(String name, Command command) {
        // Set the button command and style
        super(name, command);
        this.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        this.getUnselectedStyle().setBgTransparency(255);
    }
}
