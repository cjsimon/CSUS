/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 *
 * Package Name:	bank
 * File Name: 		Bank.java
 * Description:		The bank interface class that manages a collection
 * 					of Accounts
 *
 * Date Created: 	12/11/2014
 * Last Modified:	12/11/2014
 */

package bank;

import java.util.Arrays;

public class Bank {
	//Bank properties name and annual rate
	private String name = "Bank";
	private double aRate = 0;
	//The Accounts
	private Account[] accounts = new Account[0];

	/* Construct the Bank with the given specifications */
	public Bank() {}
	public Bank(String name) {
		setName(name);
	}
	public Bank(double rate) {
		try {
			setRate(rate);
		} catch(Exception e) {}
	}
	public Bank(String name, double rate) {
		setName(name);
		try {
			setRate(rate);
		} catch(Exception e) {}
	}

	/* Add an Account to the array */
	public void addAccount(int id, double balance, double rate) throws Exception {
		if(exists(id)) throw new Exception("Account with specified id already exists");
		int length = accounts.length;
		//Resize the array to fit the new Account
		accounts = Arrays.copyOf(accounts, length+1);
		Account a = new Account(id, balance, rate, aRate);
		accounts[length] = a;
	}

	/* Delete Accounts from the array */
	public void deleteAccount(Integer... id) throws Exception {
		int length = accounts.length;
		//For each id that is to be deleted
		for(int i : id) {
			//The index of the Account to delete
			int deleteIndex = getIndex(id[i]);
			//For each element after the element to delete
			for(int e = deleteIndex + 1; e < length; e++) {
				//Shift each element down one
				accounts[e-1] = accounts[e];
			}
			//Null the last element
			accounts[length] = null;
			//The accounts length is now one less
			length--;
		}
		//Resize the array and remove the extra entries
		Arrays.copyOf(accounts, length);
	}

	/* Withdraw money from an Account balance */
	public boolean withdraw(Account a, double amount) {
		double currentBalance = a.getBalance();
		if(amount < 0 || amount > currentBalance) {
			return false;
		}
		a.setBalance(currentBalance - amount);
		return true;
	}
	/* Deposit money from an Account balance */
	public boolean deposit(Account a, double amount) {
		double currentBalance = a.getBalance();
		if(amount < 0) {
			return false;
		}
		a.setBalance(currentBalance + amount);
		return true;
	}

	/* Format the array of Accounts as a string */
	public String toString() {
		//Append the contents of each Account to a string
		String s = "";
		for(Account a : accounts) {
			s += a;
		}
		return s;
	}

	/* Check if the Account exists */
	public boolean exists(int id) {
		//Return false if the array has no elements yet
		if(accounts == null) return false;
		//Check the id of each element
		for(Account a : accounts) {
			if(id == a.getId()) return true;
		}
		return false;
	}

	/* Accessors */
	//Bank Name
	public String getName() {
		return name;
	}
	//Annual Rate
	public double getRate() {
		return aRate;
	}
	//An Account in the array
	public Account getAccount(int id) throws Exception {
		int i = getIndex(id);
		return accounts[i];
	}
	//The index of an Account
	public int getIndex(int id) throws Exception {
		for(int i = 0; i < accounts.length; i++) {
			if(id == accounts[i].getId()) return i;
		}
		throw new Exception("Account does not exist");
	}
	//Length of the array
	public int getLength() {
		return accounts.length;
	}

	/* Mutators */
	//Bank Name
	public void setName(String name) {
		this.name = name;
	}
	//Annual Rate
	public void setRate(double aRate) throws Exception {
		if(aRate < 0) {
			throw new Exception("Annual rate must be greater than zero");
		}
		this.aRate = aRate;
	}
}