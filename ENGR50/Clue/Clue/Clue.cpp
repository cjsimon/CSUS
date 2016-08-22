/*
Christopher Simon
Homework 3 - Clue
*/

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include "Outcomes.h"

void pause();

int main(void) {
	srand(time(NULL));

	// Prompt for the number of outcomes to produce
	int totalOutcomes = 15;
	do {
		printf("How many outcomes would you like to generate? ");
		scanf("%i", &totalOutcomes);
		fflush(stdin);
		getchar();
	} while (totalOutcomes <= 0);

	// The outcome manager and it's pointer for the game
	Outcome_t o;
	Outcome_t* op = &o;

	// Generate a random suspect, weapon and room for the user to guess
	generateOutcome(op);
	char* selectedSuspect = o.suspect;
	char* selectedWeapon = o.weapon;
	char* selectedRoom = o.room;

	int selectedIndex = (rand() % totalOutcomes) + 1;

	printf("Was it...\n");

	// The message to display for each outcome,
	// given the current outcome number and the outcome details
	char* message = "%d. %s with the %s in the %s\n";

	// Print generated outcomes before the selectedIndex
	for (int i = 1; i < selectedIndex; i++) {
		generateOutcome(op);
		printf(message, i, op->suspect, op->weapon, op->room);
	}

	// Print the selectedOutcome instead of generating a random one
	printf(message, selectedIndex, selectedSuspect, selectedWeapon, selectedRoom);

	// Print generated outcomes after the selectedIndex
	for (int i = selectedIndex + 1; i <= totalOutcomes; i++) {
		generateOutcome(op);
		printf(message, i, op->suspect, op->weapon, op->room);
	}

	printf("\nEnter the number of the outcome you wish to select!\n");
	bool stillGuessing = true;
	int tries = 1;
	do {
		printf("> ");
		int guessIndex;
		scanf("%i", &guessIndex);
		getchar();
		guessIndex;

		// End the game if the user has guessed correctlly
		if (guessIndex == selectedIndex) {
			stillGuessing = false;
		} else {
			printf("Try Again!\n");
			tries++;
		}
	} while (stillGuessing == true);

	printf("\n");
	printf("Correct! It was %s with the %s in the %s!\n", selectedSuspect, selectedWeapon, selectedRoom);
	printf("It took you %i %s to guess that!\n", tries, tries == 1 ? "try" : "tries");
	printf("\n");

	char again = 'n';
	printf("Would you like to play again? (y/n)\n");
	printf("> ");
	again = getchar();
	fflush(stdin);
	getchar();
	
	if(again == 'y') {
		return main();
	}

	printf("Bye bye!\n");
	pause();
	return EXIT_SUCCESS;
}

void pause() {
	printf("Press Enter to Continue...");
	getchar();
}