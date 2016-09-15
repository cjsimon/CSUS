/* 
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * 
 * Package Name:	main
 * File Name: 		InterpretedStory.java
 * Description:		A program that extends the Story class so that induvidual answers can be processed
 *
 * Date Created: 	10/9/2014
 * Last Modified:	10/9/2014
 */

//Include this class extension in our main package
package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Import the class that we wish to extend
import custom.Story;

/* The extended Story class used to customize how inputs are handled answer by answer */
public class InterpretedStory extends Story {
	/* Pass the original constructors parameters to the super class */
	public InterpretedStory(int totalQuestions, int totalLines) {
		super(totalQuestions, totalLines);
	}
	public InterpretedStory(String title, int totalQuestions, int totalLines) {
		super(title, totalQuestions, totalLines);
	}

	/* Override the handleInput function so that we can manipulate input answers from our story */
	//The answerNumber represents the conditions that the input should be manipulated for
	@Override
	public Object handleInput(Object e, int answerNumber) {
		switch(answerNumber) {
			//The URL
			case 8: {
				//Parse the input for a domain
				//Cast the object as a string so that it inherits the String class
				e = parseDomain((String) e);
				break;
			}
			//The encoded message
			case 9: {
				//Parse the input for a message
                //Cast String type
				e = parseMessage((String) e);
				break;
			}
		}
		//Return the modified answer back to the story
		return e;
	}
	
	/* Parse the input string for a domain */
	private String parseDomain(String s) {
		//Remove anything that is not the domain
		//Use the following regular expression to get the domain
		Pattern regex = Pattern.compile("([a-zA-Z0-9]*)[\\.]((com)|(net)|(org)|(edu)|(gov))");
		//The domain will be the first element in the array
		Matcher m = regex.matcher(s);
		//If a match exists
		if(m.find()) {
			//Set the string equal to the match
			s = m.group(1);
		}
		//Return s whether modified or not
		return s;
	}
	
	/* Parse the input string for a message */
	private String parseMessage(String s) {
		//Use a regular expression to get every other character
		String pattern = "(.).?";
		return s.replaceAll(pattern, "$1");
	}
}
