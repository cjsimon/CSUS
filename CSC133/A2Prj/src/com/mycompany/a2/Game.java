package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class Game extends Form {
    private GameWorld gw;
    private MapView   mv;
    private ScoreView sv;
    private ActionEvent e;
    
    public Game() {
        // Create the GameWorld, MapView and ScoreView
        gw = new GameWorld();
        mv = new MapView(gw);
        sv = new ScoreView(gw);
        // Make the map and score observers of the GamewWorld
        gw.addObserver(mv);
        gw.addObserver(sv);
        gw.notifyObservers();
        
        // Initialize the GameWorld
        gw.init();
        
        // Create the Game gui layout
        this.initGui();
    }
    
    public boolean initGui() {
    	// Set layout. Default is FlowLayout
        this.setLayout(new BorderLayout());
        Container northContainer = new Container(),
                  nTop           = new Container(),
                  nBottom        = new Container();
        northContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        // Set nTop and nBottom Layouts within northContainer
        nTop.setLayout(new FlowLayout(Component.CENTER));
        nBottom.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        
        // Add components in top and bottom
        Toolbar myToolbar = new Toolbar();
        setToolbar(myToolbar);
        //TextField myTF = new TextField();
        //myToolbar.setTitleComponent(myTF);
        myToolbar.setTitle("Space Fights Game");
        
        // TODO: Add Commands to side menu
        // See slide 21 in GUI Power Point
        Command scoreCommand = new Command("Score");
        Command soundCommand = new Command("Sound");
        Command aboutCommand = new Command("About");
        Command exitCommand  = new Command("Exit");
        // Add commands to hamburger menu
        myToolbar.addCommandToSideMenu(scoreCommand);
        myToolbar.addCommandToSideMenu(soundCommand);
        myToolbar.addCommandToSideMenu(aboutCommand);
        myToolbar.addCommandToSideMenu(exitCommand);
        
        // Add help to right
        Command helpCommand = new Command("Help");
        myToolbar.addCommandToRightBar(helpCommand);
        
        // Add the nTop and nBottom to the northContainer 
        northContainer.add(nTop);
        northContainer.add(nBottom);
        
        // Add the topmost layout to the GameForm
        // Outter Most Layer
        this.add(BorderLayout.NORTH, northContainer);
        
        
        
        
        Button bContact         = new Button("Contact");
        Button bDown            = new Button("Down");
        Button bRight           = new Button("Right");
        Button bMoveToAlien     = new Button("MoveToAlien");
        this.add(BorderLayout.EAST, bContact);
        this.add(BorderLayout.EAST, bDown);
        this.add(BorderLayout.EAST, bRight);
        this.add(BorderLayout.EAST, bMoveToAlien);
        
        Button bNewAlien        = new Button("NewAlien");
        Button bFight           = new Button("Fight");
        Button bTick            = new Button("Tick");
        this.add(BorderLayout.SOUTH, bNewAlien);
        this.add(BorderLayout.SOUTH, bFight);
        this.add(BorderLayout.SOUTH, bTick);
        
        Button bExpand          = new Button("Expand");
        Button bUp              = new Button("Up");
        Button bLeft            = new Button("Left");
        Button bMoveToAstronaut = new Button("MoveToAstronaut");
        Button bScore 			= new Button("Score");
        this.add(BorderLayout.WEST, bExpand);
        this.add(BorderLayout.WEST, bUp);
        this.add(BorderLayout.WEST, bLeft);
        this.add(BorderLayout.WEST, bMoveToAstronaut);
        this.add(BorderLayout.WEST, bScore);
        
        this.requestFocus();
        this.setVisible(true);
        this.show();
        return true;
    }
}
