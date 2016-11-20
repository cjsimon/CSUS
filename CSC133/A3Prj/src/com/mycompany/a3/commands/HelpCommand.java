package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class HelpCommand extends Command {
    GameWorld gw;
    final String helpText = (""
        + "\n" + "e: Expand the Door"
        + "\n" + "c: Contract the Door"
        + "\n" + "s: Open Door and Update Score"
        + "\n" + "u: Move Spaceship Up"
        + "\n" + "d: Move Spaceship Down"
        + "\n" + "l: Move Spaceship Left"
        + "\n" + "r: Move Spaceship Right"
        + "\n" + "o: Move Spaceship to Astronaut"
        + "\n" + "a: Move Spaceship to Alien"
        + "\n" + "w: Create a new Alien"
        + "\n" + "f: Alien fights an Astronaut"
        + "\n" + "t: Update by one frame"
        + "\n" + "x: Exit Game"
    );
    
    public HelpCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        Dialog.show("Commands", helpText, "Okay", "Cancel");
    }
}