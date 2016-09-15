// The name of the file on your computer is "ForLoop.java"
// This first line helps the computer to indentify what the name is
public class ForLoop {
    // The main method.
    // This is where the computer will start reading.
    public static void main(String[] args)
    {
        /*--------------------------------------++------------------------------------*/
        /*                                      ||            ____  _____   _____     */
        /* For each iteration of i,             ||           /     /    /  /    /     */
        /* starting from 1 and going up to 3... ||          /___  /    /  /____/      */
        /*                                      ||         /     /    /  / \          */
        /* Initialization: Declare a variable,  ||        /     /____/  /   \         */
        /* in this case, set i to start at 1    ||      __      _____   _____   _____ */
        /*                                      ||     / /     /    /  /    /  /    / */
        /* Condition: "So long as" i <= 3:      ||    / /     /    /  /    /  /___ /  */
        /* run the code on the inside of the    ||   / /___  /    /  /    /  /        */
        /* curly braces {      }                ||  /_____/ /____/  /____/  /         */
        /*                                      ||                                    */
        /* Update: After looping back to the    || Some Notes:                        */
        /* top of the for loop when reaching    || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* the closing }, update the value of   || - Notice that the update statement */
        /* the variable, in this case i, with   ||   *does not* have a ; at the end.  */
        /*                                      ||                                    */
        /* the expression found in update.      || - When the computer reaches the    */
        /* i++ is shorthand for i = i + 1; and  ||   end curly brace, }, it "jumps    */
        /* i-- is shorthand for i = i - 1;      ||   back up" to the beginning of the */
        /*                                      ||   for loop. Only then is the       */
        /*                                      ||   update part of the for loop run. */
        /*   Initialization  Condition  Update  ||                                    */
        /*   --------------  ---------  ------- || - If the computer reaches the for  */
        /*          |            |         |    ||   loop once again from another for */
        /*          |            |         |    ||   loop, the initalization is ran   */
        /*         \|/          \|/       \|/   ||   again and the variable is reset. */
        /*          V            V         V    ++------------------------------------*/
        for(    int i = 1;     i <= 3;    i++   ) {
            //                               .
            //                              /|\
            //                             / | \
            //                               |
            //                               |
            //                       No semicolon here!
            // Print out a +
            System.out.print("+");
        }
        
        // At this point, the for loop has ended
        // Print out a ! 
        System.out.print("!");
    }
}

        /***********OUTPUT***********\
Line 1: | +++!                       | <--- Output cursor is on this line
Line 2: |                            | 
Line 3: |                            | The output cursor helps us to identidy
Line 4: |                            | which line we are going to be writing
Line 5: |                            | output on next. It moves down one line
Line 6: |                            | after we see a println statement.
        \****************************/