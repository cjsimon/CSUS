// This program prompts the user to enter various student scores
// and outputs the student's grade in the course.

import java.util.*;  // for Scanner

public class GradesShell {
	public static final int MAX_EXAM_SCORE = 100;
	
	public static void main(String[] args) {
		printWelcomeMessage();
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Homework:");
		double hw = getWeightedHomeworkScore(console);
		
		System.out.println("Midterm exam:");
		double midterm = getWeightedExamScore(console);
		
		System.out.println("Final exam:");
		doFinalExam(console, hw, midterm);
	}
	
	// A welcome message to start the program.
	public static void printWelcomeMessage() 
	{
	}
		
	// Asks about student's homeworks and returns weighted HW score.
	public static double getWeightedHomeworkScore(Scanner console)
	{
		return 0;
	}

	// Asks for the weight of something and returns the answer.
	public static int getWeight(Scanner console) {
	   return 0;
	}
	
	// Asks about student's exam and returns weighted score.
	// This method is called by both the midterm and final exams.
	public static double getWeightedExamScore(Scanner console) {
		 
		return 0;
	}
	
	// Asks the questions about the final exam and prints the overall grade.
	public static void doFinalExam(Scanner console, double hw, double exam) { 
			 
	}
	
	// Returns the given double value rounded to the nearest hundredth.
	public static double round2(double number) {
		return 0;
	}
}
