/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 *
 * Package Name:	bank
 * File Name: 		Prompt.java
 * Description:		The bank prompt class that populates a given
 * 					bank from an input stream
 *
 * Date Created: 	12/11/2014
 * Last Modified:	12/11/2014
 */
package bank;

import java.util.Scanner;

public class Prompt {
	//The increment count
	private int i;
	//The scanner
	private Scanner input;
	private Bank b;

	/* Constructor */
	public Prompt(Scanner input, Bank b) {
		this.input = input;
		this.b = b;
	}

	/* Set the annual rate */
	public void setRate() {
		System.out.print("What is the annual rate? ");
		try {
			double aRate = Double.parseDouble(input.nextLine());
			b.setRate(aRate);
		} catch(Exception e) {
			System.out.println("Please enter a valid annual rate!");
			setRate();
		}
	}

	/* Populate the specified Bank, b, with n many Accounts */
	public void populate(int n) {
		System.out.println(
			"Please enter the unique ID, balance"
			+ " and monthly rate of each account"
		);
		//For each account
		for(i = 0; i < n; i++) {
			//Prompt for the id, balance and monthly rate
			int id 			= id();
			double balance 	= balance();
			double rate		= rate();
			try {
				b.addAccount(id, balance, rate);
			} catch(Exception e) {}
		}
	}

	/* Prompt for an id */
	public int id() {
		System.out.print("Account " + (i+1) + " ID: ");
		try {
			int id = Integer.parseInt(input.nextLine());
			//Check if the id has already been assigned
			if(b.exists(id)) {
				System.out.println("That ID already exists!");
				return id();
			}
			return id;
		} catch(Exception e) {
			System.out.println("Please enter an ID!");
			return id();
		}
	}

	/* Prompt for a balance */
	public double balance() {
		System.out.print("Account " + (i+1) + " Balance: ");
		try {
			return Double.parseDouble(input.nextLine());
		} catch(Exception e) {
			System.out.println("Please enter a valid balance!");
			return balance();
		}
	}

	/* Prompt for a rate */
	public double rate() {
		System.out.print("Account " + (i+1) + " Monthly Rate: ");
		try {
			return Double.parseDouble(input.nextLine());
		} catch(Exception e) {
			System.out.println("Please enter a valid balance!");
			return rate();
		}
	}
}