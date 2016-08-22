// Pass by value illustration
#include <stdio.h>
//
int square (int x)
{
  return x*x;
}
//
int main ( )
{
   int num = 10;
   int answer;
   answer = square(num);
   printf("Value of a is %d\n",num); /* num will be 10 */
   printf("Answer is %d\n",answer); /* answer is 100 */
   return 0;
}
