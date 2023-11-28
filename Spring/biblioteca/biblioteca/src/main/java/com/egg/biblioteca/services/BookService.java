package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Author;
import com.egg.biblioteca.entities.Book;
import com.egg.biblioteca.entities.Publisher;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.AuthorRepository;
import com.egg.biblioteca.repositories.BookRepository;
import com.egg.biblioteca.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public void createBook(Long isbn, String title, Integer copies, String idAuthor, String idPublisher) throws MyException {
        validate(isbn, title, copies, idAuthor, idPublisher);
        Author author = authorRepository.findById(idAuthor).get();
        Publisher publisher = publisherRepository.findById(idPublisher).get();

        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setCopies(copies);
        book.setAlta(LocalDate.now());
        book.setAuthor(author);
        book.setPublisher(publisher);

        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void updateBook(Long isbn, String title, String idAuthor, String idPublisher, Integer copies) throws MyException {
        validate(isbn, title, copies, idAuthor, idPublisher);
        Optional<Book> response = bookRepository.findById(isbn);
        Optional<Author> responseAuthor = authorRepository.findById(idAuthor);
        Optional<Publisher> responsePublisher = publisherRepository.findById(idPublisher);

        Author author = new Author();
        Publisher publisher = new Publisher();

        if (responseAuthor.isPresent()) {
            author = responseAuthor.get();
        }
        if (responsePublisher.isPresent()) {
            publisher = responsePublisher.get();
        }
        if (response.isPresent()) {
            Book book = response.get();
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setCopies(copies);
            bookRepository.save(book);
        }
    }

    private void validate(Long isbn, String title, Integer copies, String idAuthor, String idPublisher) throws MyException {
        if (isbn == null) throw new MyException("El isbn no puede ser nulo");
        if ( title == null || title.trim().isEmpty()) throw new MyException("El título no puede estar vacío o ser nulo");
        if (copies == null) throw new MyException("Ejemplares no puede estar vacío");
        if ( idAuthor == null || idAuthor.trim().isEmpty())
            throw new MyException("El id del autor no puede estar vacío");
        if (idPublisher == null || idPublisher.trim().isEmpty())
            throw new MyException("El id de la editorial no puede estar vacío");
    }


}
