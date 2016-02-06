/*
Christopher Simon
Homework 1 - Printing Asterix 0 and scanning a 5 digit number
ENGR50 - Spring 2016
*/

#include <iostream>
#include <string>
#include <limits>

using namespace std;

// Function Prototypes
void pause(char key = '\0', std::string = "");
void hello(void);
void part1(void);
void part2(void);

int main(void)
{
	// Run the seperate parts of the homework, pausing in between
	hello();
	pause();
	
	part1();
	pause();
	
	part2();
	pause();

	// The program has terminated sucessfully without any errors
	return EXIT_SUCCESS; // 0
}

/* The introduction of the console application that prompts for a name */
void hello(void)
{
	// The input name
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
	int n[5];
	char c;
	
	c = getc(stdin);
	for(int i = 4; i < 0; i--) {
		if(getc(stdin) != '\n') break;
		n[i] = getc(stdin);
		printf("Number: %s\n", n[i]);
	}
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