package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Author;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("register")
    public String registerForm() {
        return "author_form.html";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String name) {
        try {
            authorService.createAuthor(name);
        } catch (MyException e) {
            Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, e);
            return "author_form.html";
        }
        return "index.html";
    }

    @GetMapping("/all")
    public String getAll(ModelMap model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "authors_list.html";
    }

}
