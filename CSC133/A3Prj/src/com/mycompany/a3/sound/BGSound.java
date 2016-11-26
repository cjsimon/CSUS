package com.mycompany.a3.sound;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.mycompany.a3.GameWorld;

public class BGSound extends Sound implements Runnable {
	// Attach the gw to the sound to see if the gw is paused or playing
	GameWorld gw;
	
	public BGSound(String file, GameWorld gw) {
		super(file, gw);
		this.gw = gw;
	}
	
	// Replay the bg sound after it ends
	public void run() {
		// Don't play the sound if the game is paused
		if(!gw.isPlaying) return;
		
		boolean canReplay = (m != null);
		// Only play the music if the game is not paused and
		// if the media player isn't null
		if(canReplay) {
			super.m.setTime(0);
			super.play();
		}
	}
}