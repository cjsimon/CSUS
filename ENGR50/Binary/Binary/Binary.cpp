/*
Christopher Simon
Homework 3 - Binary
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void pause();

int main(void) {
	// Description
	printf(
		"This program will print a table of the unsigned values in\n"
		"Decimal, Hexadecimal, and Binary formats.\n"
		"The table size is determined by the number of bits the user specifies.\n"
		"The bit range can be from 1 to 10 bits.\n\n"
	);

	// Prompt for the number of bits to produce
	int totalBits = 8;
	do {
		printf("Input the number of bits to show in the table [1 - 10]\n");
		printf("> ");
		scanf("%i", &totalBits);
		fflush(stdin);
		getchar();
	} while (totalBits < 1 || totalBits > 10);

	int bitRange = (int)pow(2, totalBits) - 1;
	
	printf("%15s%15s%15s\n", "Integer", "Hexidecimal", "Binary");
	// For each number from 0 to bitRange
	for (int i = 0; i <= bitRange; i++) {
		// For each bit in the current number, i
		printf("%9i%11x%19s", i, i, "");
		int number = i;
		for (int b = totalBits-1; b >= 0; b--) {
			int bit = 0;
			int power = (int)pow(2, b);
			if(number / power != 0) {
				bit = 1;
			}
			number -= power * bit;
			printf("%i", bit);
		}
		printf("\n");
	}

	printf("\n");
	pause();
	return EXIT_SUCCESS;
}

void pause() {
	printf("Press Enter to Continue...");
	getchar();
}