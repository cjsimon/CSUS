/* Name:			Hour Glass Generator
 * Description:		An engine for creating HourGlass instances of specified height
 *
 * Written By:		Christopher Simon
 * Date Created:	9/23/2014
 * Last Modified:	9/24/2014
 */

/* The main program that draws an HourGlass with height H */
public class DrawHourGlass {
    //Define a constant, H, representing the height of the figure
    public static final int H = 7;

    /* Define the main method */
    //We use the static keyword as we only want to allow for one instance of the main method
    //A static method can be executed without an instance of it's class
    public static void main(String[] args) {
        //Create a new instance of an HourGlass object
        HourGlass myHourGlass;
        //Try to initialize the HourGlass. If the size is less than 0, a SizeException is thrown
        try {
            //Initialize the myHourGlass object with a specified size
            myHourGlass = new HourGlass(H);
            //Draw this instance of the HourGlass
            myHourGlass.draw();
        } catch(SizeException e) {
            //Notify the user what happened
            System.out.println(e);
        }
    }
}

/* The SizeException class that passes it's message to the parent exception class */
class SizeException extends Exception {
    //Pass the custom exception to the super class to be handled
    public SizeException(String e) {
        //Pass the error message to the parent class, Exception
        super(e);
    }
}

/* Contains all methods associated with all HourGlass manipulation, such as drawing */
class HourGlass {
    //Define the properties of the hourglass
    //The size of the figure
    public int size;

    /* The class constructors that run on initialization of a new instance */
    //No Parameters: Size not specified
    public HourGlass() {
        //No parameters are given so assume a size of zero
        size = 0;
    }
    //One Parameter: Size
    public HourGlass(int s) throws SizeException{
        //Throw an exception on a negative size
        if(s < 0) {
            throw new SizeException("Please specify a size greater than 0 for the hour glass");
        } else {
            //The size is valid
            //Set the size based on what is specified
            size = s;
        }
    }

    /* Draw the HourGlass of given size */
    public void draw() {
        //The HourGlass shape is defined by the following methods
        top();		//	|""""|
        middle();	//	 \::/
        vertical();	//	  ||
        bottom();	//	 /::\
        top();		//	|""""|
    }

    /* The methods that draw that components of the HourGlass */
    //They are private as we do not want them to be accessible by other classes
    //Generate the top of the HourGlass
    private void top() {
        //The header of the top row
        System.out.print("|");

        //For every row position on the current line representing "
        for(int r = 0; r < ((2*size) + 2); r++) {
            //Append " to the current line
            System.out.print("\"");
        }

        //Close the top row
        System.out.print("|");
        //Move the pointer to the next line
        System.out.println();
    }

    //Generate the middle of the HourGlass
    private void middle() {
        //For every line composed up of the middle part
        for(int line = 1; line <= size; line++) {
            //Append the desired number of spaces based on the current line number
            spaces(line);

            //The opening cap of the row
            System.out.print("\\");

            //For every row position on the current line representing :
            for(int r = 0; r < ((2*size) - (2 * (line-1))); r++) {
                //Append : to the current line
                System.out.print(":");
            }

            //Close the middle row
            System.out.print("/");
            //Move the pointer to the next line
            System.out.println();
        }
    }

    //Generate the vertical part of the HourGlass
    private void vertical() {
        //The number of vertical space is equal to the following expression
        int numbSpaces = (size + 1);
        //Append the spaces
        spaces(numbSpaces);

        //The vertical part of the HourGlass is always ||
        //For every row position of the current line representing |
        for(int r = 0; r < 2; r++) {
            //Append |
            System.out.print("|");
        }

        //Move the pointer to the next line
        System.out.println();
    }

    //Generate the bottom of the HourGlass
    private void bottom() {
        //For every line composed up of the bottom part
        for(int line = 1; line <= size; line++) {
            //The number of spaces is equal to the following expression
            int numbSpaces = (size - (line-1));
            //Append the desired number of spaces
            spaces(numbSpaces);

            //The opening cap of the row
            System.out.print("/");

            //For every row position on the current line representing :
            for(int r = 0; r < (2*line); r++) {
                //Append : to the current line
                System.out.print(":");
            }

            //Close the bottom row
            System.out.print("\\");
            //Move the pointer to the next line
            System.out.println();
        }
    }

    /* Append the desired number of spaces */
    private void spaces(int n) {
        //For row position in the current line
        for(int r = 0; r < n; r++) {
            //Append a space to the current line
            System.out.print(" ");
        }
    }
}