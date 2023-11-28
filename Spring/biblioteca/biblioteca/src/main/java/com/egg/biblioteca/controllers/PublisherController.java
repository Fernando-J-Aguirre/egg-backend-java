package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Publisher;
import com.egg.biblioteca.exceptions.MyException;
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
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/register")
    public String register(ModelMap model) {
        List<Publisher> publishers = publisherService.getAll();
        model.addAttribute("publishers", publishers);
        return "publisher_form.html";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String name, ModelMap model) {
        try {
            publisherService.createPublisher(name);
            model.addAttribute("success", "Editorial guardada con éxito");
        } catch (MyException e) {
            model.addAttribute("error", e.getMessage());
            return "publisher_form.html";
        }
        return "index.html";
    }

//    @GetMapping("/all")





}
