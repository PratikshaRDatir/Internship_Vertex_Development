package com.app.main;

public class Book {
	public int id;
    public String name;
    public String author;
    public boolean isIssued;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isIssued = false;
    }

    public void display() {
        System.out.println(id + "\t" + name + "\t" + author + "\t" + (isIssued ? "Issued" : "Available"));
    }
}
