# Guessing Game
This guessing game implements a difficulty selection that generates a random number for the user to guess, as opposed to typing in a secret number beforehand as per the assignment. A reference txt file is included, containing all of the websites that were utilized to help develop the program.

In order to understand how a random number is calculated in assembly, as suggested on StackOverflow, I wrote a simple C program that generates a random number. I then exported that file to assembly, to see what routines were involved in the underlying process. I learned that there are a set of assembly libraries that makes this much easier in C.

Since I used C linux libraries to generate a random number, I had to include those libraries when linking my program. I went ahead and created two seperate makefiles to compile my solution using both gcc and the standard asm and linking method that we use in class. Interestingly, as a result of using the GCC interface to run asm, I found that I needed to change my globl entry function to 'main' instead of _start.

I was trying to figure out how to use the FYLX2 instruction to calculate the powers of 10 for the different difficulties in the game, but I couldn't get it working. For now, I hardcoded those values into the program for the 5 different difficulties.
