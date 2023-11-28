package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Long isbn;
    private String title;
    private Integer copies;
    @Temporal(TemporalType.DATE)
    private LocalDate alta;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

}
