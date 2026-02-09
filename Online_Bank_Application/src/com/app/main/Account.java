package com.app.main;

public class Account {
	
	/**
	 * Model class representing a bank account
	 */

	    private int accountNumber;
	    private String accountHolderName;
	    private double balance;

	    public Account(int accountNumber, String accountHolderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = balance;
	    }

	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    public String getAccountHolderName() {
	        return accountHolderName;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    // Deposit amount into account
	    public void depositAmount(double amount) {
	        balance += amount;
	    }

	    // Withdraw amount from account
	    public boolean withdrawAmount(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	    // Display account details
	    public void displayAccountDetails() {
	        System.out.println(accountNumber + "\t" + accountHolderName + "\t" + balance);
	    }
	


}
