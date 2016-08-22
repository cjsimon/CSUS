/*
Christopher Simon
Midterm 1 - Temperature
ENGR50 - Spring 2016
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <float.h>

// The <math.h> positive INFINITY macro is not working correctly in the code,
// so use the C++ defined min and max integer limits instead
//#define POS_INFINITY std::numeric_limits<int>::max();
//#define NEG_INFINITY std::numeric_limits<int>::min();

// To refrain from using C++, as per instructor request,
// use the C macros for limits on an integer instead: INT_MIN, INT_MAX

// Convert from celsius to farinheit
#define toFarinheit(tempC) (tempC * (9 / 5) + 32)
// Default step size bounds
#define STEPMIN 1
#define STEPMAX 10

void getValues(int argc, char** argv);
void printTemp(double min, double max, double step, int dec);
int checkValues(double vals[][3]);
void pause();

// The temperature bounds, step size and number of decimal places to display
double min = 0, max = 0, step = 0;
int dec = 0;

int main(int argc, char** argv)
{
	// Get the values for the program,
	// either as commandline arguments or user input
	getValues(argc, argv);
	printTemp(min, max, step, dec);
	system("pause");
	pause();
}

void getValues(int argc, char** argv) {
	// Get any values that are passed as arguments,
	// and store them in their respective variables
	if (argc >= 2)
	{
		min = atof(argv[1]);
	}
	if (argc >= 3)
	{
		max = atof(argv[2]);
	}
	if (argc >= 4)
	{
		step = atof(argv[3]);
	}
	if (argc >= 5)
	{
		dec = atoi(argv[4]);
	}

	int notDone;
	do {
		// Depending on how many args were put in,
		// prompt for the remaining values not entered as arguments.
		// Conviniently, the filename is passed in as an arg by default,
		// thus making argc = 1 when no other arguments are passed in manually.
		// The case statemnents fall through all other cases so that all other
		// values following are also given values as well
		switch (argc)
		{
		case 1:
			printf("Please enter a lower bound for the Tempurature (C): ");
			scanf("%Lf", &min);
		case 2:
			printf("Please enter an upper bound for the Tempurature (C): ");
			scanf("%Lf", &max);
		case 3:
			printf("Please enter a step size interval between %i and %i: ", STEPMIN, STEPMAX);
			scanf("%Lf", &step);
		case 4:
			printf("Please enter the number of decimal points to display: ");
			scanf("%i", &dec);
			break;
		}


		// Construct the valueRange array for the checkValue method
		double valueRange[][3] = {
			{min, -DBL_MAX, DBL_MAX},
			{max, min, DBL_MAX},
			{step, 1, 10},
			{dec, 0, 10},
		};

		// If all values are valid, checkValid results in 0,
		// thus not running the error and ending the while loop
		if (notDone = checkValues(valueRange))
		{
			fprintf(stderr, "Error! One or more values are out of range!\n");
			// Prompt for all values again by clearing the argc,
			// so that all cases are run
			//argc = 1;
			// Prompt for the variable where an error occured.
			// This will also prompt for following variables,
			// even though they might be already valid.
			// Modifying argc will comprimise argv, however
			// we no longer want to use these values anyways.
			// In other circumstances, it might be better to
			// create another variable for this opporation, so
			// that argv can safely be accessed at all times
			argc = notDone;
		}
	} while (notDone);
}

/*
Prints a range of tempertures in both celsius and farenheit,
given a starting temp, min, and ending temp, max, and an interval, step.
dec represents how many decimal places will be printed out
*/
void printTemp(double min, double max, double step, int dec)
{
	int pad = 10;
	// Padding doesn't seem to be working for %*s
	printf("%s%10s\n", "Celsius", /*pad,*/ "Farenheit");
	printf("%s%10s\n", "-------", /*pad,*/ "---------");
	for (double tempC = min; tempC <= max; tempC += step)
	{
		double tempF = toFarinheit(tempC);
		// To align with the headers, padding is determined
		// by the pad used by the header minus dec
		printf("%.*Lf%*s%.*Lf\n", dec, tempC, (pad-dec), " ", dec, tempF);
	}
}

/*
Checks whether a set of values are valid or not, given a list of arrays
containing the value being compared and it's expected min and max bounds
that the value should be between
*/
int checkValues(double vals[][3])
{
	// Check if each variable is between their respecitve min and max bounds,
	// vals[1] and vals[2] respectively
	for (int v = 0; v <= 3; v++)
	{
		double val = vals[v][0], min = vals[v][1], max = vals[v][2];
		// Return the first 1 based index of the value that is not within it's bounds
		if (val < min || val > max) return v + 1;
	}
	return 0; // All values are within their respective bounds
}

void pause() {
	fflush(stdin);
	printf("Press Enter to Continue...");
	getchar();
}