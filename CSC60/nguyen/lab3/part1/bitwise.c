/* This program tests bitwise operators */`
#include <stdio.h>
main()
{
  unsigned sum = 4;
  printf("%d sum & 2\n", sum & 2);
  printf("%d sum | 2\n", sum | 2);
  printf("%d sum ^ 2\n", sum ^ 2);
  printf("%d sum >> 2\n", sum >> 2);
  printf("%d sum << 2\n", sum << 2);
  printf("%d ~sum \n", ~sum);
}
  
