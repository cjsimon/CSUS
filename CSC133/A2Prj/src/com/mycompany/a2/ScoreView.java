package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
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
        
        Container scoreViewContainer = new Container();
        scoreViewContainer.setLayout(new FlowLayout(Component.CENTER));
        scoreViewContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.WHITE));
        
        score			   .getAllStyles().setFgColor(ColorUtil.BLUE);
        astronautsCaptured .getAllStyles().setFgColor(ColorUtil.BLUE);
        aliensCaptured     .getAllStyles().setFgColor(ColorUtil.BLUE);
        astronautsRemaining.getAllStyles().setFgColor(ColorUtil.BLUE);
        aliensRemaining    .getAllStyles().setFgColor(ColorUtil.BLUE);
        sound              .getAllStyles().setFgColor(ColorUtil.BLUE);
        scoreViewContainer.add(score);
        scoreViewContainer.add(astronautsCaptured);
        scoreViewContainer.add(aliensCaptured);
        scoreViewContainer.add(astronautsRemaining);
        scoreViewContainer.add(aliensRemaining);
        scoreViewContainer.add(sound);
        
        this.add(scoreViewContainer);
        
        // Attach the given GameWorld to this ScoreView
        // TODO: Implement proxy design pattern
        this.gw = gw;
    }
    
    public boolean updateLabels() {
    	score               = new Label("Score: "                + gw.getScore());
        astronautsCaptured  = new Label("Captured Astronauts: "  ); //+ gw.getCapturedAstronauts());
        aliensCaptured      = new Label("Captured Aliens: "      ); //+ gw.getCapturedAliens());
        astronautsRemaining = new Label("Astronauts Remaining: " ); //+ gw.getRemainingAstronauts());
        aliensRemaining     = new Label("Aliens Remaining: "     ); //+ gw.getRemainingAliens());
        sound               = new Label("Sound: " 				 ); //+ (gw.isSoundOn() ? "On" : "Off"));
        return true;
    }
    
    public void update(Observable o, Object args) {
        // Update labels from data in GameWorld
        this.updateLabels();
        this.setVisible(true);
    }
}
