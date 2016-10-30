package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class MapView extends Container implements Observer {
    private GameWorld gw;
    
    public MapView(GameWorld gw) {
        this.setLayout(new BorderLayout());
        Container c = new Container(new FlowLayout());
        c.setWidth(1000);
        c.setHeight(610);
        c.getAllStyles().setBgTransparency(255);
        c.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        add(BorderLayout.CENTER, c);
        
        // Attach the given GameWorld to this MapView
        // TODO: Implement proxy design pattern 
        this.gw = gw;
    }

	public void update(Observable observable, Object data) {
	}
}
