package com.app.utils;
import java.util.ArrayList;
import com.app.main.Account;

/**
 * Service class containing business logic
 */
public class BankService {

    private ArrayList<Account> accounts = new ArrayList<>();
    private int accountNumberCounter = 1001;
    private static final double MIN_BALANCE = 500.0;

    // Create new bank account
    public void createAccount(String accountHolderName, double initialBalance) {

        if (initialBalance < MIN_BALANCE) {
            System.out.println("Minimum balance must be " + MIN_BALANCE);
            return;
        }

        Account account = new Account(accountNumberCounter++, accountHolderName, initialBalance);

        accounts.add(account);
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + account.getAccountNumber());
    }

    // View all accounts
    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("AccNo\tName\tBalance");
        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }

    // Find account by account number
    private Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Deposit money
    public void depositAmount(int accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);

        if (account != null && amount > 0) {
            account.depositAmount(amount);
            System.out.println("Deposit successful.");
            System.out.println("Updated Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid account number or amount.");
        }
    }

    // Withdraw money
    public void withdrawAmount(int accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);

        if (account != null && amount > 0) {
            if (account.withdrawAmount(amount)) {
                System.out.println("Withdrawal successful.");
                System.out.println("Updated Balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid account number or amount.");
        }
    }

    // Check balance
    public void getAccountBalance(int accountNumber) {
        Account account = findAccountByNumber(accountNumber);

        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
