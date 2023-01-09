package ru.fazlyev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fazlyev.dao.BookDAO;
import ru.fazlyev.dao.PersonDAO;
import ru.fazlyev.models.Book;
import ru.fazlyev.models.Person;

@Controller
@RequestMapping("/books")
public class BooksController {

    private BookDAO bookDAO;
    private PersonDAO personDAO;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String postNewBook(@ModelAttribute("book") Book book) {
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model,@ModelAttribute("person") Person person) {
        model.addAttribute("book", bookDAO.showBook(id));
        if (bookDAO.showBook(id).getOwner_id() != null) {
            model.addAttribute("person", personDAO.showPerson(bookDAO.showBook(id).getOwner_id()));
        } else {
            model.addAttribute("people",personDAO.index());
        }
        return "books/show";
    }

    @PatchMapping("/{id}/freeBook")
    public String freeBook(@PathVariable("id") int id) {
        bookDAO.freeBook(id);
        return "redirect:/books/{id}";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.showBook(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("book") Book book) {
        bookDAO.update(id,book);
        return "redirect:/books/{id}";

    }

    @PatchMapping("/{id}/assignOwner")
    public String assignOwner(@PathVariable("id") int id,@ModelAttribute("person") Person person){
        bookDAO.assignOwner(id,person.getId());
        return "redirect:/books/index";

    }

}
