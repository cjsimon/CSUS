# Guessing Game
This guessing game implements a difficulty selection that generates a random number for the user to guess, as opposed to typing in a secret number beforehand as per the assignment. A [reference txt file][1] is included, containing all of the websites that were utilized to help develop the program.

In order to understand how a random number is calculated in assembly, [as suggested on StackOverflow][2], I wrote a simple C program that generates a random number. I then [compiled that program to assembly][3], [targeting][5] [32 bit platform][4], to see what routines were involved in the underlying process. I learned that there are a set of assembly libraries that makes this much easier in C.

Since I [used C linux libraries in the assembly program][7] to generate a random number, I had to [include those libraries when linking][6] my program. (See [here][8] for details on creating a C library) I went ahead and created two seperate makefiles to compile my solution using both [GCC][13] and the [standard asm][12] linking method that was used in class. Interestingly, as a result of using the GCC interface to compile the asm code, I learned that I needed to [change the *globl* entry function][11] to [*main*][10] instead of [*_start*][9].

I was trying to figure out how to use the [FYLX2][1] instruction to calculate the powers of 10 for the different difficulties in the game, but I couldn't get it working. For now, I hardcoded those values into the program for the 5 different difficulties.

[1]: https://github.com/cjsimon/CSUS/blob/master/CSC35/lab4/guess/references.txt
[2]: http://stackoverflow.com/questions/8226540/use-int-randvoid-in-assembly
[3]: http://stackoverflow.com/questions/7190050/how-do-i-compile-the-asm-generated-by-gcc
[4]: http://stackoverflow.com/questions/6268745/invalid-instruction-suffix-for-push-when-assembling-with-gas
[5]: http://stackoverflow.com/questions/12249842/creating-and-calling-function-in-x86-assembly-att-syntax
[6]: http://stackoverflow.com/questions/3577922/how-to-link-a-gas-assembly-program-that-uses-the-c-standard-library-with-ld-with
[7]: http://stackoverflow.com/questions/18091463/why-does-an-assembly-program-only-work-when-linked-with-crt1-o-crti-o-and-crtn-o
[8]: http://wiki.osdev.org/Creating_a_C_Library#crtbegin.o.2C_crtend.o.2C_crti.o.2C_and_crtn.o
[9]: http://stackoverflow.com/questions/17898989/what-is-global-start-in-assembly-language
[10]: http://stackoverflow.com/questions/17882936/global-main-in-assembly
[11]: https://bytes.com/topic/c/answers/798972-how-change-entry-point-main-c-langauge
[12]: https://github.com/cjsimon/CSUS/blob/master/CSC35/lab4/guess/makeasm
[13]: https://github.com/cjsimon/CSUS/blob/master/CSC35/lab4/guess/makefile