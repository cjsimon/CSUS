package com.mycompany.a2;

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
		// Keyboard Command Label
		Label commandLabel = new Label("Enter a Command:");
		this.addComponent(commandLabel);
		final TextField commandTextField = new TextField();
		this.addComponent(commandTextField);
		this.show();

		// Create an action listener to check for changes in the text field
		commandTextField.addActionListener(new ActionListener() {
			// Keep track of the previous char so that different states can be checked
			char previousCommand;
			// ActionPreforrmed corresponds to the enter key in text field
			// Why isn't this documented...?!
			public void actionPerformed(ActionEvent evt) {
				// System.out.println("Enter Key Pressed");
				String commandString = commandTextField.getText().toString().toLowerCase();
				if(commandString.length() < 1) return;
				char command = commandString.charAt(0);
				commandTextField.clear();
				executeCommand(command, previousCommand);
				previousCommand = command;
			}
		});
	}
	
	private boolean executeCommand(char command, char previousCommand) {
		switch(command) {
		case 'a':
			// Transfer the spaceship to a location of a randomly selected alien.
			// If there are no aliens, print an error message instead
			System.out.println("Move Spaceship to Alien");
			gw.moveSpaceshipToAlien();
			break;
		case 'o':
			System.out.println("Move Spaceship to Astronaut");
			gw.moveSpaceshipToAstronaut();
			break;
		case 'u':
			// Move the spaceship up
			System.out.println("Move spaceship up");
			gw.moveSpaceshipUp(1);
			break;
		case 'd':
			// Move the spaceship down
			System.out.println("Move spaceship down");
			gw.moveSpaceshipDown(1);
			break;
		case 'l':
			// Move the spaceship to the left
			System.out.println("Move spaceship left");
			gw.moveSpaceshipLeft(1);
			break;
		case 'r':
			// Move the spaceship to the right
			System.out.println("Move spaceship to right");
			gw.moveSpaceshipRight(1);
			break;
		case 'e':
			// Expand the spaceship object
			System.out.println("Expand the spaceship");
			gw.expand(10);
			break;
		case 'c':
			// Contract (decrease) the size of the spaceship door
			// (the center location shouldn’t change)
			System.out.println("Contract the spaceship");
			gw.contract(10);
			break;
		case 't':
			// Tell the game world that the “game clock” has ticked. All moving objects
			// are told to update their positions according to their current direction and speed
			System.out.println("Update by one frame...");
			gw.update();
			break;
		case 's':
			// Open the door and update the score according to the types and conditions of
			// opponents that are let into the spaceship as described above in rules of play. This
			// causes all of the opponents whose centers are within the boundaries of the bounding
			// square of the door to be removed from the game world.
			System.out.println("Check for collision on door. Apply score.");
			gw.openDoor();
			break;
		case 'w':
			// PRETEND that a collision occurred between two aliens. This type of collision means
			// that a new alien is generated. Later this semester, your program will determine this
			// automatically But for now, if the player specifies the ‘w’ command, the program first
			// checks if there are at least two aliens. If so, it randomly picks an alien and produces a
			// new alien in a location that is close to the chosen alien. If the number of aliens in the
			// world is less than two, print an error message without producing a new alien.
			System.out.println("Two Aliens Collided");
			gw.colAlien();
			break;
		case 'f':
			// PRETEND that a collision occurred between an alien and an astronaut. This type of
			// collision means that a fight occurred between an alien and an astronaut. Just like the
			// alien-alien collisions, later this semester, your program will determine alien-astronaut
			// collisions automatically 1. But for now, if the player specifies the ‘f’ command, the
			// program randomly picks an astronaut and decrements its health value, updates its
			// speed, and changes its color. If there are no aliens, print an error message instead
			System.out.println("An Alien hit an Astronaut");
			gw.colAstronautAlien();
			break;
		case 'p':
			// Print the points of game state values: (1) current score, (2) number of astronauts
			// rescued, (3) number of aliens sneaked in to the spaceship, and (4) number of
			// astronauts left in the world, (5) number of aliens left in the world. Output should be
			// appropriately labeled in easily readable format
			System.out.println("Print out the objects:");
			gw.printObjects();
			break;
		case 'm':
			// Print a "map" showing the current world state (see below)
			System.out.println("Print out the map");
			gw.printMap();
			break;
		case 'x':
			// Exit, by calling the method System.exit(0) to terminate the program. Your
			// program should confirm the user’s intent (see ‘y’ and ‘n’ commands below) to quit
			// before actually exiting.
			System.out.println("Are you sure you would like to exit? (Y/N)");
			break;
		case 'y':
			// Check if the previous command was the exit command
			if(previousCommand == 'x') {
				// User has confirmed the exit by saying yes
				System.out.println("Exitting... Bye Bye!");
				System.exit(0);
			}
			break;
		case 'n':
			// User has denied the exit by saying no
			break;
		}
		// Command executed successfully
		return true;
	}
}
