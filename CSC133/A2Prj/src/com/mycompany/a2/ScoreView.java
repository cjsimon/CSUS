package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer {
    private GameWorld gw;
    
    private Label score;
    private Label astronautsCaptured;
    private Label aliensCaptured;
    private Label astronautsRemaining;
    private Label aliensRemaining;
    private Label sound;
    
    public ScoreView(GameWorld gw) {
    	// Initialize the label values
        this.updateLabels();
        
        this.setLayout(new FlowLayout(Component.CENTER));
        Container topContainer = new Container();
        int blue = ColorUtil.BLUE;
        
        score			   .getAllStyles().setFgColor(blue);
        astronautsCaptured .getAllStyles().setFgColor(blue);
        aliensCaptured     .getAllStyles().setFgColor(blue);
        astronautsRemaining.getAllStyles().setFgColor(blue);
        aliensRemaining    .getAllStyles().setFgColor(blue);
        sound              .getAllStyles().setFgColor(blue);
        topContainer.add(score);
        topContainer.add(astronautsCaptured);
        topContainer.add(aliensCaptured);
        topContainer.add(astronautsRemaining);
        topContainer.add(aliensRemaining);
        topContainer.add(sound);
        
        topContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.WHITE));
        this.add(topContainer);
        
        // Attach the given GameWorld to this ScoreView
        // TODO: Implement proxy design pattern
        this.gw = gw;
    }
    
    public boolean updateLabels() {
    	score               = new Label("Score: "                + gw.getScore());
        astronautsCaptured  = new Label("Captured Astronauts: "  + gw.getCapturedAstronauts());
        aliensCaptured      = new Label("Captured Aliens: "      + gw.getCapturedAliens());
        astronautsRemaining = new Label("Astronauts Remaining: " + gw.getRemainingAstronauts());
        aliensRemaining     = new Label("Aliens Remaining: "     + gw.getRemainingAliens());
        sound               = new Label("Sound: " 				 + (gw.isSoundOn() ? "On" : "Off"));
        return true;
    }
    
    public void update(Observable o, Object args) {
        // Update labels from data in GameWorld
        this.updateLabels();
        this.setVisible(true);
    }
}
