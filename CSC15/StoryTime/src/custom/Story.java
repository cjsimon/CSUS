/* 
 * Author Name:     Christopher Simon
 * Class Section:   CSc 15: T/Th 8:00
 * 
 * Package Name:    custom
 * File Name:       Story.java
 * Description:     A Story engine that creates custom Story instances that output parametrized stories through user input
 * 
 * Date Created:    10/8/2014
 * Last Modified:   10/9/2014
 */

//Define this file as a part of the custom made package
package custom;

//Import the MessageFormatter abd Scanner classes
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;

/* Contains all methods associated with Story manipulation, such as prompting for questions and displaying the text of the story */
public class Story {
    /* Constants */
    //Define types QUESTION and STORY as additions to the Story
    public static final int QUESTION = 0;
    public static final int STORY    = 1;
    //Define DEBUG as the status of debugging for the class
    public static boolean   DEBUG    = false;

    /* Define the properties of the story */
    //The total number of questions to be asked
    int totalQuestions;
    //The list of questions to be asked
    private String[] questions;
    //The internal pointers for the current question and line
    int questionsPointer, linesPointer = 0;
    //The answers to the questions
    private String[] answers;
    //The delimiters for the answers
    private String[] delimiters;
    //The total number of lines in the story
    int totalLines;
    //The lines of the story
    private String[] story;
    //The title of the story
    private String title = "";
    //The input scanner
    Scanner input;
    
    /* The class constructor that creates a titled story with the given number of totalQuestions and totalLines of the story */
    //No title
    public Story(int totalQuestions, int totalLines) {
        //Construct the story with an empty title
        this("", totalQuestions, totalLines);
    }
    //With the title
    public Story(String title, int totalQuestions, int totalLines) {
        //Update the title of the story
        this.title = title;
        //Update the total question and line counts
        this.totalQuestions = totalQuestions;
        this.totalLines = totalLines;
        //Init the question, delimiter, answer and story arrays with the given number of respective totals as their sizes
        questions   = new String[this.totalQuestions];
        delimiters  = new String[this.totalQuestions];
        answers     = new String[this.totalQuestions];
        story       = new String[this.totalLines];
    }
    
    /* Add a question to the array of questions or a line to the story, depending on what the user has specified */
    //Add Story Shorthand
    //Since a delimiter is not specified the content must be for the story
    public void add(String content) {
        this.add(STORY, content, null);
    }
    //Add Question Shorthand
    //Since a delimiter is specified the content must be for the question
    public void add(String content, String delimiter) {
        this.add(QUESTION, content, delimiter);
    }
    //Specify if adding a question or line through the type. In the case of type STORY, a delimiter is not required,
    //so use null for it's delimiter 
    public void add(int type, String content, String delimiter) throws ArrayIndexOutOfBoundsException {
        //Debug:
        if(DEBUG) {
            //Print the number of elements in the array
            System.out.println("Line: " + linesPointer + ", " + (totalLines-1));
            System.out.println("Question: " + questionsPointer + ", " + (totalQuestions-1));
        }
        //Has the user specified to add a question or a line to the story?
        switch(type) {
            //Add a question
            case 0: {
                //If either the questions pointer or the story pointer exceeds the totalQuestions or totalLines respectivly specified
                //In other words, if there are more questions than question slots or more lines than line slots
                if(questionsPointer > totalQuestions-1) {
                    throw new ArrayIndexOutOfBoundsException("Number of elements exceeds the total amount of questions specified!");
                }
                //Slots are still available for more questions
                //Write the question to the current slot
                questions[questionsPointer] = content;
                //Also write the current delimiter to the current slot matching that of the question
                delimiters[questionsPointer] = delimiter;
                //Refer to the next open slot in the array for the next iteration
                questionsPointer++;
                break;
            }
            //Add a line to the story
            case 1: {
                //If line pointer exceeds totalLines
                if(linesPointer > totalLines-1) {
                    String lineError = "Number of elements exceeds the total amount of lines specified!";
                    //Throw an ArrayIndexOutOfBounds error
                    throw new ArrayIndexOutOfBoundsException(lineError);
                }
                //Slots are still available for more lines
                //Write the question to the current slot
                story[linesPointer] = content;
                //Refer to the next open slot in the array for the next iteration
                linesPointer++;
                break;
            }
        }
    }
    
