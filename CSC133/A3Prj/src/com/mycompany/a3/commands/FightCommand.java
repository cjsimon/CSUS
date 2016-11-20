package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class FightCommand extends Command {
    GameWorld gw;
    
    public FightCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fight");
        gw.colAstronautAlien();
    }
}