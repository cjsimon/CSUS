package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LeftCommand extends Command {
    GameWorld gw;
    
    public LeftCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("Left");
        gw.moveSpaceshipLeft(10);
    }
}