package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form {
	private GameWorld gw;

	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	@SuppressWarnings("rawtypes")
	private void play() {
		// Run the GameWorld play method every iteration of the main game loop
		gw.play();
		
		// TODO
		// Code here to accept and user commands that operate on the game world
		// (refer to “Appendix - CN1 Notes” for accepting keyboard commands via
		// a text field located on the form)
		Label commandLabel = new Label("Enter a Command:");
		this.addComponent(commandLabel);
		final TextField commandTextField = new TextField();
		this.addComponent(commandTextField);
		this.show();

		// Create an action listener to check for changes in the text field
		commandTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = commandTextField.getText().toString();
				commandTextField.clear();
				
				// Get the first char as the command
				switch(sCommand.charAt(0)) {
				case 'a':
					// Transfer the spaceship to a location of a randomly selected alien.
					// If there are no aliens, print an error message instead
					
					break;
				case 'o':
					// Transfer the spaceship to a location of a randomly selected astronaut
					
					break;
				case 'u':
					// Move the spaceship up
					
					break;
				case 'd':
					// Move the spaceship down
					
					break;
				case 'l':
					// Move the spaceship to the left
					
					break;
				case 'r':
					// Move the spaceship to the right
					
					break;
				case 'e':
					// Expand the spaceship object
					gw.expand();
				case 'c':
					// Contract (decrease) the size of the spaceship door
					// (the center location shouldn’t change)
					gw.contract();
					break;
				case 't':
					// Tell the game world that the “game clock” has ticked. All moving objects
					// are told to update their positions according to their current direction and speed
					
					break;
				case 's':
					// Open the door and update the score according to the types and conditions of
					// opponents that are let in to the spaceship as described above in rules of play. This
					// causes all of the opponents whose centers are within the boundaries of the bounding
					// square of the door to be removed from the game world.
					
					break;
				case 'w':
					// PRETEND that a collision occurred between two aliens. This type of collision means
					// that a new alien is generated. Later this semester, your program will determine this
					// automatically 1. But for now, if the player specifies the ‘w’ command, the program first
					// checks if there are at least two aliens. If so, it randomly picks an alien and produces a
					// new alien in a location that is close to the chosen alien. If the number of aliens in the
					// world is less than two, print an error message without producing a new alien.
					
					break;
				case 'f':
					// PRETEND that a collision occurred between an alien and an astronaut. This type of
					// collision means that a fight occurred between an alien and an astronaut. Just like the
					// alien-alien collisions, later this semester, your program will determine alien-astronaut
					// collisions automatically 1. But for now, if the player specifies the ‘f’ command, the
					// program randomly picks an astronaut and decrements its health value, updates its
					// speed, and changes its color. If there are no aliens, print an error message instead
					
					break;
				case 'p':
					// Print the points of game state values: (1) current score, (2) number of astronauts
					// rescued, (3) number of aliens sneaked in to the spaceship, and (4) number of
					// astronauts left in the world, (5) number of aliens left in the world. Output should be
					// appropriately labeled in easily readable format
					
					break;
				case 'm':
					// Print a “map” showing the current world state (see below)
					
					break;
				case 'x':
					// Exit, by calling the method System.exit(0) to terminate the program. Your
					// program should confirm the user’s intent (see ‘y’ and ‘n’ commands below) to quit
					// before actually exiting.
					
					break;
				case 'y':
					// User has confirmed the exit by saying yes
					
					break;
				case 'n':
					// User has confirmed the exit by saying no
					
					break;
				}
			}
		});
	}
}
