//
// Christopher Simon
// csc60. Lab 3. File I/O
//

#include <math.h>
#include <stdio.h>
#include <stdlib.h>

// Macro definition for Area of a cylinder
#define cylinder_area(r, h) ((2.0 * M_PI * r * h) + (2.0 * M_PI * (r*r)))
#define cylinder_volume(r, h) (M_PI * (r*r) * h)

// Prototypes
void fileExists(FILE*);

int main(int argc, char **argv) {
	// The input radius and height
	// along with the resulting area and volume
	double radius = 0, height = 0;
	double area = 0, volume = 0;
	
	// The file names to read and write to
	// coming either as an argument in the command line
	// or as the defalut file names
	char* inputFileName = "lab3.dat";
	char* outputFileName = "lab3.out";
	if(argc >= 2) {
		inputFileName = argv[1];
	}
	if(argc >= 3) {
		outputFileName = argv[2];
	}
	
	// The input output file handlers with their respective fileNames
	FILE* inputfp;
	FILE* outputfp;
	
	// Check if there was an error while attempting to open each file
	inputfp = fopen(inputFileName, "r");
	fileExists(inputfp);
	
	outputfp = fopen(outputFileName, "w");
	fileExists(outputfp);
	
	// Print the header
	fprintf(outputfp, "Christopher Simon.\tLab 3 Cylinders.\n\n");
	fprintf(outputfp, "%10s%+10s%+10s%+10s\n", "Radius", "Height", "Area", "Volume");
	fprintf(outputfp, "%10s%+10s%+10s%+10s\n", "------", "------", "----", "------");
	// Keep scanning the content in the file pointer, inputfp,
	// until two floats aren't returned from the scan
	while(fscanf(inputfp, "%lf%lf", &radius, &height) == 2) {
		// Print the calculated area and volume
		area = cylinder_area(radius, height);
		volume = cylinder_volume(radius, height); 
		fprintf(outputfp, "%10.2f%10.2f%10.2f%10.2f\n", radius, height, area, volume);
	}
	
	fclose(outputfp);
	fclose(inputfp);
	return EXIT_SUCCESS;
}

void fileExists(FILE* fp) {
	if(fp == NULL) {
		perror("Cannot find file");
		exit(0);
	}
}