// Pass by ref illustration
#include <stdio.h>
//
void square (int * x)
{
  *x =  (*x) * (*x);
}
//
int main ( )
{
   int num = 10;
   square(&num);
   printf("Value of num is %d\n",num); /* num will be 100 */
   return 0;
}
