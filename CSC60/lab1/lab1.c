//
// Christopher Simon
// csc60. Lab 1. The First Program
//

#define PI 3.14159
// Macro definition for Area of a cylinder
#define cylinder_area(r, h) ((2.0*PI*r*h) + (2.0*PI*(r*r)))

// Path to libraries on Linux are found in: /usr/include
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	// Lab 1 with the quote of the day
	printf("Lab 1\n\n");
	printf("Hi, Christopher Simon\n\n");
	printf("We must embrace pain and burn it as fuel for our journey. ~Sanic The Hedgehog\n\n");
	
	// Math calculations with constant definition PI and scanf for input
	// Prompt for a radius and height
	printf("And now, for a math calculation!\n");
	printf("Enter a radius and a height to find the area of a cylinder.\n");
	double radius = 0.0, height = 0.0;
	//scanf("%lf,%lf", &radius, &height);
	printf("Radius: ");
	scanf("%lf", &radius);
	printf("Height: ");
	scanf("%lf", &height);
	
	// Display the inputted values
	printf("Radius: %.2lf\nHeight: %.2lf\n\n", radius, height);
	
	// Calculate the area of the cylinder and display it to the user
	printf("The area of the cylinder is: %.2lf\n", cylinder_area(radius, height));
	
	// The program has exited successfully
	return EXIT_SUCCESS; // 0
}