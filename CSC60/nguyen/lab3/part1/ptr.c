#include <stdio.h>
int main()
{
	int a;
 	int *aPtr;

	a = 7; /* a is an integer */
	aPtr = &a; /* aPtr is a pointer to an integer of a */

	printf("The address of a is %p"
		"\nThe value of aPtr is %p", &a, aPtr);

	printf("\n\nThe value of a is %d"
		"\nThe value of *aPtr is %d\n", a, *aPtr);

	return 0;
}
