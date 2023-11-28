package com.egg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.egg.biblioteca.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
