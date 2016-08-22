#include <stdio.h>
int main()
{
	int a;
 	int *aPtr, *bPtr;
        int arr[8];
        arr[0] = 9;
        arr[1] = 11;
        arr[2] = 21;
        arr[3] = 92;
        aPtr = &arr[0]; 
        aPtr += 2;
        printf("%d\n", *aPtr); 
	return 0;
}
