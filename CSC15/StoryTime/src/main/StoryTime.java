/* 
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	main
 * File Name: 		StoryTime.java
 * Description:		A program that creates a specific Story instance from the Story class for the user to interact with
 *
 * Date Created: 	10/8/2014
 * Last Modified:	10/9/2014
 */

//Define this file as a part of the main package
package main;

//Import the custom made Story class from package custom to create the story
//And the Scanner util class for input
import custom.Story;
import java.util.Scanner;

/* The main program that creates a specific Story instance with specified questions and parametrized text */
public class StoryTime {
    /* Define the main method that will create our Story instance */
    public static void main(String[] args) {
    	//Is the Story class in debug mode?
    	Story.DEBUG = false;
    	
        /********************
         * The Story Content
         ********************/
    	//The title of the story
    	String title = "-------The Free Food Day-------";
        //The total number of questions and lines of text in the story
        int totalQuestions = 10;
        int totalLines = 11;
        //The array of questions to add to the story
        String[] questions = new String[] {
            "Hello! What is your name? ",
            "Hey, *NAME*! Tell me, are you a man or a woman? ",
            "Oh your a *GENDER*! Well, how old are you, *NAME*? ",
            "Okay, but I still don't know you that well. Can you give me an ajective to describe yourself? ",
            "So your *ADJ*. Great! Now, how many people are in your family? ",
            "You have *FAMILY* family members. Alright, what are you doing right now? ",
            "Your *VERB*? That sounds like fun! What is your favorite food? ",
            "Yeah I like *FOOD* too! How much does *FOOD* cost nowadays anyways? ",
            "Wow, only $*PRICE*? What a bargain for *FOOD*! So tell me, *NAME*, what is your favorite website? ",
            "Oh your favorite place to visit is *URL*! That's a cool website! "
            + "\nLastly, what would you like your encrypted message to be? "
        };
        //The array of delimiter for each input
        String[] delimiters = new String[] {
        	"*NAME*"	,
            "*GENDER*"	,
            "*AGE*"		,
            "*ADJ*"		,
            "*FAMILY*"	,
            "*VERB*"	,
            "*FOOD*"	,
            "*PRICE*"	,
            "*URL*"		,
            "*MSG*"
        };
        //The lines of the story text with the delimiters of the inputs
        String[] story = new String[] {
        	"One day, after spending *FAMILY* hours *VERB*, a *GENDER* named *NAME* decided to go for a *ADJ* walk.",
        	"Suddenly, *NAME* noticed something fairly odd.",
        	"Everyone outside had *FOOD*!",
        	"Since *NAME* likes *FOOD*, *NAME* went looking for where he can get *FOOD*.",
        	"Finally, *NAME* noticed that one of the local shops were giving the food away for free!",
        	"This was surprising to *NAME*. After all, the usual price of *FOOD* is $*PRICE*!",
        	"Upon entering the shop, *NAME* noticed *AGE* *ADJ* people waiting in line.",
        	"Finally, *NAME* is first in line! *NAME* quickly asks, \"Can I have *FOOD*?\"",
        	"One of the employees bluntly asks, \"What's the secret password?\"",
        	"Happily, *NAME* yells out, \"*MSG*!\" *NAME* gets *FOOD* instantly.",
        	"To celebrate, *NAME* runs home and logs on to *URL*."
        };
        
        /*******************
         * The Story Object
         *******************/
        //Construct a new Story object with the specified number of questions
        Story myStory = new InterpretedStory(title, totalQuestions, totalLines);
        //Create the story questions for the user to answer
        for(int i = 0; i < totalQuestions; i++) {
            //Add each question to the story, with it's input type and delimiter
            myStory.add(questions[i], delimiters[i]);
        }
        //Create the story text
        for(int i = 0; i < totalLines; i++) {
            //Add each line of the story to the myStory object
            myStory.add(story[i]);
        }
        
        /******************
         * Start the story
         ******************/
        //Create a Scanner for use with the story
        Scanner input = new Scanner(System.in);
        //Repeat the process of prompting until it sucessfully goes through
        while(true) {
        	//Prompt for the number of repetitions of the story
            System.out.print("How many times would you like to run the story? ");
	        //Try to get the number of repetitions of the story
            try {
	        	//Set the startCount to the user specified input
	        	int startCount = input.nextInt();
	        	//Remove the extra carriage return still in the input stream
	        	input.nextLine();
	        	//Start the story startCount times
	        	myStory.start(startCount, input);
	        	//The story has sucessfully started
	        	//break the loop
	        	break;
	        } catch (Exception e) {
	        	//The user must print an int
	        	//Print the error to the user
	        	System.out.println("You need to enter a number!");
	        	//Clear the scanner using nextLine() so that the input can be reentered
	        	input.nextLine();
	        }
        }
    }
}

