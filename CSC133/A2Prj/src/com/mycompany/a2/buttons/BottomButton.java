package com.mycompany.a2.buttons;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;

public class BottomButton extends CommandButton {
    public BottomButton(String name, Command command) {
        // Set the button command and style
        super(name, command);
        this.getUnselectedStyle().setPadding(TOP,    5);
        this.getUnselectedStyle().setPadding(BOTTOM, 5);
        this.getUnselectedStyle().setPadding(LEFT,   5);
        this.getUnselectedStyle().setPadding(RIGHT,  5);
        
        this.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        this.getUnselectedStyle().setBgTransparency(255);
    }
}