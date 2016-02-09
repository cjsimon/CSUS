/*
Christopher Simon
Homework 1 - Printing Asterix 0 and scanning a 5 digit number
ENGR50 - Spring 2016
*/

#include <iostream>
#include <string>
#include <limits>
#include <math.h>

using namespace std;

// Function Prototypes
// Systematic Functions
void pause(char key = '\0', std::string = "");
bool checkDigits(int, int);
int countChars(char*);
void seperate(int[], int, int);
// Program Segments
void hello(void);
void part1(void);
void part2(void);

int main(void)
{
	// Run the seperate parts of the homework, pausing in between
	hello();
	pause();
	printf("\n");
	
	part1();
	pause();
	printf("\n");
	
	part2();
	pause();
	printf("\n");

	// The program has terminated sucessfully without any errors
	return EXIT_SUCCESS; // 0
}

/* The introduction of the console application that prompts for a name */
void hello(void)
{
	// The input name, using a C++ style string
	std::string name;

	// Print using printf, the C implementation of printing
	printf("Hello World!\n");

	// Print using stdio, a C++ library used for input and output
	std::cout << "Welocome to ENGR50!" << endl << "What is your name? ";

	// Prompt for and display the user's name
	std::cin >> name;
	std::cin.ignore(); // Swallow the '\n' from the input
	std::cout << "Hello " << name << "!" << endl;
}

/* Part1 of the homework assignment */
void part1()
{
	printf("Here, have a zero.\n");
	printf("  ***\n");
	printf(" *   *\n");
	printf("*     *\n");
	printf("*     *\n");
	printf("*     *\n");
	printf("*     *\n");
	printf("*     *\n");
	printf(" *   *\n");
	printf("  ***\n");
}

/* Part2 of the assignment */
void part2()
{
	// The digit count for the input number
	const int nTotal = 5;

	// The user inputted number and it's length
	int number;

	// Do the following so long as the requirements are not done
	bool isDone = 0;
	do {
		// Assume requirements are met, until proven otherwise
		isDone = 1;

		// Get the number from the user
		printf("Please enter a %i or lower digit number: ", nTotal);
		scanf("%i", &number);

		// Check if the input number have the expected number of digits
		//if (isDone = checkDigits(number, nTotal))
		if(number > 99999 || number < 0)
		{
			// Error! The requirements are notDone
			isDone = 0;
			printf("Error! you must enter a %i or lower digit number!\n", nTotal);
			fflush(stdin);
		}
	} while (!isDone);

	// The number list, n
	// Modify n to contain the seperate the digits from number
	int n[nTotal];
	seperate(n, number, nTotal);

	// Calculate the greatest number, and the sum
	int max, sum;
	sum = max = n[0];

	// Print out each number
	for (int i = 0; i < nTotal; i++) {
		printf("%i   ", n[i]);
	}
	printf("\n");

	for (int i = 1; i < nTotal; i++) {
		// Get the current int from the array
		int current = n[i];
		// Add to the sum
		sum += current;
		// If the current number, n[i], is greater than the greatest value,
		// then by defenition, it is the largest number
		if(current > max) max = current;
	}

	// Print the sum, avg and largest number
	printf("The sum of the numbers is: %i\n", sum);
	printf("The average of the numbers is: %i\n", sum / nTotal);
	printf("The largest number is: %i\n", max);
}

///<summary>
/// Counts the number of characters in a given char*, c
///</summary>
/// <param name="n">The input number to check against</param>
/// <param name='d'>The expected number of digits contained in n</param>
int countChars(char *c) {
	int count = 0;
	// Loop so long as the i value at c exists
	for (int i = 0; c[i]; i++) {
		if(c[i] != '\0') count++;
	}
	return count;
}

///<summary>
/// Checks to see if the input number, n, contains the expectedNumber of digits
///</summary>
/// <param name="n">The input number to check against</param>
/// <param name='d'>The expected number of digits contained in n</param>
bool checkDigits(int n, int d) {
	// Division between the an input number, n, with the same number of digits, d,
	// should yield a result less than 1. Integer division truncates these values to 0, or false
	return !(n / (int)(100000));
}

///<summary>
/// Creates an array of digits from a given integer, number
///</summary>
/// <param name="n">The array containing the digits of the number</param>
/// <param name='number'>The number to be seperated into digits</param>
/// <param name='size'>The number of elements in the array</param>
void seperate(int n[], int number, int size)
{
	// Represent the size as an index
	size--;

	// Seperate the numbers based on each 10's place
	for (int i = 0; i < size; i++)
	{
		// Get the place value for the current digit
		int place = (int)(pow(10, size - i));

		// Pop that number off the top
		n[i] = number / place;
		// Truncate the number
		number %= place;
	}
	n[size] = number;

	// Hardcoded
	/*
	*(n + 0) = number / 10000;
	number = number % 10000;

	*(n + 1) = number / 1000;
	number = number % 1000;

	*(n + 2) = number / 100;
	number = number % 100;

	*(n + 3) = number / 10;
	*(n + 4) = number % 10;
	*/

	// DEBUG: Print the values
	// *(n + i) interchangable with n[i]
	//printf("%i   %i   %i   %i   %i", n[0], n[1], n[2], n[3], n[4]);
}

/// <summary>
/// Stall the terminal until a specified key is pressed.
/// </summary>
/// <param name="key">The key to press before resuming</param>
/// <param name='message'>The message used to indicate about the pause</param>
void pause(char key, std::string message)
{
	// Resume on any key press
	if(key == '\0')
	{
		// TODO: Find a cross compatible pause function
		system("pause");	
		return;
	}

	// Resume on specified key press
	std::cout << message;
	std::cin.ignore(std::numeric_limits<std::streamsize>::max(), key);
}