    /* Start the story: Prompt for the answers to the question array and read the story n times if specified */
    //If no parameter is given start the story once
    public void start(Scanner input) {
        this.start(1, input);
    }
    //Otherwise start the story n times
    public void start(int n, Scanner input) {
        //Pass the scanner to this Story instance
        this.input = input;
        //Start the story n times
        for(int i = 0; i < n; i++) {
            //Prompt for answers to the questions of the story if any question exist
            if(totalQuestions > 0){
                prompt();
            }
            //Read the story replacing the delimiters with the inputs
            read();
        }
    }
    
    /* Prompt for the inputs to the list of questions in the story */
    private void prompt() {
        //The currentQuestion that is to be modified with the currently filled answers in place
        //The answer to the current input
        String currentQuestion, answer = "";
        int intAnswer = 0;
        double doubleAnswer = 0d;
        //For each question, q, in the array of questions
        for(int i = 0; i < totalQuestions; i++) {
            //Set the currentQuestion to the current question that is being displayed
            currentQuestion = questions[i];
            //For each answer/input in the array populated up to this point
            for(int a = 0; a < i; a++) {
                //Modify the currentQuestion, replacing each delimiters for each answer up to this point
                currentQuestion = currentQuestion.replace(delimiters[a], answers[a]);
            }
            //Print the currentQuestion
            System.out.print(currentQuestion);
            //Depending on the input type:
            //Retrieve the input answer
            //And Store the answer in the answer array for use when reading the story
            //Cast the type so that it can be manipulated through the handler
            if(input.hasNextLine()) {
                //Cast the handledInput object as a string
                answer = (String) handleInput(input.nextLine(), i);
                //Add the string answer to the answer array
                answers[i] = answer;
            } else if(input.hasNextInt()) {
                //Cast the handledInput object as an int
                intAnswer = (int) handleInput(input.nextInt(), i);
                //Add the intAnswer to the answer array
                //Convert from an int to a string
                answers[i] = "" + intAnswer;
            } else if(input.hasNextDouble()) {
                //Cast the handledInput object as a double
                //Handle each input based on the user specified conditions
                doubleAnswer = (double) handleInput(input.nextDouble(), i);
                //Add the doubleAnswer to the answer array
                //Convert from a double to a string
                answers[i] = "" + doubleAnswer;
            }
        }
    }
    
    /* Handle and manipulate answers through a class extention that overrides this function */
    //The extended class will pass the data back to this super class for addition to the story
    public Object handleInput(Object e, int answerInputs) {
        //Return the modified answer back to the story
        return e;
    }
    
    /* Display the story with the user's answers */
    private void read() {
        //Print the title of the story
        System.out.println();
        System.out.println(title);
        //For each line of the story
        for(int l = 0; l < totalLines; l++) {
            //For each delimiter
            for(int d = 0; d < totalQuestions; d++) {
                //Replace the user defined delimiters with the standard delimiter for MessageFormat, {#}
                story[l] = story[l].replace(delimiters[d], "{" + d + "}");
            }
            //The properly formatted currentLine with the answers
            String currentLine = MessageFormat.format(story[l], (Object[])answers);
            //Print the currentLine
            System.out.println(currentLine);
        }
        //End of story
        System.out.println();
        
        //DEBUG: Print the array contents after finishing the story
        if(DEBUG) {
            //Print the full content of the arrays
            System.out.println("Questions:  " + Arrays.toString(questions));
            System.out.println("Delimiters: " + Arrays.toString(delimiters));
            System.out.println("Answers:    " + Arrays.toString(answers));
            System.out.println("Story:      " + Arrays.toString(story));
        }
    }
}