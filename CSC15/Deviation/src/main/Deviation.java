/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 * 
 * Package Name:	main
 * File Name: 		Deviation.java
 * Description:		A class that calculates the population deviations
 * 					of sets of numbers
 *
 * Date Created: 	11/21/2014
 * Last Modified:	11/21/2014
 */

package main;

import java.util.Arrays;

public class Deviation {
	//The dynamic array of numbers
	public double[] numbers = new double[0];
	//The length if the array
	private int length = 0;
	//The current property values
	public double average, variance, deviation;
	//Should the current value be used for average or variance
	public static final int CURRENT_VALUE = 0;
	//Or should a new value be calculated
	public static final int NEW_VALUE = 1;
	
	/* Add an element to the numbers array */
	public void add(double n) {
		/*
		 * Resize the array by making a copy of it and incramenting the size.
		 * While this is not ideal, it is the only way to create a dynamic array
		 * A dynamic ListArray can easily be incorporated in place of this method
		 * however, the homework specifications require an array.
		 */
		//The current length of the array
		length = numbers.length;
		numbers = Arrays.copyOf(numbers, length+1);
		//Populate the last element
		numbers[length] = n;
	}
	
	/* Return elements from the array based on index specifications */
	public String get() {
		String numberString = "";
		//For each number, n, in numbers
		for(double n : numbers) {
			//Append the current element to a string buffer
			numberString += n + ", ";
		}
		//Truncate the last two characters ", "
		numberString = numberString.substring(0, numberString.length() - 2);
		return numberString;
	}
	public double get(int i) {
		return numbers[i];
	}
	
	/* Clear all values in the array */
	public void clear() {
		//Reassign the array to an empty list
		numbers = new double[0];
	}
	
	/* Get the average of the numbers */
	public double getAverage() {
		double average = 0, sum = 0;
		
		//For each element in numbers
		for(double n : numbers) {
			sum += n;
		}
		average = sum/(length+1);
		
		//Update and return the current average
		this.average = average;
		return average;
	}
	
	/* Get the variance using either an existing or new average */
	public double getVariance() {
		return getVariance(CURRENT_VALUE);
	}
	public double getVariance(int status) {
		double variance, average = 0, sum = 0;
		
		//Get the status request
		if(status == NEW_VALUE) {
			//Recalculate the average and update it
			average = getAverage();
		} else if(status == CURRENT_VALUE) {
			//Use the predetermined average
			average = this.average;
		}
		
		//For each number
		for(double n : numbers) {
			sum += Math.pow((n-average), 2);
		}
		variance = sum/(length+1);
		
		//Return and update the variance
		this.variance = variance;
		return variance;
	}
	
	/* Get the variance using either an existing or new average */
	public double getDeviation() {
		return getDeviation(CURRENT_VALUE);
	}
	public double getDeviation(int status) {
		double variance = 0;
		
		//Get the status request
		if(status == NEW_VALUE) {
			//Recalculate the variance and update it
			variance = getVariance(NEW_VALUE);
		} else if(status == CURRENT_VALUE) {
			//Use the predetermined average
			variance = this.variance;
		}
		
		//Return and update the deviation
		this.deviation = Math.sqrt(variance);
		return deviation;
	}
}