/***** OUTPUT START *****\
How many times would you like to run the story? I want to run the story three times
You need to enter a number!
How many times would you like to run the story? two
You need to enter a number!
How many times would you like to run the story? 2
Hello! What is your name? Chris
Hey, Chris! Tell me, are you a man or a woman? man
Oh your a man! Well, how old are you, Chris? 18
Okay, but I still don't know you that well. Can you give me an ajective to describe yourself? friendly
So your friendly. Great! Now, how many people are in your family? 5
You have 5 family members. Alright, what are you doing right now? programming
Your programming? That sounds like fun! What is your favorite food? ice cream
Yeah I like ice cream too! How much does ice cream cost nowadays anyways? 2.95
Wow, only $2.95? What a bargain for ice cream! So tell me, Chris, what is your favorite website? www.recesshour.com
Oh your favorite place to visit is recesshour! That's a cool website! 
Lastly, what would you like your encrypted message to be? tehbed ufru7n8khyg rcuaitd 2i4s8 kivnd rtthyeh ghfoduss4e6

-------The Free Food Day-------
One day, after spending 5 hours programming, a man named Chris decided to go for a friendly walk.
Suddenly, Chris noticed something fairly odd.
Everyone outside had ice cream!
Since Chris likes ice cream, Chris went looking for where he can get ice cream.
Finally, Chris noticed that one of the local shops were giving the food away for free!
This was surprising to Chris. After all, the usual price of ice cream is $2.95!
Upon entering the shop, Boss notices 18 friendly people waiting in line.
Finally, Chris is first in line! Chris quickly asks, "Can I have ice cream?"
One of the employees bluntly asks, "What's the secret password?"
Happily, Chris yells out, "the funky cat is in the house!" Chris gets ice cream instantly.
To celebrate, Chris runs home and logs on to recesshour.

Hello! What is your name? Boss
Hey, Boss! Tell me, are you a man or a woman? woman
Oh your a woman! Well, how old are you, Boss? 19
Okay, but I still don't know you that well. Can you give me an ajective to describe yourself? cool
So your cool. Great! Now, how many people are in your family? 7
You have 7 family members. Alright, what are you doing right now? having fun
Your having fun? That sounds like fun! What is your favorite food? chicken
Yeah I like chicken too! How much does chicken cost nowadays anyways? 8.99
Wow, only $8.99? What a bargain for chicken! So tell me, Boss, what is your favorite website? http://google.com
Oh your favorite place to visit is google! That's a cool website! 
Lastly, what would you like your encrypted message to be? Gqoedr yiisp jggrdeaaztc

-------The Free Food Day-------
One day, after spending 7 hours having fun, a woman named Boss decided to go for a cool walk.
Suddenly, Boss noticed something fairly odd.
Everyone outside had chicken!
Since Boss likes chicken, Boss went looking for where he can get chicken.
Finally, Boss noticed that one of the local shops were giving the food away for free!
This was surprising to Boss. After all, the usual price of chicken is $8.99!
Upon entering the shop, Boss notices 19 cool people waiting in line.
Finally, Boss is first in line! Boss quickly asks, "Can I have chicken?"
One of the employees bluntly asks, "What's the secret password?"
Happily, Boss yells out, "God is great!" Boss gets chicken instantly.
To celebrate, Boss runs home and logs on to google.
\***** OUTPUT END *****/