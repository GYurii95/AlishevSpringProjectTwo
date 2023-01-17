package ru.gyurii.springcourse.models;

public class Book {

    private int id;
    private String title;
    private String author;
    private int manufacturingYear;

    public Book(int id, String title, String author, int manufacturingYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.manufacturingYear = manufacturingYear;
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

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
}
