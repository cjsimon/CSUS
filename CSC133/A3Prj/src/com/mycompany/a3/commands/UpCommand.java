package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class UpCommand extends Command {
    GameWorld gw;
    
    public UpCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        if(gw.isPlaying) {
            System.out.println("Up");
            gw.moveSpaceshipUp(10);
        }
    }
}