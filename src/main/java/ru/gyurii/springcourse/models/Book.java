package ru.gyurii.springcourse.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int id;
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotEmpty(message = "Author should not be empty")
    private String author;

    @Min(value = 0, message = "Publication year should not be empty")
    private int publicationYear;

    public Book(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
