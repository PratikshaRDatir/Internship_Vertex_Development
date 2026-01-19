package com.app.utils;

import java.util.*;

import com.app.main.Book;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    private int bookIdCounter = 1;

    public void addBook(String name, String author) {
        Book b = new Book(bookIdCounter++, name, author);
        books.add(b);
        System.out.println("Book Added Successfully!");
        System.out.println("Generated Book ID: " + b.id);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("ID\tName\tAuthor\tStatus");
        for (Book b : books) {
            b.display();
        }
    }

    public void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void searchBook(String name) {
        for (Book b : books) {
            if (b.name.equalsIgnoreCase(name)) {
                b.display();
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    public void deleteBook(int id) {
        boolean removed = books.removeIf(b -> b.id == id);
        if (removed)
            System.out.println("Book Deleted Successfully.");
        else
            System.out.println("Book ID not found.");
    }
}
