package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class MoveToAstronautCommand extends Command {
    GameWorld gw;
    
    public MoveToAstronautCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        if(gw.isPlaying) {
            System.out.println("Move to Astronaut");
            gw.moveSpaceshipToAstronaut();
        }
    }
}