package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Publisher;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public void createPublisher(String name) throws MyException {
        validate(name);
        Publisher publisher = new Publisher();
        publisher.setName(name);

        publisherRepository.save(publisher);
    }

    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public void updatePublisher(String id, String name) throws MyException {
        validate(name);
        Optional<Publisher> response = publisherRepository.findById(id);
        if (response.isPresent()) {
            Publisher publisher = response.get();
            publisher.setName(name);
            publisherRepository.save(publisher);
        }
    }

    private void validate(String name) throws MyException {
        if (name == null || name.trim().isEmpty()) throw new MyException("El nombre de la editorial no puede estar vacío");
    }

}
