package com.egg.biblioteca.repositories;


import com.egg.biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT l FROM Book l WHERE l.title = :title")
    public Book getByTitle(@Param("title") String title);

    @Query("SELECT l FROM Book l WHERE l.author.name = :name")
    public List<Book> getByAuthor(@Param("name") String name);

}
