package ru.gyurii.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gyurii.springcourse.models.Book;
import ru.gyurii.springcourse.models.Person;
import ru.gyurii.springcourse.repositories.BooksRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Book> findAll(boolean sortByYear){
        if (sortByYear)
            return booksRepository.findAll(Sort.by("publicYear"));
        else return booksRepository.findAll();
    }

    public List<Book> findWithPaginationAndSort(int page, int booksPerPage, boolean sortByYear){
        if (sortByYear)
            return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("publicYear"))).getContent();
        else
            return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
    }

    public Book findById(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    public Person getBookOwner(int id){
        return findById(id).getOwner();
    }
    @Transactional
    public void setBookOwner(int id, Person owner){
        Book book = findById(id);
        book.setOwner(owner);
        book.setTakenAt(new Date());
    }

    @Transactional
    public void deleteBookOwner(int id){
        Book book = findById(id);
        book.setOwner(null);
    }

    @Transactional
    public void save(Book book){
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updateBook){
        updateBook.setId(id);
        booksRepository.save(updateBook);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    public List<Book> findBooksByTitleStartingWith(String titleBySearch) {
        return booksRepository.findBooksByTitleStartingWith(titleBySearch);
    }
}
