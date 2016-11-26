package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class HealCommand extends Command {
    GameWorld gw;
    
    public HealCommand(String command, GameWorld gw) {
        super(command);
        this.gw = gw;
    }
    
    public void actionPerformed(ActionEvent e) {
        // Only heal when the game is paused
    	if(!gw.isPlaying) {
            System.out.println("Heal");
            gw.healSelected();
        }
    }
}