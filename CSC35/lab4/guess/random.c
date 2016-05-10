#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/**
 * Simple program to call the srand and rand functions.
 * Using gcc to generate the assembly code, we can view
 * how these functions are invoked by the assembler, so
 * that we can implement them into our lab4 program.
 */
int main(void) {
	// Generate the random seed based on the current time
	srand(time(NULL));
	// Generate a random number from 1 to 100
	int number = rand() % 100 + 1;
	printf("%i\n", number);
	return 0;
}
