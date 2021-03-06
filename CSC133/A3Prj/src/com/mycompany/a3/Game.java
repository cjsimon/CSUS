package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.buttons.*;
import com.mycompany.a3.commands.*;

public class Game extends Form implements Runnable {
    private GameWorld gw;
    private MapView   mv;
    private ScoreView sv;
    
    BottomButton bPauseCommand;
    SoundCommand soundCommand;
    
    public Game() {
    	// Create the GameWorld, MapView and ScoreView
        gw = new GameWorld();
        mv = new MapView(gw);
        sv = new ScoreView(gw);
        
        // Create the Game gui layout
        this.initGui();
        
        // DEBUG
        System.out.println("GameWorld: ");
        System.out.println("X, Y:     (" + mv.getX() + ", " + mv.getY() + ")");
        System.out.println("Wdth/Hgt: (" + mv.getWidth() + ", " + mv.getHeight() + ")");
        System.out.println();
        
        // Initialize the world with the bounds of the MapView, according to the dimensions of the screen
        // This is performed after the MapView is rendered in initGui
        gw.init(mv.getX(), mv.getY(), mv.getWidth() + mv.getX(), mv.getHeight() + mv.getY());
        
        // Make the map and score observers of the GamewWorld
        gw.addObserver(mv);
        gw.addObserver(sv);
        
        // Create a UITimer to update the MapView
        UITimer timer = new UITimer(this);
        timer.schedule(15, true, this);
    }
    
