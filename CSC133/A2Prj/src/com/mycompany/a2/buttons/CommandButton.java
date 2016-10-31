package com.mycompany.a2.buttons;

import com.codename1.ui.Button;
import com.codename1.ui.Command;

public class CommandButton extends Button {
    // TODO: Create ButtonFactory design pattern
    //       to create different kinds of buttons
	public CommandButton(Command command) {
        this.setCommand(command);    
    }
	public CommandButton(String name, Command command) {
		// An unstyled button that sets a command
        super(name);
        this.setCommand(command);
    }
}