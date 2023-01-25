package ru.gyurii.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private static int BOOK_COUNT;
    private List<Book> books;

    {
        books = new ArrayList<>();
        books.add(new Book(++BOOK_COUNT, "book1", "author1", 1990));
        books.add(new Book(++BOOK_COUNT, "book2", "author2", 2000));
        books.add(new Book(++BOOK_COUNT, "book3", "author3", 2010));
        books.add(new Book(++BOOK_COUNT, "book4", "author4", 2020));
    }

    public List<Book> index() {
        return books;
    }

    public Book show(int id) {
        return books.stream()
                .filter(books-> books.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Book book) {
        book.setId(++BOOK_COUNT);
        books.add(book);
    }

    public void update(int id, Book updateBook){
        Book bookToBeUpdate = show(id);

        bookToBeUpdate.setTitle(updateBook.getTitle());
        bookToBeUpdate.setAuthor(updateBook.getAuthor());
        bookToBeUpdate.setPublicationYear(updateBook.getPublicationYear());
    }
}
