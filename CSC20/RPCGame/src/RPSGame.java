/**
 * Author:          Christopher Simon
 * Class Section:	CSc 28 - 1
 * Instructor:		Buckley
 *
 * File Name: 		RPSGame.java
 * Description:		A two player rock paper scissors game
 *
 * Date Created: 	1/29/2015
 * Last Modified:	1/30/2015
 */

import java.util.Scanner;

/* RPS Handler */
public class RPSGame {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        //Create a RPS game handler given an input scanner
        Game rps = new Game(input);

        //Is the user done playing?
        boolean notDone;
        //Run the game until the user is done doing so
        do {
            //Play the rps game
            rps.play();
            System.out.println(rps.getLastGameStatus());
            //Prompt for another game
            String message = "Yes or No: Would you like to play again? ";
            notDone = question(message, input);
        } while(notDone);
        //The user has finished playing
        System.out.println("Thanks for playing!");
    }

    /**
     * Prompts for an answer to a yes or no question
     * given a message and a scanner for input
     */
    public static boolean question(String m, Scanner s) {
        System.out.print(m);
        //Filter the response from the input
        String response = s.nextLine().toLowerCase();
        if(response.equals("yes") || response.equals("y")) {
            return true;
        } else if(response.equals("no") || response.equals("n")) {
            return false;
        }
        //Invalid Input
        System.out.println("Please enter either 'Yes' or 'No'.\n");
        //Prompt once more
        return question(m, s);
    }
}

/* RPS Game Logic */
class Game {
    private Scanner input;
    //The players' respective choices represented as chars
    private char[] playerChoice = new char[2];
    //The status of the last game played
    private String lastGameStatus = "The game has not been run yet!";

    public Game(Scanner input) {
        //Set this class scanner to the one passed in
        this.input = input;
    }

    /* Get the status of the last game played */
    public String getLastGameStatus() {
        return lastGameStatus;
    }

    /**
     * Prompt for player choices and run the game to see who wins.
     * The status of the game is stored in lastGameStatus for retrieval
    */
    public void play() {
        //Prompt for player choices
        prompt();
        //Run the visual effect
        visual();
        //Run the game and get the results
        compare();
    }

    /* Prompt for player choices */
    public void prompt() {
        //The error string
        String error = (
            "Please type in 'rock','paper', or 'scissors'.\n"
        );
        //The current choice
        String choice = "";
        //For each player
        for(int i = 0; i < 2; i++) {
            System.out.print(
                "Player "
                + (i+1)
                + ": Will you pick (r)ock (p)aper or (s)cissors? "
            );
            try {
                //Get the player choice
                choice = input.nextLine().toLowerCase();
            } catch(Exception e) {
                //Error
                System.out.println(error);
                //Repeat the last iteration
                i--;
            }

            //Evaluate the input
            if(choice.equals("rock") || choice.equals("r")) {
                playerChoice[i] = 'r';
            } else if(choice.equals("paper") || choice.equals("p")) {
                playerChoice[i] = 'p';
            } else if(choice.equals("scissors") || choice.equals("s")) {
                playerChoice[i] = 's';
            } else {
                //Invalid choice
                System.out.println(error);
                i--;
            }
        }
    }

    /* Create a text visual to represent the game play */
    public void visual() {
        try {
            System.out.print("\nRock...");
            Thread.sleep(500);
            System.out.print("Paper...");
            Thread.sleep(500);
            System.out.println("Scissors!\n");
            Thread.sleep(700);
        } catch(InterruptedException e) {}
    }

    /* Compare player choices and store the calculated game result */
    public void compare() {
        //Players' choices
        char p1 = playerChoice[0];
        char p2 = playerChoice[1];

        //Calculate the status of the game
        if(p1 == p2) {
            //Game ends in a tie if both players choose the same option
            lastGameStatus = "Tie!";
        } else if((p1 == 'r' && p2 == 's')
                || (p1 == 'p' && p2 == 'r')
                || (p1 == 's' && p2 == 'p')) {
            //Player 1 win cases
            lastGameStatus = "Player 1 Wins!";
        } else {
            //All other cases are of player 2 winning
            lastGameStatus = "Player 2 Wins!";
        }
    }
}