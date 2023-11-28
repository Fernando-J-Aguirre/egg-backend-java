package libreria.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;
    private Boolean active;

    public Author() {
        this.books = new ArrayList<>();
        active = true;
    }

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        active = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", books=" + books + ", active=" + active + '}';
    }


}
