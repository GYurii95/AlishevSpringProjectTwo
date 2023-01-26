package ru.gyurii.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gyurii.springcourse.dao.BookDAO;
import ru.gyurii.springcourse.models.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "books/new";

        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/edit";

        bookDAO.update(id, book);
        return "redirect:/books";
    }
}
