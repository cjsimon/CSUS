package com.mycompany.a3.sound;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.Form;

public class Sound implements Runnable {
	protected Media m;
	
	public Sound(String file) {
		final InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + file);
		try {
			// Load up a wav audio file using the input file.
			// When the file is done playing, use this runnable class as a callback.
			// Its run method will be invoked
			if(is != null) {
				m = MediaManager.createMedia(is, "audio/wav", this);
				is.close();
			} else {
				System.err.print("Resource cannot be found: ");
				System.err.println(file);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Run is invoked as a callback when the sound is done playing
	// It is a method inherited from Runnable
	public void run() {}
	
	public boolean play()  {
		boolean canPlay = (m != null);
		if(canPlay) {
			m.setTime(0);
			m.play();
		}
		return canPlay;
	}
	
	public boolean pause() {
		boolean canPause = (m != null);
		if(canPause) m.pause();
		return canPause;
	}
}