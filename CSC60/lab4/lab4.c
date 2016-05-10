#include <stdio.h>
#include <stdlib.h>

int main(void) {
	double x[] = {5.2, 6.1, 4.9, -8.5, 4.6, 3.7};
	double *xptr = &x[0];
	
	printf("%s\n", "Pointers");
	printf("%f\n", *xptr);
	printf("%f\n", *xptr + 3);
	printf("%f\n", *(xptr + 3));
	printf("%f\n", *xptr + *(xptr + 5));
	printf("%f\n", *(xptr + 2) - 1);
	printf("%f\n", x[3] - *xptr);
	printf("%f\n", *xptr + x[5] + *(xptr + 1) + x[2]);
	printf("%f\n", *x);
	printf("%f\n", *x + *xptr);
	printf("%f\n", x[2] - *xptr + 3);
	
	int a[] = {-6, 3, 4, 1, 8, 20, 16, 7};
	int* aptr = &a[2];
	
	printf("%s\n", "Partial Sums");
	printf("%i\n", partial(aptr, 2));
	printf("%i\n", partial(aptr + 1, 3));
	printf("%i\n", partial(a, 8));
	printf("%i\n", partial(a, 4));
	printf("%i\n", partial(aptr, a[1]));
	printf("%i\n", partial(&a[3], 2));
	
}

int partial(int x[], int npts) {
	int k, sum = 0;
	for(k = 0; k < npts; k++) {
		sum += x[k];
	}
	return sum;
}