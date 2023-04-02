package ru.gyurii.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gyurii.springcourse.models.Book;
import ru.gyurii.springcourse.models.Person;
import ru.gyurii.springcourse.services.BooksService;
import ru.gyurii.springcourse.services.PeopleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;
    private PeopleService peopleService;

    @Autowired
    public BooksController(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "books_per_page", required = false) Integer booksPerPage,
                        @RequestParam(value = "sort_by_year", required = false) boolean sortByYear) {

        if (page == null || booksPerPage == null) {
            model.addAttribute("books", booksService.findAll(sortByYear));
        } else
            model.addAttribute("books", booksService.findWithPaginationAndSort(page, booksPerPage, sortByYear));

        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", booksService.findById(id));

        Person bookOwner = booksService.getBookOwner(id);

        if(bookOwner != null) {
            model.addAttribute("owner", bookOwner);
        } else {
            model.addAttribute("people", peopleService.findAll());
        }

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("newBook", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("newBook") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "books/new";

        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("editBook", booksService.findById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        booksService.update(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/addPerson")
    public String addPerson(@PathVariable int id, @ModelAttribute("addPerson") Person owner) {
        booksService.setBookOwner(id, owner);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/freeBook")
    public String freeBook(@PathVariable int id) {
        booksService.deleteBookOwner(id);
        return "redirect:/books/" + id;
    }


    @DeleteMapping("/{id}")
    private String delete(@PathVariable int id){
        booksService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    private String searchByTitle() {
        return "books/search";
    }

    @PostMapping("/search")
    private String search(Model model, @RequestParam("titleBySearch") String titleBySearch) {
        model.addAttribute("bookBySearch", booksService.findBooksByTitleStartingWith(titleBySearch));
        return "books/search";
    }
}