    public boolean initGui() {
    	// Set the layout of the form.
        // The default layout is FlowLayout
        this.setLayout(new BorderLayout());
        
        /* North Container*/
        Container northContainer = new Container();
        northContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        // Split the northContainer into two sections, nTop and nBottom
        Container nTop = new Container(), nBottom = new Container();
        // Set nTop and nBottom Layouts within northContainer
        // nTop holds the ToolBar
        // nBottom holds the ScoreView
        nTop.setLayout(new FlowLayout(Component.CENTER));
        nBottom.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        // Set the style of the layouts
        nTop.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
        nBottom.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
        
        /* nTop */
        // Create a ToolBar to set the title and to hold the hamburger menu
        Toolbar toolbar = new Toolbar();
        setToolbar(toolbar);
        toolbar.setTitle("Space Fights Game");
        // Hamburger Menu Commands
        ScoreCommand scoreCommand = new ScoreCommand("Score", gw);
        			 soundCommand = new SoundCommand("Sound", gw, this);
        HelpCommand  helpCommand  = new HelpCommand("Help", gw);
        AboutCommand aboutCommand = new AboutCommand("About", gw);
        ExitCommand  exitCommand  = new ExitCommand("Exit", gw);
        // Add commands to hamburger menu
        toolbar.addCommandToSideMenu(scoreCommand);
        toolbar.addCommandToSideMenu(soundCommand);
        toolbar.addCommandToSideMenu(helpCommand);
        toolbar.addCommandToSideMenu(aboutCommand);
        toolbar.addCommandToSideMenu(exitCommand);
        // Command keyListeners
        this.addKeyListener('s', scoreCommand);
        this.addKeyListener('x', exitCommand);
        this.addKeyListener('h', helpCommand);
        // Add helpCommand to the right of the toolbar
        toolbar.addCommandToRightBar(helpCommand);
        
        /* nBottom */
        // Add the ScoreView
        nBottom.setLayout(new FlowLayout(Component.CENTER));
        nBottom.add(sv);
        
        // Add the nTop and nBottom to the northContainer
        northContainer.add(nTop);
        northContainer.add(nBottom);
        // Add the northContainer to the north BorderLayout
        this.add(BorderLayout.NORTH, northContainer);
        
        /* East Container */
        Container eastContainer = new Container(new GridLayout(5, 1));
        eastContainer.getAllStyles().setPadding(Component.TOP, 90);
        eastContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
        // East Commands
        // Commands are invoked by buttons
        ContractCommand    contractCommand    = new ContractCommand("Contract", gw);
        // Up and Down are inverted due to the nature of monitors vs the standard coordinate system
        UpCommand          downCommand        = new UpCommand("Down", gw);
        RightCommand       rightCommand       = new RightCommand("Right", gw);
        MoveToAlienCommand moveToAlienCommand = new MoveToAlienCommand("Move To Alien", gw);
        // Command keyListeners
        // Add keyListener events to the commands
        // so that they are also invokable by keypress
        this.addKeyListener('c', contractCommand);
        this.addKeyListener('d', downCommand);
        this.addKeyListener('r', rightCommand);
        this.addKeyListener('a', moveToAlienCommand);
        // East Buttons
        // Buttons invoke commands
        SideButton bContract    = new SideButton("Contract", contractCommand);
        SideButton bDown        = new SideButton("Down", downCommand);
        SideButton bRight       = new SideButton("Right", rightCommand);
        SideButton bMoveToAlien = new SideButton("Move To Alien", moveToAlienCommand);
        SideButton bScore       = new SideButton("Score", scoreCommand);
        // Add the buttons to the container
        eastContainer.add(bContract);
        eastContainer.add(bDown);
        eastContainer.add(bRight);
        eastContainer.add(bMoveToAlien);
        eastContainer.add(bScore);
        // Add the eastContainer to the east BoarderLayout
        this.add(BorderLayout.EAST, eastContainer);
        
        /* South Container */
        Container southContainer = new Container(new FlowLayout(Component.CENTER));
        southContainer.getAllStyles().setPadding(Component.RIGHT, 10);
        southContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
        // South Commands
        String pausedMessage = gw.isPlaying ? "Playing" : "Pause";
        // Map the pause command to the game so that it can modify the text of the button
        // TODO: Create proxy design pattern for this, or use existing implementation of
        //		 the observable pattern.
        PauseCommand          pauseCommand        = new PauseCommand(pausedMessage, gw, this);
        HealCommand           healCommand         = new HealCommand("Heal", gw);
        //NewAlienCommand     newAlienCommand     = new NewAlienCommand("New Alien", gw);
        //NewAstronautCommand newAstronautCommand = new NewAstronautCommand("New Astronaut", gw);
        //FightCommand        fightCommand        = new FightCommand("Fight", gw);
        //TickCommand         tickCommand         = new TickCommand("Tick", gw);
        // Command keyListeners
        this.addKeyListener('p', pauseCommand);
        this.addKeyListener('h', healCommand);
        //this.addKeyListener('w', newAlienCommand);
        //this.addKeyListener('f', fightCommand);
        //this.addKeyListener('t', tickCommand);
        // South Buttons
        bPauseCommand   = new BottomButton(pausedMessage, pauseCommand);
        BottomButton bHealCommand    = new BottomButton("Heal", healCommand);
        //BottomButton bNewAlien     = new BottomButton("New Alien", newAlienCommand);
        //BottomButton bNewAstronaut = new BottomButton("New Astronaut", newAstronautCommand);
        //BottomButton bFight        = new BottomButton("Fight", fightCommand);
        //BottomButton bTick         = new BottomButton("Tick", tickCommand);
        // Add the buttons to the container
        southContainer.add(bPauseCommand);
        southContainer.add(bHealCommand);
        //southContainer.add(bNewAlien);
        //southContainer.add(bNewAstronaut);        
        //southContainer.add(bFight);
        //southContainer.add(bTick);
        // Add the southContainer to the south BoarderLayout
        this.add(BorderLayout.SOUTH, southContainer);
        
        /* West Container */
        Container westContainer = new Container(new GridLayout(5, 1));
        westContainer.getAllStyles().setPadding(Component.TOP, 90);
        westContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
        // Commands
        ExpandCommand          expandCommand          = new ExpandCommand("Expand", gw);
        // Up and Down are inverted due to the nature of monitors vs the standard coordinate system
        DownCommand            upCommand              = new DownCommand("Up", gw);
        LeftCommand            leftCommand            = new LeftCommand("Left", gw);
        MoveToAstronautCommand moveToAstronautCommand = new MoveToAstronautCommand("Move to Astronaut", gw);
        // Command keyListeners
        this.addKeyListener('e', expandCommand);
        this.addKeyListener('u', upCommand);
        this.addKeyListener('l', leftCommand);
        this.addKeyListener('a', moveToAstronautCommand);
        // Buttons
        SideButton bExpand          = new SideButton("Expand", expandCommand);
        SideButton bUp              = new SideButton("Up", upCommand);
        SideButton bLeft            = new SideButton("Left", leftCommand);
        SideButton bMoveToAstronaut = new SideButton("Move to Astronaut", moveToAstronautCommand);
        // Add the buttons to the container
        westContainer.add(bExpand);
        westContainer.add(bUp);
        westContainer.add(bLeft);
        westContainer.add(bMoveToAstronaut);
        // Add the westContainer to the west BoarderLayout
        this.add(BorderLayout.WEST, westContainer);
        
        /* MapView */
        this.add(BorderLayout.CENTER, mv);
        
        // Prepare and show the form
        this.requestFocus();
        this.setVisible(true);
        this.show();
        return true;
    }
    
    /**
     * Callback method from {PauseCommand @link com.mycompany.a3.commands.PauseCommand}
     * Play/Pause all sounds
     * Change the play/pause button text
     * @param  text    The text to change the button to
     * @return boolean Status of changing the button text
     */
    public boolean changePauseStatus(String text) {
    	gw.pauseSound();
    	bPauseCommand.setText(text);
        return true;
    }
    
    // Inherited method from Runnable class that is invoked upon the timer being triggered
	public void run() {
        // Only run the game if the GameWorld isn't paused
        if(gw.isPlaying) {
		  gw.update();
		  mv.repaint();
        }
	}
}
