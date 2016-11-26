package com.mycompany.a3.commands;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameWorld;

public class PauseCommand extends Command {
    GameWorld gw;
    Game	  game;
    
    public PauseCommand(String command, GameWorld gw, Game game) {
        super(command);
        this.gw   = gw;
        this.game = game;
    }
    
    public void actionPerformed(ActionEvent e) {
    	gw.isPlaying = !gw.isPlaying;
        String playMessage = gw.isPlaying ? "Playing" : "Paused";
        System.out.println(playMessage);
        game.changePauseStatus(playMessage);
    }
}