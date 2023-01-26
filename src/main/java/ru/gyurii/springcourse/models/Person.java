package ru.gyurii.springcourse.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+$")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Person(int id, String name,Date date) {
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

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        String birth = format.format(birthday);
        return name + ", " + birth;
    }
}
