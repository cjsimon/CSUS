/*
Christopher Simon
Homework 2 - Rock Paper Scissors Lizard Vulcan
ENGR50 - Spring 2016
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int error(char *);
bool checkValue(int val, int min, int max);

// The name of each selection in the table of outcomes
const char *outcomeNames[5] = {
	"Rock",
	"Paper",
	"Scissors",
	"Lizard",
	"Vulcan"
};

// The table of outcomes for the game.
// 0: p0 Wins
// 1: p1 Wins
// 2: Tie
const unsigned short outcomes[5][5] = {
			/* r  p  s  l  v  P1 */
	/*  r  */{ 2, 1, 0, 0, 1 },
	/*  p  */{ 0, 2, 1, 1, 0 },
	/*  s  */{ 1, 0, 2, 0, 1 },
	/*  l  */{ 1, 0, 1, 2, 0 },
	/*  v  */{ 0, 1, 0, 1, 2 }
	/*  P0 */
};

int main(void) {
	// Generate a random computer choice
	// Seed the random value
	srand(time(NULL));

	int playAgain = 0;
	do {
		// % 5 will return a remainder from 0 to 4
		int c = (rand() % 5);

		// Get the player choice
		unsigned int p;
		printf(
			"The choices are:\n"
			"Rock | Paper | Scissors | Lizard | Spock\n"
			"  1      2         3         4       5\n\n"
			);
		printf("Pick your player: ");
		scanf("%i", &p);

		// Only proceed if the input value, p, is between 1 and 5
		// Otherwise, restart the game loop
		if(!checkValue(p, 1, 5)) {
			fflush(stdin);
			printf("Please input a number between 1 and 5\n\n");
			playAgain = 1;
			continue;
		}

		// Play the game with the selected players. p is 0 based
		// Alter the message according to the winner
		char *message;
		switch (outcomes[--p][c]) {
			case 0: message = "won"; break;
			case 1: message = "lost"; break;
			case 2: message = "tied"; break;
			default: return error("An unexpected error has occured. . .");
		};

		// Print the outcome of the game
		printf("You %s against %s using %s!\n", message, outcomeNames[c], outcomeNames[p]);

		printf("Type 1 to play again: ");
		scanf("%i", &playAgain);
	} while(playAgain);

	return EXIT_SUCCESS;
}


/// <sumarry>
/// Terminates the program, returning an error code, with a given error message, msg
/// </sumarry>
/// <param name="val">The message that indicates the reason for error</param>
/// <returns>The error status</returns>
int error(char *msg) {
	// char *end;

	fflush(stdin);
	printf("%s\n", msg);

	// printf("Press enter to continue . . .");
	// scanf("*%n");
	// scanf("%s", &end);

	system("pause");
	return -1;
}

/// <sumarry>
/// Checks if val is within a given min and max
/// </sumarry>
/// <param name="val">The val to compare to</param>
/// <param name="min">The min int</param>
/// <param name="max">The max int</param>
/// <returns>bool</returns>
bool checkValue(int val, int min, int max) {
	return (val > min && val < max);
}