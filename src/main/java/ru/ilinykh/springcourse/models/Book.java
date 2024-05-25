package ru.ilinykh.springcourse.models;


public class Book {
    private int bookId;
    private String title;
    private String author;
    private int yearOfProduction;

    public Book() {
    }

    public Book(int id, String title, String author, int yearOfProduction) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
