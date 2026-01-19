package com.app.tester;

import java.util.*;

import com.app.utils.Library;

public class MainApp {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1.Add Book\n2.View Books\n3.Issue Book\n4.Return Book\n5.Search Book\n6.Delete Book\n7.Exit");
                System.out.print("Enter Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();
                        lib.addBook(name, author);
                        break;

                    case 2:
                        lib.viewBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        lib.issueBook(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        lib.returnBook(sc.nextInt());
                        break;

                    case 5:
                        sc.nextLine();
                        System.out.print("Enter Book Name: ");
                        lib.searchBook(sc.nextLine());
                        break;

                    case 6:
                        System.out.print("Enter Book ID: ");
                        lib.deleteBook(sc.nextInt());
                        break;

                    case 7:
                        System.out.println("Thank You!");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct data.");
                sc.nextLine(); // clear wrong input
            } catch (Exception e) {
                System.out.println("Something went wrong. Try again.");
            }
        }
    }
}
