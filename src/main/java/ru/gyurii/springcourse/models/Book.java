package ru.gyurii.springcourse.models;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    @NotEmpty(message = "Заголовок книги не должен быть пустым")
    @Size(min = 2, max = 30, message = "Заголовок должен содержать от 2 до 30 символов")
    private String title;
    @Column(name = "author")
    @NotEmpty(message = "Введине ФИО автора")
    @Size(min = 2, max = 50, message = "Имя автора должно содержать от 2 до 50 символов")
    private String author;

    @Column(name = "public_year")
    @Min(value = 1500, message = "Введите год издания, не менее 1500 г.")
    private int publicYear;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean overdue;

    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "people_id")
    private Person owner;

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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + publicYear + " года издания.";
    }
}
