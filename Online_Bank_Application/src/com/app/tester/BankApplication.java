package com.app.tester;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.app.utils.BankService;


/**
 * Main class to run Online Bank Application
 */
public class BankApplication {

    public static void main(String[] args) {

        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n===== Online Bank Application =====");
                System.out.println("1. Create Account");
                System.out.println("2. View All Accounts");
                System.out.println("3. Deposit Amount");
                System.out.println("4. Withdraw Amount");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Holder Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        double balance = scanner.nextDouble();
                        bankService.createAccount(name, balance);
                        break;

                    case 2:
                        bankService.viewAllAccounts();
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        int depAcc = scanner.nextInt();
                        System.out.print("Enter Amount to Deposit: ");
                        double depAmt = scanner.nextDouble();
                        bankService.depositAmount(depAcc, depAmt);
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        int witAcc = scanner.nextInt();
                        System.out.print("Enter Amount to Withdraw: ");
                        double witAmt = scanner.nextDouble();
                        bankService.withdrawAmount(witAcc, witAmt);
                        break;

                    case 5:
                        System.out.print("Enter Account Number: ");
                        bankService.getAccountBalance(scanner.nextInt());
                        break;

                    case 6:
                        System.out.println("Thank you for using Online Bank Application.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter correct values.");
                scanner.nextLine(); // clear buffer
            }
        }
    }
}
