package ru.fazlyev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fazlyev.dao.PersonDAO;
import ru.fazlyev.models.Person;

@Component
@RequestMapping("/people")
public class PeopleController {
    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDAO.showPerson(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute ("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }






}
