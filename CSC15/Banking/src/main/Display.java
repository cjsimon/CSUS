/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 *
 * Package Name:	main
 * File Name: 		Display.java
 * Description:		The main class that acts as a Bank interface
 *
 * Date Created: 	12/4/2014
 * Last Modified:	12/11/21/2014
 */

package main;

import bank.Account;
import bank.Bank;
import bank.Prompt;

import java.util.Scanner;

public class Display {
	//The Input Scanner
	public static final Scanner input = new Scanner(System.in);
	//The Bank, b
	public static String name = "Cheap Bank";
	public static double aRate = 0.5;
	public static int totalAccounts = 5;
	public static Bank b = new Bank(name, aRate);
	//The input prompt, p
	public static Prompt p = new Prompt(input, b);

	/* The main method that prompts for input and displays accounts */
	public static void main(String[] args) throws Exception {
		//Populate n Accounts from an input stream
		p.setRate();
		p.populate(totalAccounts);

		System.out.println(
			"----------------------"
			+ "\nWelcome to " + name + "!"
			+ "\n----------------------"
		);
		//Run the program so long as the user specifies so
		do {
			//Get the desired desired account
			Account a = getAccount();
			System.out.println("\n" + a);
			//Access the current account, a
			access(a);
		} while(runAgain());
		//Close the scanner input
		input.close();
		System.out.println("Thank you for using Cheap Bank!");
	}

	/* Prompt for account manipulation */
	public static Account getAccount() {
		System.out.print("What is your Account ID? ");
		try {
			int id = Integer.parseInt(input.nextLine());
			Account currentAccount = b.getAccount(id);
			return currentAccount;
		} catch(NumberFormatException e) {
			System.out.println("Please enter a valid ID!");
			return getAccount();
		} catch(Exception e) {
			System.out.println("That account doesn't exist!");
			return getAccount();
		}
	}

	public static void access(Account a) {
		//The possible actions
		String action1 = "Withdraw";
		String action2 = "Deposit";
		System.out.print(
			"Would you like to "
			+ action1 + " or " + action2 + "? "
		);
		//Interpret the user input
		String action = input.nextLine();
		if(action.equalsIgnoreCase(action1)) {
			double amount = getAmount(action);
			if(b.withdraw(a, amount)) {
				System.out.println(
					amount + " was withdrawn from your account."
					+ "\nYou now have " + a.getBalance() + " in your account."
				);
			} else {
				System.out.println("Invalid Amount!");
				access(a);
			}
		} else if(action.equalsIgnoreCase(action2)) {
			double amount = getAmount(action);
			if(b.deposit(a, amount)) {
				System.out.println(
					amount + " was deposited into your account."
					+ "\nYou now have " + a.getBalance() + " in your account."
				);
			} else {
				System.out.println("Invalid Amount!");
				access(a);
			}
		} else {
			//Error
			System.out.println(
				"Please enter: \"" + action1 + "\" or \"" + action2 + "\""
			);
			access(a);
		}
	}

	public static double getAmount(String a) {
		System.out.print("How much money would you like to " + a + "? ");
		double amount = 0;
		try {
			amount = Double.parseDouble(input.nextLine());
		} catch (Exception e) {
			System.out.println("Please enter a valid amount");
			getAmount(a);
		}
		return amount;
	}

	/* Prompt the user for another run and return the response */
	public static boolean runAgain() {
		//Prompt for and store the input response
		System.out.print("Yes/No: Would you like to access another account? ");
		String response = input.nextLine();
		//Interpret the response else display an error and recall the prompt
		if(response.equalsIgnoreCase("yes")) {
			return true;
		} else if(response.equalsIgnoreCase("no")) {
			return false;
		} else {
			//Run the prompt recursively until an ethical answer is given
			System.out.println("Please enter \"Yes\" or \"No\"!");
			//Return the recursive method result the the original request
			return runAgain();
		}
	}
}

/* START OF OUTPUT *\
What is the annual rate? 15
Please enter the unique ID, balance and monthly rate of each account
Account 1 ID: 1
Account 1 Balance: 100
Account 1 Monthly Rate: 0.1
Account 2 ID: 2
Account 2 Balance: 200
Account 2 Monthly Rate: 0.2
Account 3 ID: 1
That ID already exists!
Account 3 ID: Fine be that way!
Please enter an ID!
Account 3 ID: 3
Account 3 Balance: 300
Account 3 Monthly Rate: 0.33
Account 4 ID: 4
Account 4 Balance: 400
Account 4 Monthly Rate: 0.4
Account 5 ID: 5
Account 5 Balance: 500
Account 5 Monthly Rate: 0.5

----------------------
Welcome to Cheap Bank!
----------------------
What is your Account ID? Cheap Bank? What is this a joke?
Please enter a valid ID!
What is your Account ID? 432086798
That account doesn't exist!
What is your Account ID? 3

Account 3:
Balance: 300.0
Monthly Rate: 0.33
Annual Rate: 15.0
Date Created: Fri Dec 12 01:45:50 PST 2014

Would you like to Withdraw or Deposit? I don't know!
Please enter: "Withdraw" or "Deposit"
Would you like to Withdraw or Deposit? withdraw
How much money would you like to withdraw? 100000
Invalid Amount!
Would you like to Withdraw or Deposit? withdraw
How much money would you like to withdraw? 270
270.0 was withdrawn from your account.
You now have 30.0 in your account.
Yes/No: Would you like to access another account? yes
What is your Account ID? 3

Account 3:
Balance: 30.0
Monthly Rate: 0.33
Annual Rate: 15.0
Date Created: Fri Dec 12 01:45:50 PST 2014

Would you like to Withdraw or Deposit? deposit
How much money would you like to deposit? -235
Invalid Amount!
Would you like to Withdraw or Deposit? deposit
How much money would you like to deposit? 1000
1000.0 was deposited from your account.
You now have 1030.0 in your account.
Yes/No: Would you like to access another account? no
Thank you for using Cheap Bank!
\* END OF OUTPUT */
