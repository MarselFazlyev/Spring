package ru.fazlyev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fazlyev.dao.BookDAO;
import ru.fazlyev.models.Book;

@Controller
@RequestMapping("/books")
public class BooksController {

    private  BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO=bookDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books",bookDAO.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("book") Book book){
        return "books/new";
    }

    @PostMapping()
    public String postNewBook(@ModelAttribute("book") Book book) {
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book",bookDAO.showBook(id));
        return "books/show";
    }





}
