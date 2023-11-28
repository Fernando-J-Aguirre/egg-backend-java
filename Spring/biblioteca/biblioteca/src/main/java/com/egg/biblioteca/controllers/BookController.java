package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Author;
import com.egg.biblioteca.entities.Book;
import com.egg.biblioteca.entities.Publisher;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AuthorService;
import com.egg.biblioteca.services.BookService;
import com.egg.biblioteca.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/register")
    public String register(ModelMap model) {
        List<Author> authors = authorService.getAll();
        List<Publisher> publishers = publisherService.getAll();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        return "book_form.html";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam(required = false) Long isbn, @RequestParam String title, @RequestParam(required = false) Integer copies,
                               @RequestParam String idAuthor, @RequestParam String idPublisher, ModelMap modelMap) {
        try {
            bookService.createBook(isbn, title, copies, idAuthor, idPublisher);
            modelMap.put("success", "El libro fue cargado correctamente");
        } catch (MyException e) {
            List<Author> authors = authorService.getAll();
            List<Publisher> publishers = publisherService.getAll();
            modelMap.addAttribute("authors", authors);
            modelMap.addAttribute("publishers", publishers);
            modelMap.put("error", e.getMessage());
            return "book_form.html";
        }
        return "index.html";
    }

    @GetMapping("/all")
    public String getAll(ModelMap model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book_list.html";
    }


}
