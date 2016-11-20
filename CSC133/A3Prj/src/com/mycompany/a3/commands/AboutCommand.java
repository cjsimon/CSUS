package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AboutCommand extends Command {
    GameWorld gw;
    final String aboutText = (""
        + "\n" + "Name: Christopher Simon"
        + "\n" + "Course: CSC 133 Object Oriented Programming"
        + "\n" + "Version: 1.0.0"
        + "\n" + "Description: A space shooter game. Have fun!"
    );
    
    public AboutCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        Dialog.show("About", aboutText, "Okay", null);
    }
}