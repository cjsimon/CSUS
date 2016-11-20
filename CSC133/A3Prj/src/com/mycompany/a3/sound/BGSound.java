package com.mycompany.a3.sound;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound extends Sound implements Runnable {
	public BGSound(String file) {
		super(file);
	}
	
	// Replay the bg sound after it ends
	public void run() {
		boolean canReplay = (m != null);
		if(canReplay) {
			super.m.setTime(0);
			super.play();
		}
	}
}