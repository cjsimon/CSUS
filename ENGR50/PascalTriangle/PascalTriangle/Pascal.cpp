/*
Christopher Simon
Midterm 1 - Pascal's Triangle
ENGR50 - Spring 2016
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void buildPascal(int size);
void displayPascal(int size);
void printSpaces(int n);
void pause();

#define SIZE 8

int pascal[SIZE][SIZE];

int main(void)
{
	// A pascal triangle can be premade to store
	// a set of combinations, nCr, for retrival
	// in O(1) time, using O(n^2) memory
	buildPascal(SIZE);
	displayPascal(SIZE);
	printf("\n");
	pause();
}

void buildPascal(int size)
{
	// Base case row zero. The fisrt combination, nCr, is 1
	pascal[0][0] = 1;

	// For each column from [1 to size], each containing col number of rows
	for (int col = 1; col <= size; col++)
	{
		// The first row will always be 1 in each column
		pascal[col][0] = 1;

		// For each induvidual row within the column, from [1 to the current col]
		for (int row = 1; row <= col; row++)
		{
			// Get the previous combinations from the column before,
			// from the left and right and add them up together.
			int previousLeft = pascal[col - 1][row - 1];
			int previousRight = pascal[col - 1][row];
			pascal[col][row] = previousLeft + previousRight;
		}
	}
}


/* Displays a pascal triangle in a visual format */
void displayPascal(int size)
{
	// Create a visual triangle starting in the middle
	for (int col = 0, leftSpaces = size; col <= size; col++, leftSpaces -= 1)
	{
		printSpaces(leftSpaces);
		for (int row = 0; row <= col; row++)
		{
			printf("%i ", pascal[col][row]);
		}
		printf("\n");
	}
}

void printSpaces(int n)
{
	for (int s = 0; s < n; s++)
	{
		printf(" ");
	}
}

void pause() {
	printf("Press Enter to Continue...");
	getchar();
}