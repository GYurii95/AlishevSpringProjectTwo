package ru.gyurii.springcourse.dao;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Book;
import ru.gyurii.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Books", new BookMapper());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Books WHERE book_id=?",
                new Object[]{id}, new BookMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Books(title, author, public_year) VALUES (?, ?, ?)",
                book.getTitle(),
                book.getAuthor(),
                book.getPublicYear());
    }

    public void update(int id, Book updateBook){
        jdbcTemplate.update("UPDATE Books SET title=?, author=?, public_year=? WHERE book_id=?",
                updateBook.getTitle(),
                updateBook.getAuthor(),
                updateBook.getPublicYear(),
                id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Books WHERE book_id=?", id);
    }

    public void setPerson(int book_id, int people_id){
        jdbcTemplate.update("UPDATE Books SET people_id=? WHERE book_id=?",
                people_id, book_id);
    }

    public void freeBook(int book_id){
        jdbcTemplate.update("UPDATE Books SET people_id = null WHERE book_id=?",
                book_id);
    }

    public Optional<Person> getBookOwner(int id){
        return jdbcTemplate.query("select Books.people_id, name, birthday from books join people on people.people_id = Books.people_id" +
                        " where book_id=?", new Object[]{id}, new PersonMapper()).stream().findAny();
    }

}*/
