//
// Christopher Simon
// csc60. Lab 5. Pointers
//

#include <stdio.h>
#include <stdlib.h>

void do_average(int x[], int xCount, double *avg, int *gtrCount);

int main(void)
{
	int i, greater;
	double average;
	
	int n[] = {6, 1, 35, 58, 46, 7, 70, 2, 9, 19, 21, 83, 10};
	size_t nCount = sizeof(n) / sizeof(n[0]); // (nCount*4bytes) / 4bytes
	
	printf("\n\nChristopher Simon, Lab 5 Output:\n");
	printf("\nThe numbers are: \n");
	for(i = 0; i < nCount; i++)
	{
		printf("%4i", n[i]);
	}
	printf("\n\n");
	
	// Given an array return the average and numbers greater than the avg
	do_average(n, nCount, &average, &greater);
	
	printf("The average is:  %5.2f\n\n", average);
	printf("The number of values > average is:  %2i\n\n",  greater);
	
	return EXIT_SUCCESS;
}

void do_average(int x[], int xCount, double *avg, int *gtrCount) {
	*gtrCount = 0;
	int i, sum = 0;
	for(i = 0; i < xCount; i++)
	{
		sum += x[i];
	}
	*avg = (double)sum / (double)xCount;
	
	for(i = 0; i < xCount; i++)
	{
		if(x[i] > *avg) (*gtrCount)++;
	}
}