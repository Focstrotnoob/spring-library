package ru.ilinykh.springcourse.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int bookId;

    @NotEmpty(message = "Title should no be empty")
    @Size(min = 2, max = 30, message = "Title should be between 2 and 30 character")
    private String title;

    @NotEmpty(message = "Author should no be empty")
    @Size(min = 2, max = 30, message = "Author should be between 2 and 30 character")
    private String author;

    @Min(value = 1500, message = "The year of production must be more than 1900")
    private int yearOfProduction;

    public Book() {
    }

    public Book(String title, String author, int yearOfProduction) {
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
