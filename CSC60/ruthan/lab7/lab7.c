/*--------------------------------------------------------------*/
/* Christopher Simon */
/* Lab 7             */
#include <stdio.h>
#include <stdlib.h>

/* Function Prototypes */
void bitprint (int num);
int rotate_left(int num, int n);

int main(void)
{
	int a, left_count, shifted_num;
	
	printf("Christopher Simon.  Lab 7.\n");
	for(;;)
	{
		// Read a signed integer
		printf("Enter an integer value (0 to stop):  ");
		scanf("%d", &a);
		
		if(!a) break;
		
		printf("Enter an integer value for the left shift: ");
		scanf("%d", &left_count);
		printf("\nOriginal is %i\n", a);
		
		bitprint(a);
		shifted_num = rotate_left(a, left_count);
		bitprint(shifted_num);
		printf("Shifted is %i\n", shifted_num);
	}
	return EXIT_SUCCESS;
}

void bitprint(int num)
{
	unsigned mask;
	int bit, count, nbits;
	
	// Set the initial mask to the number of bits an integer has
	nbits = 8 * sizeof(int);
	// Place a 1 in left most position starting place for the mask
	mask = 0x1 << (nbits - 1);
	
	for(count = 1; count <= nbits; count++)
	{
		// Set display bit on or off
		bit = (num & mask) ? 1 : 0;
		// Print display bit
		printf("%x", bit);
		
		// Leave a blank every 4 spaces
		if(count % 4 == 0) printf(" ");
		// Shift mask 1 position to the right
		mask >>= 1;
	}
	
	printf("\n");
	return;
}

int rotate_left(int num, int n)
{
	// Shift bits noncircularly
	//int bits = num << n;
	
	unsigned mask;
	int bit, count, nbits;
	
	nbits = 8 * sizeof(int);
	mask = 0x1 << (nbits-1);
	
	for(count = 0; count < n; count++) {
		bit = (num & mask) ? 1 : 0;
		num = num<<1;
		num += bit;
	}
	return num;
}