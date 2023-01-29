package ru.gyurii.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.gyurii.springcourse.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublicationYear(rs.getInt("publicationYear"));
        book.setPeople_id(rs.getInt("people_id"));
        return book;
    }
}
