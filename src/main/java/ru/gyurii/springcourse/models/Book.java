package ru.gyurii.springcourse.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int id;
    @NotEmpty(message = "Заголовок книги не должен быть пустым")
    private String title;
    @NotEmpty(message = "Введине ФИО автора")
    private String author;

    @Min(value = 0, message = "Введите год издания")
    private int publicationYear;

    private int people_id;

    public Book(int id, String title, String author, int publicationYear, int people_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.people_id = people_id;
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

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }
}
