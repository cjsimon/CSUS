/*
 * Author Name:		Christopher Simon
 * Class Section:	CSc 15: T/Th 8:00
 * Instructor:		Professor Faroughi
 *
 * Package Name:	bank
 * File Name: 		Account.java
 * Description:		A class that generates new Accounts for use in an
 * 					accounting system.
 *
 * Date Created: 	12/4/2014
 * Last Modified:	12/11/2014
 */

package bank;

import java.util.Date;

public class Account {
    //The account properties
    private int	   id      = 0;
    private double balance = 0;
    private double rate	   = 0;
    private double aRate   = 0;
    private Date   date	   = new Date();

    /* Construct the account and init its corresponding properties */
    public Account() {
        //Implemented because of requirement of the assignment.
        //Since each account should have a unique id,
        //a default id and balance constructor should not exist
    }
    public Account(int id, double balance, double rate, double aRate) {
        //Set the specified id and balance
        setId(id);
        setBalance(balance);
        setRate(rate);
        setAnnualRate(aRate);
    }

    /* Mutator methods */
    protected boolean setId(int id) {
        if(id < 0) {
            return false;
        }
        this.id = id;
        return true;
    }
    protected boolean setBalance(double balance) {
        if(balance < 0) {
            return false;
        }
        this.balance = balance;
        return true;
    }
    protected boolean setRate(double rate) {
        if(rate < 0) {
            return false;
        }
        this.rate = rate;
        return true;
    }
    protected boolean setAnnualRate(double aRate) {
        if(aRate < 0) {
            return false;
        }
        this.aRate = aRate;
        return true;
    }

    /* Accessor Methods */
    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public double getRate() {
        return rate;
    }
    public double getAnnualRate() {
        return aRate;
    }
    public Date getDate() {
        return date;
    }

    /* Compare two accounts */
    public boolean equals(Account a) {
        //Accounts are considered equal if their ids are the same
        return (this.id == a.id);
    }

    /* Format the Account info as a string */
    public String toString() {
        String s;
        s = (
            "Account " 		 	 + this.getId()
            + ":\nBalance: " 	 + this.getBalance()
            + "\nMonthly Rate: " + this.getRate()
            + "\nAnnual Rate: "	 + this.getAnnualRate()
            + "\nDate Created: " + this.getDate()
            + "\n"
        );
        return s;
    }
}