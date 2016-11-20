package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer {
    @SuppressWarnings("unused")
	private GameWorld gw;
    
    public MapView(GameWorld gw) {
        this.setLayout(new BorderLayout(CENTER));
        gw.setWidth(this.getWidth());
        gw.setHeight(this.getHeight());
        this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        
        // Attach the given GameWorld to this MapView
        // TODO: Implement proxy design pattern 
        this.gw = gw;
    }

	public void update(Observable observable, Object data) {
		// TODO: Implement draw methods to display graphics here
	}
}
