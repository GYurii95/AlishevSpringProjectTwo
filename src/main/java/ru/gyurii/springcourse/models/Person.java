package ru.gyurii.springcourse.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @Column(name = "people_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "ФИО не должно быть пустым")
    @Pattern(regexp = "^[А-Я][а-я]{2,25} [А-Я][а-я]{2,15} [А-Я][а-я]{2,20}$", message = "Пример ввода: Иванов Иван Иванович")
    private String name;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Введите дату рождения")
    @Past(message = "Некорректная дата рождения")
    private Date birthday;
    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.birthday = date;
    }

    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY");
        String birth = format.format(birthday);
        return name + ", " + birth + " гр.";
    }
}
