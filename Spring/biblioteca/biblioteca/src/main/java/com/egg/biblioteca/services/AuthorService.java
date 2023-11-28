package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Author;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void createAuthor(String name) throws MyException {
        validate(name);
        Author author = new Author();
        author.setName(name);

        authorRepository.save(author);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public void updateAuthor(String id, String name) throws MyException {
        validate(name);
        Optional<Author> response = authorRepository.findById(id);
        if (response.isPresent()) {
            Author author = response.get();
            author.setName(name);
            authorRepository.save(author);
        }
    }

    private void validate(String name) throws MyException {
        if (name == null || name.trim().isEmpty()) throw new MyException("El nombre no puede estar vacío");
    }


}
