package ru.gyurii.springcourse.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty(message = "Заголовок книги не должен быть пустым")
    @Size(min = 2, max = 30, message = "Заголовок должен содержать от 2 до 30 символов")
    private String title;
    @NotEmpty(message = "Введине ФИО автора")
    @Size(min = 2, max = 50, message = "Имя автора должно содержать от 2 до 50 символов")
    private String author;

    @Min(value = 1500, message = "Введите год издания, не менее 1500 г.")
    private int publicYear;

    public Book(int id, String title, String author, int publicYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
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

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + publicYear + " года издания.";
    }
}
